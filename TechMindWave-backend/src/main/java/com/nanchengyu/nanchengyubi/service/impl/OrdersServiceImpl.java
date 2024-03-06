package com.nanchengyu.nanchengyubi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nanchengyu.nanchengyubi.model.entity.Orders;
import com.nanchengyu.nanchengyubi.service.OrdersService;
import com.nanchengyu.nanchengyubi.mapper.OrdersMapper;
import org.springframework.stereotype.Service;

/**
* @author MA_dou
* @description 针对表【orders(充值订单表)】的数据库操作Service实现
* @createDate 2023-07-06 20:36:41
*/
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders>
    implements OrdersService{

}




