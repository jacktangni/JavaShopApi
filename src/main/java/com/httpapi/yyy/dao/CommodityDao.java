package com.httpapi.yyy.dao;

import com.httpapi.yyy.bean.Commodity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("commodityDao")
public interface CommodityDao {
        List<Commodity> selectCommodity(int startPage, int totalPage);
        List<Commodity> getCommodityInfo(int id);
       /* List<Commodity> getCommodityByBrand(String name);*/
        List<Commodity> getCommodityByClass(String brand);
}
