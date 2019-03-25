package com.httpapi.yyy.service.Impl;

import com.httpapi.yyy.bean.Commodity;
import com.httpapi.yyy.bean.Result;
import com.httpapi.yyy.dao.CommodityDao;
import com.httpapi.yyy.service.CommodityService;
import com.httpapi.yyy.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {

    @Autowired
    private CommodityDao commodityDao;


    @Override
    public Result getCommodityIndex(int page) {
        List<Commodity> ShopList = commodityDao.selectCommodity(page * 15, 15);
        return ShopList.isEmpty() ? ResultUtil.error("数据为空") : ResultUtil.success(ShopList);
    }

    @Override
    public Result getCommodityInfo(int id) {
        List<Commodity> CommodityInfo = commodityDao.getCommodityInfo(id);
        System.out.println(CommodityInfo.get(0).getCommodity_brand());
        return CommodityInfo.isEmpty() ? ResultUtil.error("商品不存在") : ResultUtil.success(CommodityInfo);
    }

   /* @Override
    public Result getCommodityByBrand(String name) {
        List<Commodity> CommodityByBrand=commodityDao.getCommodityByBrand(name);
        return CommodityByBrand.isEmpty()?ResultUtil.error("没有商品"): ResultUtil.success(CommodityByBrand);
    }*/

    @Override
    public Result getCommodityByClass(String brand) {
        List<Commodity> CommodityByClass=commodityDao.getCommodityByClass(brand);
        return CommodityByClass.isEmpty()?ResultUtil.error("没有这类商品"): ResultUtil.success(CommodityByClass);
    }

}
