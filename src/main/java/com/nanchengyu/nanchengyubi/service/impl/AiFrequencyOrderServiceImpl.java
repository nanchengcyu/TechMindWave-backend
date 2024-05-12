package com.nanchengyu.nanchengyubi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanchengyu.nanchengyubi.constant.CommonConstant;
import com.nanchengyu.nanchengyubi.common.ErrorCode;
import com.nanchengyu.nanchengyubi.exception.BusinessException;
import com.nanchengyu.nanchengyubi.exception.ThrowUtils;
import com.nanchengyu.nanchengyubi.mapper.AiFrequencyOrderMapper;
import com.nanchengyu.nanchengyubi.model.dto.order.AiFrequencyOrderQueryRequest;
import com.nanchengyu.nanchengyubi.model.dto.order.AiFrequencyOrderUpdateRequest;
import com.nanchengyu.nanchengyubi.model.entity.AiFrequencyOrder;
import com.nanchengyu.nanchengyubi.model.entity.User;
import com.nanchengyu.nanchengyubi.model.enums.PayOrderEnum;
import com.nanchengyu.nanchengyubi.service.AiFrequencyOrderService;
import com.nanchengyu.nanchengyubi.service.UserService;
import com.nanchengyu.nanchengyubi.utils.SqlUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author nanchengyu
 * @description 针对表【ai_frequency_order(次数订单表)】的数据库操作Service实现
 * @createDate 2023-07-12 17:05:42
 */
@Service
public class AiFrequencyOrderServiceImpl extends ServiceImpl<AiFrequencyOrderMapper, AiFrequencyOrder>
        implements AiFrequencyOrderService {

    @Resource
    private UserService userService;


    /**
     * 分页获取订单列表
     *
     * @param orderQueryRequest
     * @return
     */
    public QueryWrapper<AiFrequencyOrder> getOrderQueryWrapper(AiFrequencyOrderQueryRequest orderQueryRequest) {

        Long id = orderQueryRequest.getId();
        String sortField = orderQueryRequest.getSortField();
        String sortOrder = orderQueryRequest.getSortOrder();
        if (orderQueryRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数为空");
        }
        QueryWrapper<AiFrequencyOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(id != null, "id", id);
        queryWrapper.orderBy(SqlUtils.validSortField(sortField), sortOrder.equals(CommonConstant.SORT_ORDER_DESC),
                sortField);
        return queryWrapper;
    }

    /**
     * 修改订单
     *
     * @param orderUpdateRequest
     * @param request
     * @return
     */
    @Override
    public boolean updateOrderInfo(AiFrequencyOrderUpdateRequest orderUpdateRequest, HttpServletRequest request) {
        Long purchaseQuantity = orderUpdateRequest.getPurchaseQuantity();
        Long id = orderUpdateRequest.getId();
        User loginUser = userService.getLoginUser(request);
        if (id < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "订单不存在");
        }

        if (loginUser == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "用户未登录");
        }
        if (purchaseQuantity < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "输入正确的购买数量");
        }
        AiFrequencyOrder order = new AiFrequencyOrder();
        BeanUtils.copyProperties(orderUpdateRequest, order);
        order.setId(id);
        Double price = 0.01;
        order.setTotalAmount(purchaseQuantity * price);
        order.setOrderStatus(Integer.valueOf(PayOrderEnum.WAIT_PAY.getValue()));
        boolean result = this.updateById(order);
        ThrowUtils.throwIf(!result, ErrorCode.OPERATION_ERROR);
        return true;
    }
}




