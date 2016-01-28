package com.github.weibao.service;

import com.github.weibao.model.City;
import com.github.weibao.test.unit.BaseUnitTest;
import com.github.weibao.utils.Json;
import com.sun.deploy.net.HttpResponse;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.web.servlet.HttpServletBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by zwd-apple on 2016/1/7.
 */
public class CityServiceTest extends BaseUnitTest{
    @Autowired
    private CityService cityService;

    @Test
    public void testGetCityByProvinceCode() throws Exception {
        String provinceCode = "130000"; //beijing
        List<City> list = cityService.getCityByProvinceCode(provinceCode);
        Assert.assertEquals(11,list.size());
    }




}