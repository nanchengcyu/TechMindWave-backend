package com.nanchengyu.nanchengyubi.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;

import com.nanchengyu.nanchengyubi.annotation.AuthCheck;
import com.nanchengyu.nanchengyubi.common.BaseResponse;
import com.nanchengyu.nanchengyubi.common.DeleteRequest;
import com.nanchengyu.nanchengyubi.common.ErrorCode;
import com.nanchengyu.nanchengyubi.common.ResultUtils;
import com.nanchengyu.nanchengyubi.constant.CommonConstant;
import com.nanchengyu.nanchengyubi.constant.UserConstant;
import com.nanchengyu.nanchengyubi.exception.BusinessException;
import com.nanchengyu.nanchengyubi.exception.ThrowUtils;
import com.nanchengyu.nanchengyubi.manager.AiManager;
import com.nanchengyu.nanchengyubi.manager.RedisLimiterManager;
import com.nanchengyu.nanchengyubi.model.dto.Essay.EssayAddRequest;
import com.nanchengyu.nanchengyubi.model.dto.Essay.EssayEditRequest;
import com.nanchengyu.nanchengyubi.model.dto.Essay.EssayQueryRequest;
import com.nanchengyu.nanchengyubi.model.dto.Essay.EssayUpdateRequest;

import com.nanchengyu.nanchengyubi.model.entity.Chart;
import com.nanchengyu.nanchengyubi.model.entity.Essay;
import com.nanchengyu.nanchengyubi.model.entity.User;
import com.nanchengyu.nanchengyubi.model.vo.BiResponse;
import com.nanchengyu.nanchengyubi.model.vo.EssayResponse;
import com.nanchengyu.nanchengyubi.service.AiFrequencyService;
import com.nanchengyu.nanchengyubi.service.EssayService;
import com.nanchengyu.nanchengyubi.service.UserService;
import com.nanchengyu.nanchengyubi.utils.SqlUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


/**
 * 文章接口
 */
@RestController
@RequestMapping("/essay")
@Slf4j
@CrossOrigin(origins = {"https://techmindwave.nanchengyu.cn", "http://localhost:800"}, allowCredentials = "true")
public class EssayController {
    @Autowired
    AiFrequencyService aiFrequencyService;

    @Resource
    RedisLimiterManager redisLimiterManager;
    @Resource
    private EssayService essayService;

    @Resource
    private UserService userService;

    @Resource
    private AiManager aiManager;

    private final static Gson GSON = new Gson();

    // region 增删改查
    @PostMapping("/gen")
    @AuthCheck(mustRole = UserConstant.DEFAULT_ROLE)
    public BaseResponse<EssayResponse> genEssay(
            final EssayAddRequest essayAddRequest,
            HttpServletRequest request) {

        User loginUser = userService.getLoginUser(request);
        // 增加限流器
        redisLimiterManager.doRateLimit("genEssayByAi_" + loginUser.getId());
        // AI
        String genResult = aiManager.sendMesToAIUseXingHuo(AiManager.ESSAY_PRECONDITION + essayAddRequest.getEssayName() + "文章的类型是：" + essayAddRequest.getEssayType());
        Essay essay = Essay.builder()
                .genEssay(genResult)
                .essayName(essayAddRequest.getEssayName())
                .essayType(essayAddRequest.getEssayType())
                .userId(loginUser.getId())
                .build();
        essayService.save(essay);
        EssayResponse essayResponse = EssayResponse.builder()
                .essayContent(genResult)
                .essayTitle(essayAddRequest.getEssayName())
                .essayType(essayAddRequest.getEssayType())
                .build();
        //调用ai次数减一
        boolean invokeAutoDecrease = aiFrequencyService.invokeAutoDecrease(loginUser.getId());
        ThrowUtils.throwIf(!invokeAutoDecrease, ErrorCode.PARAMS_ERROR, "次数减一失败");
        return new BaseResponse<>(essayResponse);
    }

