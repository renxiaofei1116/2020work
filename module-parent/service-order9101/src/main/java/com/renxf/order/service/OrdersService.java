package com.renxf.order.service;

import com.renxf.common.pojo.Orders;
import com.renxf.common.pojo.OrdersProRecord;

import java.util.List;

public interface OrdersService {
    public List<OrdersProRecord> selectById(Integer id);
    public Orders selectOrderById(Integer id);
}
