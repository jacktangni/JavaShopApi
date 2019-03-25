package com.httpapi.yyy.bean;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Cart {
    private int id;
    private int commodity_id;
    private int user_id;
    private String cart_nums;

}
