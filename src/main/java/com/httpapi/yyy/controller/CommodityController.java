package com.httpapi.yyy.controller;

import com.httpapi.yyy.bean.Commodity;
import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.service.CommodityService;
import com.httpapi.yyy.service.Impl.CommodityServiceImpl;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/commodity")
public class CommodityController {

    @Autowired
    private CommodityServiceImpl commodityService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ApiOperation(value="根据page获取分页数据", notes="根据page获取分页数据")
    @ApiImplicitParam(name = "page", value = "分页的页码", required = true, dataType = "int",paramType="query")
    public Result index(@RequestParam(value = "page", required = true, defaultValue = "0") int page) {
        return commodityService.getCommodityIndex(page);
    }
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation(value="根据id进入商品详情", notes="根据id进入商品详情")
    @ApiImplicitParam(name = "id", value = "商品的id", required = true, dataType = "int",paramType="query")
    public Result info (@RequestParam(value = "id", required = true) int id) {
        return commodityService.getCommodityInfo(id);
    }
    @RequestMapping(value = "/class", method = RequestMethod.GET)
    @ApiOperation(value="根据名称来获得商品", notes="根据名称来获得商品")
    @ApiImplicitParam(name = "brand", value = "产品的品牌中文名称", required = true, dataType = "String",paramType="query")
    public Result CommodityByClass(@RequestParam(value = "brand", required = true) String brand) {
        return commodityService.getCommodityByClass(brand);
    }

}
