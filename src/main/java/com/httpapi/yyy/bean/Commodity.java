package com.httpapi.yyy.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Commodity {
    private int id;
    private String commodity_name;
    private double commodity_nowprice;
    private String commodity_brand;
    private String commodity_stock;
    private double commodity_oldprivce;
    private String commodity_sales;
    private String commodity_main;
    private String commodity_thumbnail;
    private String commodity_attachimg;
    private String commodity_content;
}
