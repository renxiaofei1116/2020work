package com.renxf.order.feign;

import com.renxf.common.pojo.Products;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignFallBack implements ProductFeign {
    @Override
    public Products queryById(Integer id) {
        return null;
    }
}
