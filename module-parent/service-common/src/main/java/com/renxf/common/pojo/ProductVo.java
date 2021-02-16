package com.renxf.common.pojo;

import lombok.Data;

@Data
public class ProductVo {
    private String name;
    private String type;
    private double startprice;
    private double endprice;
    private int stock;
    private int flag=-1;
}
