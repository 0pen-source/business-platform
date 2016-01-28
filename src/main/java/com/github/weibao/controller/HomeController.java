package com.github.weibao.controller;

import com.github.weibao.model.Province;
import com.github.weibao.service.AgencyItemsExtService;
import com.github.weibao.service.CityService;
import com.github.weibao.service.CountyService;
import com.github.weibao.service.ProvinceService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.omg.CORBA.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by chenkaihua on 15-12-15.
 */
@Controller
@RequestMapping("")
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    ProvinceService provinceService;
    @Autowired
    CityService cityService;
    @Autowired
    CountyService countyService;
    @Autowired
    AgencyItemsExtService agencyItemsExtService;

    @RequestMapping("")
    public String home(Model model) {
        List<Province> provinceList = provinceService.getAllProvince();
        model.addAttribute("provinceList", provinceList);
        return "home";
    }
    @RequestMapping("test")
    public String test() {

        return "test";
    }
    @RequestMapping("testme")
    public String testinfo(@RequestParam("name")String name, @RequestParam("file")MultipartFile file, ModelMap modelMap){
        System.out.println(name);
//        System.out.println("文件长度: " + file.getSize());
//        System.out.println("文件类型: " + file.getContentType());
//        System.out.println("文件名称: " + file.getName());
//        System.out.println("文件原名: " + file.getOriginalFilename());
//        System.out.println(file);
//        CommonsMultipartFile cf= (CommonsMultipartFile)file;
//        DiskFileItem fi = (DiskFileItem)cf.getFileItem();
//        File f = fi.getStoreLocation();
//        String aa=test.getImageBinary(f);
//        System.out.println(aa);

        try {
            InputStream is= file.getInputStream();
            String aa=test.getImageBinary(is);
            test.base64StringToImage(aa);
        System.out.println(aa);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "test";
    }
}
