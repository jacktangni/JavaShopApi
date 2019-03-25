package com.httpapi.yyy.service.Impl;

import com.httpapi.yyy.bean.Cart;
import com.httpapi.yyy.bean.Commodity;
import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.dao.CartDao;
import com.httpapi.yyy.service.CartService;
import com.httpapi.yyy.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("cartService")
public class CartServiceImpl implements CartService {
    @Autowired
    private CartDao cartDao;

    @Override
    public Result addCart(int userid, int shopid) {
        try{
           cartDao.addCart(userid,shopid);
        }catch (Exception e){
            return  ResultUtil.error("添加失败");
        }
        return ResultUtil.success("添加成功");
    }

    @Override
    public Result selectCartInfo(int userid) {
        List<HashMap<String,Object>> selectCart=cartDao.selectCartInfo(userid);
        return selectCart.isEmpty() ? ResultUtil.error("获取购物车商品失败") : ResultUtil.success(selectCart);
    }

    @Override
    public Result deleteCartInfo(int cid) {
        try{
            cartDao.deleteCartInfo(cid);
        }catch (Exception e){
            return ResultUtil.error(e.getMessage());
        }
        return ResultUtil.success("删除成功");
    }

    @Override
    public Result checkCart(int userid, int shopid) {
        List<HashMap<String,Object>> checkCart=cartDao.checkCart(userid,shopid);
        return checkCart.isEmpty() ? ResultUtil.error("商品没有添加") : ResultUtil.success("商品已经添加");
    }
}
