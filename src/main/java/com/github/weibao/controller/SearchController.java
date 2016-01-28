package com.github.weibao.controller;

import com.github.weibao.Contants;
import com.github.weibao.model.City;
import com.github.weibao.model.County;
import com.github.weibao.model.Province;
import com.github.weibao.model.ext.AgencyItemsExt;
import com.github.weibao.service.AgencyItemsExtService;
import com.github.weibao.service.CityService;
import com.github.weibao.service.CountyService;
import com.github.weibao.service.ProvinceService;
import com.github.weibao.utils.Json;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by dongzhukai on 16/1/9.
 */
@Controller
@RequestMapping("search")
public class SearchController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(ReleaseController.class);

    @Autowired
    private ProvinceService provinceService;

    @Autowired
    private CityService cityService;

    @Autowired
    private CountyService countyService;


    @Autowired
    private AgencyItemsExtService agencyItemsExtService;

    @RequestMapping("table")
    public String searchTable(@RequestParam("provincecode") String provincecode,
                              @RequestParam("nowpage") String mypage,
                              @RequestParam("city") String city,
                              @RequestParam("searchKey") String searchKey,
                              ModelMap modelMap) {
        //获取省
        List<Province> provinceList = provinceService.getAllProvince();
        modelMap.addAttribute("provinceList", provinceList);
        //通过code查询点击的省份名称
        Province province = provinceService.getProvinceByCode(provincecode);
        //获取市区
        List citylist = null;
        String cityCode = null;
        if (provincecode.equals("110000")) {//过滤直辖市
            cityCode = "110100";
            citylist = countyService.getCountyByCityCode(cityCode);
        }else if (provincecode.equals("120000")) {
            cityCode = "120100";
            citylist = countyService.getCountyByCityCode(cityCode);
        }else if (provincecode.equals("310000")) {
            cityCode = "310100";
            citylist = countyService.getCountyByCityCode(cityCode);
        }else if (provincecode.equals("500000")) {
            cityCode = "500100";
            citylist = countyService.getCountyByCityCode(cityCode);
        }
        else {
            citylist = cityService.getCityByProvinceCode(provincecode);
        }
        modelMap.addAttribute("citylist", citylist);

        //获取每页显示数据个数
        int dbnumber = Contants.DBNUMBER;
        //当前页码
        int nowpage = Integer.parseInt(mypage);
        //第一条数据的索引
        int firstdb = (nowpage - 1) * 10;
        //模糊查询用到
        String infoext = "%" + searchKey.replace(" ","") + "%";
        String cityext = "%" + city + "%";
        //获取页码总数
        int page = agencyItemsExtService.getPageNumber(provincecode, infoext, cityext, dbnumber);
        //获取所有信息
        logger.debug("参数:provincecode" + provincecode + ",infoext:" + infoext + ",cityext:" + cityext + ",firstdb:" + firstdb + ",dbnumber:" + dbnumber);
        List<AgencyItemsExt> selectlist = agencyItemsExtService.selectAll(provincecode, infoext, cityext, firstdb, dbnumber);
        modelMap.addAttribute("province", province);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("nowpage", nowpage);
        modelMap.addAttribute("provincecode", provincecode);
        modelMap.addAttribute("info", searchKey);
        modelMap.addAttribute("city", city);
        modelMap.addAttribute("selectlist", selectlist);

        return "search-table";
    }

    @RequestMapping(value = "/getCityByProvinceIdJson/{id}")
    @ResponseBody
    public Json getCityByProvinceIdJson(@PathVariable("id") String id) {
        logger.info("------this is getCityByProvinceId INFO-----");
        //获取市区
        List cityList = null;
        String cityCode = null;
        if (id.equals("110000")) {//过滤直辖市
            cityCode = "110100";
            cityList = countyService.getCountyByCityCode(cityCode);
        }else if (id.equals("120000")) {
            cityCode = "120100";
            cityList = countyService.getCountyByCityCode(cityCode);
        }else if (id.equals("310000")) {
            cityCode = "310100";
            cityList = countyService.getCountyByCityCode(cityCode);
        }else if (id.equals("500000")) {
            cityCode = "500100";
            cityList = countyService.getCountyByCityCode(cityCode);
        }
        else {
            cityList = cityService.getCityByProvinceCode(id);
        }
        if (cityList != null) {
            return new Json(true, "success", cityList);
        } else {
            return new Json(false, "fail", null);
        }
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
