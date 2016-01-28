package com.github.weibao.service;

import com.github.weibao.mapper.ProvinceMapper;
import com.github.weibao.model.Province;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/6.
 */
@Service
public class ProvinceService {
    @Autowired
    ProvinceMapper provinceMapper;

    public List<Province> getAllProvince() {
        List<Province> listProvince = provinceMapper.selectAll();
        return listProvince;
    }

    public Province getProvinceByCode(String optionvalue) {
        Province province=new Province();
        province.setCode(optionvalue);
       province=provinceMapper.selectOne(province);
        return province;
    }
}
