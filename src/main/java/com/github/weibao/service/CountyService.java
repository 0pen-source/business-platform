package com.github.weibao.service;

import com.github.weibao.mapper.CountyMapper;
import com.github.weibao.model.County;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Create 16/1/17,下午7:00
 * @Author dongzhukai
 */
@Service
public class CountyService {
    @Autowired
    CountyMapper countyMapper;

      public List<County> getCountyByCityCode(String cityCode) {
        County county = new County();
        county.setCitycode(cityCode);
        List<County> countyList = countyMapper.select(county);
        return  countyList;
    }
}
