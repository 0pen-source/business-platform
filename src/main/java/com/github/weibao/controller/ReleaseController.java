package com.github.weibao.controller;

import com.github.weibao.model.AgencyCompany;
import com.github.weibao.model.City;
import com.github.weibao.model.County;
import com.github.weibao.service.CityService;
import com.github.weibao.service.CompanyService;
import com.github.weibao.service.CountyService;
import com.github.weibao.service.ProvinceService;
import com.github.weibao.utils.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dongzhukai on 16/1/9.
 */
@Controller
@RequestMapping("release")
public class ReleaseController {
    private Logger logger = LoggerFactory.getLogger(ReleaseController.class);
    @Autowired
    CompanyService companyService;
    @Autowired
    ProvinceService provinceService;
    @Autowired
    CityService cityService;
    @Autowired
    private CountyService countyService;

    @RequestMapping(value = "/release_addCompany/{companyName}")
    @ResponseBody
    public Json Release_addCompany(@PathVariable("companyName") String companyName) {
        logger.info("------Release_添加公司 INFO-----");
        System.out.println("--------" + companyName + "----------");
        Boolean companyBoolean = companyService.addCompanyOnRelease(companyName);
        AgencyCompany agencyCompany = new AgencyCompany();
        agencyCompany.setCompanyName(companyName);
        List<AgencyCompany> list = new ArrayList<AgencyCompany>();
        list.add(agencyCompany);
        if (companyBoolean == true) {
            return new Json(true, "success", list);
        }
        return new Json(false, "false", null);
    }

    /**
     * zwd
     * 根据省份获取城市
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getCityByProvinceId/{id}")
    @ResponseBody
    public Json getCityByProvinceId(@PathVariable("id") String id) {
        logger.info("------this is getCityByProvinceId INFO-----");
        List<City> cityList = cityService.getCityByProvinceCode(id);
        if (cityList != null) {
            return new Json(true, "success", cityList);
        } else {
            return new Json(false, "fail", null);
        }
    }

    /**
     * 根据城市获取区域
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/getAreaByCityId/{id}")
    @ResponseBody
    public Json getAreaByCityId(@PathVariable("id") String id) {
        List<County> areaList = countyService.getCountyByCityCode(id);
        if (areaList != null) {
            return new Json(true, "success", areaList);

        } else {
            return new Json(false, "fail", null);
        }
    }

}

