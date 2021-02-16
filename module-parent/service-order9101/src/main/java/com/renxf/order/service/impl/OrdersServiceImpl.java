package com.renxf.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.renxf.common.pojo.Orders;
import com.renxf.common.pojo.OrdersProRecord;
import com.renxf.order.mapper.OrderMapper;
import com.renxf.order.mapper.OrderMapper1;
import com.renxf.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderMapper1 orderMapper1;
    @Override
    public List<OrdersProRecord> selectById(Integer id) {
        QueryWrapper<OrdersProRecord> ordersProRecordQueryWrapper = new QueryWrapper<>();
        ordersProRecordQueryWrapper.eq("ord_id",id);
        List<OrdersProRecord> ordersProRecords = orderMapper.selectList(ordersProRecordQueryWrapper);
        return ordersProRecords;
    }

    @Override
    public Orders selectOrderById(Integer id) {
        Orders orders = orderMapper1.selectById(id);
        return orders;
    }
}
