package com.httpapi.yyy.service.Impl;

import com.httpapi.yyy.bean.Order;
import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.dao.OrderDao;
import com.httpapi.yyy.service.OrderService;
import com.httpapi.yyy.util.MD5Utils;
import com.httpapi.yyy.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;


    @Override
    public Result checkOrder(int userid, String status) {
        List<HashMap<String,Object>> checkOrder=orderDao.checkOrderInfo(userid,status);
        return checkOrder.isEmpty() ? ResultUtil.error("订单没有完成") : ResultUtil.success(checkOrder);
    }

    @Override
    public Result addOrder(List<HashMap> orderInfo, int orderTotal, int money) {
         String orderNum=null;
        try{
           orderNum=String.valueOf(System.currentTimeMillis());
           orderDao.addOrder(orderInfo,orderNum);
            money=money-orderTotal;
            String userMoney=String.valueOf(money);
            Integer userid=(Integer)orderInfo.get(0).get("uid");
            orderDao.ChangeMoney(userid,userMoney);
            orderDao.deleteCart(userid);
         }catch (Exception e){
             return ResultUtil.error(e.getMessage());
         }
        return ResultUtil.success(orderNum);
    }


}
