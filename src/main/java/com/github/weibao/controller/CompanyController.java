package com.github.weibao.controller;

import com.github.weibao.Contants;
import com.github.weibao.exception.FrontParameterException;
import com.github.weibao.exception.ServiceException;
import com.github.weibao.model.*;
import com.github.weibao.model.ext.AgencyCompanyExt;
import com.github.weibao.service.CompanyService;
import com.github.weibao.service.ItemsService;
import com.github.weibao.service.ProvinceService;
import com.github.weibao.service.StaffsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by zwd-apple on 2016/1/6.
 */
@RestController
@RequestMapping("company")
public class CompanyController {
    private Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    CompanyService companyService;

    @Autowired
    ItemsService itemsService;

    @Autowired
    StaffsService staffsService;

    @Autowired
    private ProvinceService provinceService;

    /**
     * zwd-apple
     * 公司信息插入
     *
     * @param company
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public AgencyCompanyExt insertCompany(AgencyCompanyExt company) throws Exception {
        if (null == company) {
            throw new Exception("页面传入参数为null.");
        }
        if (null == company.getCompanyName() || "".equals(company.getCompanyName())) {
            throw new Exception("页面传入公司名称为null.");
        }
        logger.debug("this is InsertCompany");
        Boolean isSucess = companyService.insertCompany(company);
        if (isSucess == true) {
            logger.debug("用户[" + company.getAccountId() + "]插入公司[" + company.getCompanyName() + "]成功!");

            return company;
        } else {
            logger.debug("用户[" + company.getAccountId() + "]插入公司[" + company.getCompanyName() + "]失败!");

            return null;
        }
    }

    /**
     * zwd-apple
     * 编辑公司信息初始化页面
     *
     * @return
     */
    @RequestMapping("/selectCompanyById")
    public AgencyCompany initCompany(AgencyCompany agencyCompany) throws FrontParameterException {
        if (null == agencyCompany ){
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        ModelAndView mv = new ModelAndView();
        //根据主键查询该公司
        agencyCompany = companyService.selectCompanyByPrimaryKey(agencyCompany.getCompanyId());
        mv.addObject("agencyCompany", agencyCompany);
        return agencyCompany;
    }

    /**
     * zwd-apple
     * 插入服务、编辑公司、插入联系人
     *
     * @return
     */
    @RequestMapping("/InsertIteamsAndEditCompany")

    public ModelAndView InsertIteamsAndEditCompany(AgencyCompany agencyCompany,
                                                   AgencyItems agencyItems,
                                                   AgencyStaffs agencyStaffs)throws FrontParameterException {
        logger.info("----------------Edit公司--------------");
        if (null == agencyCompany && null == agencyItems && null == agencyStaffs) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/");
        //更新公司信息
        companyService.updateCompany(agencyCompany);
        //插入服务信息
        itemsService.insertItems(agencyItems);
        //插入联系人信息
        staffsService.insertStaffs(agencyStaffs);
        return mv;
    }
    /**
     * zwd-apple
     *根据保存在sesison中的UsserID查询关联的所有公司
     * @return
     */
    @RequestMapping("/query")
    public ModelAndView selectCompany(HttpSession httpSession) throws Exception{
        logger.info("------------------------查询公司---------------------");
        int accountId = (Integer) httpSession.getAttribute(Contants.CURRENT_USERID);
        if (accountId == 0 || "".equals(accountId)) {
            throw new Exception("用户session的Id未找到或已经失效");
        }
        List<AgencyCompanyExt> listCompany = companyService.ext(accountId);
        String telphone = (String) httpSession.getAttribute(Contants.CURRENT_USER);
        List<Organization> organizationList = companyService.selectCompanyByTelphoneOnView(telphone);
        List<Province> provinceList = provinceService.getAllProvince();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("admin-release");
        mv.addObject("listCompany", listCompany);
        mv.addObject("organizationList", organizationList);
        mv.addObject("provinceList", provinceList);
        return mv;
    }

    @RequestMapping("/remove")
    public void removeComany(String companyId) throws Exception {
        if (null == companyId || "".equals(companyId)) {
            throw new Exception("参数为 null");
        }
        companyService.removeCompany(Integer.valueOf(companyId));
    }

    @RequestMapping(value = "{companyId}", method = RequestMethod.GET)
    public ResponseEntity getCompanyById(@PathVariable int companyId) {
        AgencyCompany company = companyService.getCompanyById(companyId);

        if (company == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(company);
    }

    /**
     * zwd-apple
     *查询公司
     * @return
     */
    @RequestMapping(value = "/select")
    public AgencyCompany selectCompanyById(AgencyCompany agencyCompany)throws FrontParameterException {
        if (null == agencyCompany) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        agencyCompany = companyService.selectCompanyById(agencyCompany);
        if (null == agencyCompany) {
            logger.debug("未查到该公司");
        }
        return agencyCompany;
    }

    /**
     * zwd-apple
     *更新公司
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public AgencyCompany updateCompanyById(AgencyCompany agencyCompany) throws FrontParameterException, ServiceException {
        if (null == agencyCompany) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        boolean isSucess = companyService.updateCompanyById(agencyCompany);
        if (isSucess) {
            logger.debug("公司[" + agencyCompany.getCompanyId() + "]修改成功!");
            return agencyCompany;
        } else {
            //logger.debug("服务[\" + agencyStaffs.getStaffId() + \"]修改失败!");
            throw new ServiceException("公司[" + agencyCompany.getCompanyId() + "]修改失败!");
        }
    }
}

