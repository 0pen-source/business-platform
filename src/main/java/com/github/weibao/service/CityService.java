package com.github.weibao.service;

import com.github.weibao.mapper.CityExtMapper;
import com.github.weibao.mapper.CityMapper;
import com.github.weibao.model.City;
import com.github.weibao.model.ext.CityExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/7.
 */
@Service
public class CityService {
    @Autowired
    CityMapper cityMapper;

    @Autowired
    CityExtMapper cityExtMapper;

    public List<City> getAllCity() {
        List<City> listCity = cityMapper.selectAll();
        return listCity;
    }

    public List<City> getCityByProvinceCode(String provinceCode) {
        City city = new City();
        city.setProvincecode(provinceCode);
        List<City> cityList = cityMapper.select(city);
        return cityList;

    }

    public List<CityExt> selectExtList() {
        List<CityExt> listCityExt = cityExtMapper.selectExt();
        return listCityExt;
    }


}
