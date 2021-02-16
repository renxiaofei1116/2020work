package com.renxf.order.controller;

import com.renxf.order.feign.ProductFeign;
import com.renxf.common.pojo.Orders;
import com.renxf.common.pojo.OrdersProRecord;
import com.renxf.common.pojo.Products;


import com.renxf.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private ProductFeign productFeign;
    @Autowired
    private OrdersService ordersService;

    @RequestMapping("/query/{id}")
    public Orders query(@PathVariable Integer id){
        List<OrdersProRecord> ordersProRecords = ordersService.selectById(id);
        List<Products> products = new ArrayList<>();
        for(OrdersProRecord record:ordersProRecords){
            products.add(productFeign.queryById(record.getProId()));
        }
        Orders orders = ordersService.selectOrderById(id);
        orders.setProductsList(products);
        return orders;
    }
}