    /**
     * 创建
     *
     * @param essayAddRequest
     * @param request
     * @return
     */
    @PostMapping("/add")
    public BaseResponse<Long> addEssay(@RequestBody EssayAddRequest essayAddRequest, HttpServletRequest request) {
        if (essayAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Essay essay = new Essay();
        BeanUtils.copyProperties(essayAddRequest, essay);
        User loginUser = userService.getLoginUser(request);
        essay.setUserId(loginUser.getId());
        boolean result = essayService.save(essay);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        long newEssayId = essay.getId();
        return ResultUtils.success(newEssayId);
    }

    /**
     * 删除
     *
     * @param deleteRequest
     * @param request
     * @return
     */
    @PostMapping("/delete")
    public BaseResponse<Boolean> deleteEssay(@RequestBody DeleteRequest deleteRequest, HttpServletRequest request) {
        if (deleteRequest == null || deleteRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        long id = deleteRequest.getId();
        getLoginUserAndCheck(id, request);
        boolean b = essayService.removeById(id);
        return ResultUtils.success(b);
    }

    /**
     * 更新（仅管理员）
     *
     * @param essayUpdateRequest
     * @return
     */
    @PostMapping("/update")
    @AuthCheck(mustRole = UserConstant.ADMIN_ROLE)
    public BaseResponse<Boolean> updateEssay(@RequestBody EssayUpdateRequest essayUpdateRequest) {
        if (essayUpdateRequest == null || essayUpdateRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        //Essay essay = new Essay(essayUpdateRequest.getId(), essayUpdateRequest.getTitle(), essayUpdateRequest.getContent(), GSON.toJson(Optional.ofNullable(tags).orElse(Collections.emptyList())));

        Essay essay = new Essay();
        long id = essayUpdateRequest.getId();
        // 判断是否存在
        Essay oldEssay = essayService.getById(id);
        ThrowUtils.throwIf(oldEssay == null, ErrorCode.NOT_FOUND_ERROR);
        boolean result = essayService.updateById(essay);
        return ResultUtils.success(result);
    }

    /**
     * 根据 id 获取
     *
     * @param id
     * @return
     */
    @GetMapping("/get")
    public BaseResponse<Essay> getEssayById(long id, HttpServletRequest request) {
        if (id <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        Essay essay = essayService.getById(id);
        if (essay == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(essay);
    }

    /**
     * 分页获取列表（封装类）
     *
     * @param essayQueryRequest
     * @return
     */
    @PostMapping("/list/page")
    public BaseResponse<Page<Essay>> listEssayByPage(@RequestBody EssayQueryRequest essayQueryRequest) {
        long current = essayQueryRequest.getCurrent();
        long size = essayQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Essay> essayPage = essayService.page(new Page<>(current, size),
                getQueryWrapper(essayQueryRequest));

        for (Essay essay : essayPage.getRecords()) {
            Long userId = essay.getUserId();
            User user = userService.getById(userId); // 假设userService是对用户表的服务
            essay.setUser(user);
        }
        return ResultUtils.success(essayPage);
    }

    /**
     * 分页获取当前用户创建的资源列表
     *
     * @param essayQueryRequest
     * @param request
     * @return
     */
    @PostMapping("/my/list/page")
    public BaseResponse<Page<Essay>> listMyEssayByPage(@RequestBody EssayQueryRequest essayQueryRequest,
                                                       HttpServletRequest request) {
        if (essayQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        User loginUser = userService.getLoginUser(request);
        essayQueryRequest.setUserId(loginUser.getId());
        long current = essayQueryRequest.getCurrent();
        long size = essayQueryRequest.getPageSize();
        // 限制爬虫
        ThrowUtils.throwIf(size > 20, ErrorCode.PARAMS_ERROR);
        Page<Essay> essayPage = essayService.page(new Page<>(current, size),
                getQueryWrapper(essayQueryRequest));
        return ResultUtils.success(essayPage);
    }


    /**
     * 编辑（用户）
     *
     * @param essayEditRequest
     * @param request
     * @return
     */
    @PostMapping("/edit")
    public BaseResponse<Boolean> editEssay(@RequestBody EssayEditRequest essayEditRequest, HttpServletRequest request) {
        if (essayEditRequest == null || essayEditRequest.getId() <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        Essay essay = new Essay();
        BeanUtils.copyProperties(essayEditRequest, essay);
        User loginUser = userService.getLoginUser(request);
        Long id = essayEditRequest.getId();
        //判断文章是否存在
        Essay oldEssay = essayService.getById(id);
        ThrowUtils.throwIf(oldEssay == null, ErrorCode.NOT_FOUND_ERROR);

        //仅本人或管理员可编辑
        if (!oldEssay.getUserId().equals(loginUser.getId()) && !userService.isAdmin(loginUser)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }

        boolean result = essayService.updateById(essay);
        return ResultUtils.success(result);
    }

    /**
     * 获取登录的 user 同时 检查 user 是否存在
     *
     * @param userId
     * @param request
     */
    private void getLoginUserAndCheck(final long userId, final HttpServletRequest request) {
        final User loginUser = userService.getLoginUser(request);
        // 判断是否存在
        final Essay oldEssay = essayService.getById(userId);
        ThrowUtils.throwIf(oldEssay == null, ErrorCode.NOT_FOUND_ERROR);
        // 仅本人或管理员可编辑
        if (!oldEssay.getUserId().equals(loginUser.getId()) && !userService.isAdmin(loginUser)) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
    }


    /**
     * 获取查询包装类
     *
     * @param essayQueryRequest 图表查询条件
     * @return 查询结果
     */
    private QueryWrapper<Essay> getQueryWrapper(EssayQueryRequest essayQueryRequest) {

        QueryWrapper<Essay> queryWrapper = new QueryWrapper<>();
        if (essayQueryRequest == null) {
            return queryWrapper;
        }
        Long id = essayQueryRequest.getId();
        String essayName = essayQueryRequest.getEssayName();
        String essayType = essayQueryRequest.getEssayType();
        Long userId = essayQueryRequest.getUserId();
        String sortField = essayQueryRequest.getSortField();
        String sortOrder = essayQueryRequest.getSortOrder();
        // 根据前端传来条件进行拼接查询条件
        queryWrapper.eq(id != null && id > 0, "id", id);
        queryWrapper.like(ObjectUtils.isNotEmpty(essayName), "essayName", essayName);
        queryWrapper.eq(ObjectUtils.isNotEmpty(essayType), "essayType", essayType);
        queryWrapper.eq(ObjectUtils.isNotEmpty(userId), "userId", userId);
        queryWrapper.eq("isDelete", false);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_ASC),
                sortField);
        return queryWrapper;
    }

}
