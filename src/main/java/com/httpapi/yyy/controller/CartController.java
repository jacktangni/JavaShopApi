package com.httpapi.yyy.controller;

import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.service.Impl.CartServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartServiceImpl cartService;

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    @ApiOperation(value="添加购物车", notes="添加购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户id", required = true, dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "shopid", value = "商品id", required = true, dataType = "int",paramType = "query")
    })
    public Result addCart(@RequestBody Map<String,String> cart) {
        return cartService.addCart(Integer.parseInt(cart.get("userid")),Integer.parseInt(cart.get("shopid")));
    }
    @RequestMapping(value = "/selectCart", method = RequestMethod.POST)
    @ApiOperation(value="添加购物车", notes="添加购物车")
    @ApiImplicitParam(name = "userid", value = "用户id", required = true, dataType = "int",paramType = "query")
    public Result selectCart(@RequestBody Map<String,String> cart) {
        return cartService.selectCartInfo(Integer.parseInt(cart.get("userid")));
    }
    @RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
    @ApiOperation(value=" 删除用户购物车的商品", notes=" 删除用户购物车的商品")
    @ApiImplicitParam(name = "cid ", value = "购物车表的id", required = true, dataType = "int",paramType = "query")
    public Result deleteCart(@RequestBody Map<String,String> cart) {
        return cartService.deleteCartInfo(Integer.parseInt(cart.get("cid")));
    }
    @RequestMapping(value = "/checkCart", method = RequestMethod.POST)
    @ApiOperation(value="检查商品是否已经被添加过购物车", notes="检查商品是否已经被添加过购物车")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userid", value = "用户id", required = true, dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "shopid", value = "商品id", required = true, dataType = "int",paramType = "query")
    })
    public Result checkCart(@RequestBody Map<String,String> cart) {
        return cartService.checkCart(Integer.parseInt(cart.get("userid")),Integer.parseInt(cart.get("shopid")));
    }
}
