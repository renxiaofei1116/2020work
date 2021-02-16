package com.renxf.order.feign;


import com.renxf.common.pojo.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "service-product",fallback = ProductFeignFallBack.class)
public interface ProductFeign {
    @RequestMapping("/product/queryByid/{id}")
    public Products queryById(@PathVariable Integer id);
}
