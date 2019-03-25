package com.httpapi.yyy.controller;

import com.alibaba.fastjson.JSONArray;
import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.service.Impl.OrderServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    @ApiOperation(value="提交订单", notes="提交订单")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "order", value = "订单信息<数组>", required = true, dataType = "List",paramType = "query"),
            @ApiImplicitParam(name = "orderTotal", value = "购物车所有商品总价", required = true, dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "money", value = "用户账户余额", required = true, dataType = "int",paramType = "query")
    })
    public Result addOrder(@RequestBody Map<String,String> order) {
        List<HashMap> orderInfo= JSONArray.parseArray(order.get("order"),HashMap.class);
        System.out.println(orderInfo);
        return orderService.addOrder(orderInfo,Integer.parseInt(order.get("orderTotal")),Integer.parseInt(order.get("money")));
    }
    @RequestMapping(value = "/checkOrder", method = RequestMethod.POST)
    @ApiOperation(value="查看订单状态", notes="查看订单状态")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户id", required = true, dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "status", value = "订单状态id", required = true, dataType = "String",paramType = "query")
    })
    public Result checkOrder(@RequestBody Map<String,String> cart) {
        return orderService.checkOrder(Integer.parseInt(cart.get("userid")),cart.get("status"));
    }
}
