package com.httpapi.yyy.dao;

import com.httpapi.yyy.bean.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface OrderDao {

    List<HashMap<String,Object>> checkOrderInfo(int userid, String status);

    void getCartInfo(List<HashMap> orderInfo);

    void addOrder(List<HashMap> order, String orderNum);

    void ChangeMoney(int userid, String userMoney);

    void deleteCart(int userid);
}
