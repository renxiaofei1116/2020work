package com.renxf.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.renxf.common.pojo.ProductVo;
import com.renxf.common.pojo.Products;

import java.util.List;

public interface ProductService {
    Products selectById(Integer id);
    Integer deleteById(Integer id);
    Integer updateById(Products product);
    void selectBycondit(Page<Products> pageProduct, ProductVo productVo);
}
