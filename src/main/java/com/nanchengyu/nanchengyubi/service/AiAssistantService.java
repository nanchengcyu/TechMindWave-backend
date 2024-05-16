package com.nanchengyu.nanchengyubi.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nanchengyu.nanchengyubi.common.BaseResponse;
import com.nanchengyu.nanchengyubi.model.dto.aiassistant.AiAssistantQueryRequest;
import com.nanchengyu.nanchengyubi.model.entity.AiAssistant;

/**
* @author nanchengyu
* @description 针对表【ai_assistant(AI 问答助手信息表)】的数据库操作Service
* @createDate 2023-06-25 18:54:46
*/
public interface AiAssistantService extends IService<AiAssistant> {



}
