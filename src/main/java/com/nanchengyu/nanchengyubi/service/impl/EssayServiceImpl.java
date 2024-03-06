package com.nanchengyu.nanchengyubi.service.impl;




import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanchengyu.nanchengyubi.mapper.EssayMapper;
import com.nanchengyu.nanchengyubi.model.entity.Essay;
import com.nanchengyu.nanchengyubi.service.EssayService;

import org.springframework.stereotype.Service;

/**
* @author nanchengyu
* @description 针对表【essay(文章信息表)】的数据库操作Service实现
* @createDate 2024-03-06 09:55:21
*/
@Service
public class EssayServiceImpl extends ServiceImpl<EssayMapper, Essay>
    implements EssayService{

}




