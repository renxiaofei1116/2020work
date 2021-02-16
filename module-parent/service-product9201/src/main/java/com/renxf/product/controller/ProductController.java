package com.renxf.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.renxf.common.pojo.ProductVo;
import com.renxf.common.pojo.Products;
import com.renxf.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/queryByid/{id}")
    public Products  queryById(@PathVariable Integer id){
        Products products = productService.selectById(id);
        return products;
    }
    @Value("${server.port}")
    private String port;
    @RequestMapping("/port")
    public String queryport(){
        return port;
    }
    @RequestMapping("/deleteById/{id}")
    public String deleteById(@PathVariable Integer id){
        Integer integer = productService.deleteById(id);
        if(integer>0){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
    @RequestMapping("/updateById/")
    public String updateById(@RequestBody Products products){
        Integer integer = productService.updateById(products);
        if(integer>0){
            return "更新成功";
        }else{
            return "更新失败";
        }
    }
    @RequestMapping("/queryByCondition/{current}/{size}")
    public Map<String, Object> updateById(@PathVariable Integer current, @PathVariable Integer size, @RequestBody ProductVo productVo) {
        System.out.println(current);
        System.out.println(size);
        Page<Products> productsPage = new Page<>(current,size);
        productService.selectBycondit(productsPage,productVo);
        List<Products> products = productsPage.getRecords();
        long total = productsPage.getTotal();
        System.out.println(total);
        Map<String, Object> map = new HashMap<>();
        map.put("list",products);
        map.put("total",total);
        return map;
    }

}
