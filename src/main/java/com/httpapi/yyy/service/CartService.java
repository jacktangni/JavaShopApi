package com.httpapi.yyy.service;

import com.httpapi.yyy.bean.Result;

public interface CartService {
    /*添加购物车*/
    Result addCart(int userid, int shopid);
   /* 获取购物车里面的所有商品信息*/
    Result selectCartInfo(int userid);
   /*删除购物车里面的商品信息*/
    Result deleteCartInfo(int cid);
    /*检查购物车同类商品是否添加过*/
    Result checkCart(int userid,int shopid);
}
