package com.httpapi.yyy.service;

import com.httpapi.yyy.bean.Commodity;
import com.httpapi.yyy.bean.Result;

import java.util.List;

public interface CommodityService {

    public Result getCommodityIndex (int page);

    Result getCommodityInfo(int id);

   /* Result getCommodityByBrand(String name);*/

    Result getCommodityByClass(String brand);
}
