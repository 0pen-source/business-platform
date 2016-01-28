package com.github.weibao.model.ext;


import com.github.weibao.model.City;
import com.github.weibao.model.County;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/7.
 */
public class CityExt extends City {
    private List<County> countyList;

    public List<County> getCountyList() {

        return countyList;
    }

    public void setCountyList(List<County> countyList) {
        this.countyList = countyList;
    }

    // TODO: 16/1/17 城市和县区是一对多的关系,应该用集合处理
//    private County county;
//
//    public County getCounty() {
//        return county;
//    }
//
//    public void setCounty(County county) {
//        this.county = county;
//    }
}
