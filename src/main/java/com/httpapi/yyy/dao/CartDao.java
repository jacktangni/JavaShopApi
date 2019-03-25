package com.httpapi.yyy.dao;

import com.httpapi.yyy.bean.Cart;
import com.httpapi.yyy.bean.Commodity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public interface CartDao {

    void addCart(int userid,int shopid);

    List<HashMap<String,Object>> selectCartInfo(int userid);

    void deleteCartInfo(int cid);

    List<HashMap<String,Object>> checkCart(int userid, int shopid);
}
