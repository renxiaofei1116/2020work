package com.renxf.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.renxf.common.pojo.ProductVo;
import com.renxf.common.pojo.Products;
import com.renxf.product.mapper.ProductMapper;
import com.renxf.product.service.ProductService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public Products selectById(Integer id) {
        return  productMapper.selectById(id);
    }

    @Override
    public Integer deleteById(Integer id) {
        return productMapper.deleteById(id);
    }

    @Override
    public Integer updateById(Products products) {
        return productMapper.updateById(products);
    }

    @Override
    public void selectBycondit(Page<Products> pageProduct, ProductVo productVo) {
        QueryWrapper<Products> queryWrapper = new QueryWrapper<>();
        if(productVo==null){
            productMapper.selectPage(pageProduct,queryWrapper);
        }
        String name=productVo.getName();
        Double startprice = productVo.getStartprice();
        Double endprice = productVo.getEndprice();
        Integer flag = productVo.getFlag();
        Integer stock = productVo.getStock();
        String type = productVo.getType();
        if(!StringUtils.isEmpty(name)){
            queryWrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(type)){
            queryWrapper.like("goods_type",type);
        }
        if(endprice!=0){
            queryWrapper.le("price",endprice);
        }
        if(flag>=0){
            queryWrapper.eq("flag",flag);
        }
        queryWrapper.ge("goods_stock",stock);
        queryWrapper.ge("price",startprice);
        productMapper.selectPage(pageProduct,queryWrapper);
    }
}
