package com.httpapi.yyy.service;

import com.httpapi.yyy.bean.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface OrderService {


    Result checkOrder(int userid, String status);


    Result addOrder(List<HashMap> orderInfo, int orderTotal, int money);
}
