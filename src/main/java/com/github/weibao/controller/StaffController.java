package com.github.weibao.controller;

import com.github.weibao.exception.FrontParameterException;
import com.github.weibao.exception.ServiceException;
import com.github.weibao.model.AgencyCompanyHasStaffs;
import com.github.weibao.model.AgencyStaffs;
import com.github.weibao.service.CompanyService;
import com.github.weibao.service.StaffsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zwd-apple on 2016/1/6.
 */
@RestController
@RequestMapping("staff")
public class StaffController {
    private Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    StaffsService staffsService;

    @Autowired
    CompanyService companyService;


    /**
     * zwd-apple
     * 插入联系人与公司之间的关联
     *
     * @return
     */
    @RequestMapping("insert")
    public AgencyStaffs InsertStasffsjoinCompnay(AgencyStaffs agencyStaffs, AgencyCompanyHasStaffs agencyCompanyHasStaffs) {
        logger.info("---------插入员工信息--------");
        Boolean isSucess = staffsService.insertStaffs(agencyStaffs);
        if (isSucess) {
            logger.debug("公司[" + agencyCompanyHasStaffs.getCompanyId() + "]插入员工成功!");
            //插入员工信息成功的前提下插入关联
            agencyCompanyHasStaffs.setStaffId(agencyStaffs.getStaffId());
            companyService.insertStaffsItemsRelevance(agencyCompanyHasStaffs);

            return agencyStaffs;
        } else {
            logger.debug("公司[" + agencyCompanyHasStaffs.getCompanyId() + "]插入员工失败!");

            return null;
        }
    }

    /**
     * zwd-apple
     * 删除员工和人与公司之间的关联
     *
     * @return
     */
    @RequestMapping("delete")
    public AgencyStaffs deleteStasff(AgencyStaffs agencyStaffs, AgencyCompanyHasStaffs agencyCompanyHasStaffs) {
        Boolean isSucess = staffsService.deleteStasff(agencyStaffs);
        if (isSucess) {
            logger.debug("公司[" + agencyCompanyHasStaffs.getCompanyId() + "]删除员工成功!");
            agencyCompanyHasStaffs.setStaffId(agencyStaffs.getStaffId());
            AgencyCompanyHasStaffs list = agencyCompanyHasStaffs;
            staffsService.deleteStasffAndCompanyLink(agencyCompanyHasStaffs);
            return agencyStaffs;
        } else {
            logger.debug("公司[" + agencyCompanyHasStaffs.getCompanyId() + "]删除员工失败!");
            return null;
        }
    }

    /**
     * zwd-apple
     * 根据主键查询员工
     *
     * @return
     */
    @RequestMapping("select")
    public AgencyStaffs selectStaff(AgencyStaffs agencyStaffs)  throws FrontParameterException{
        if (null == agencyStaffs) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        agencyStaffs = staffsService.selectStaff(agencyStaffs);
        if (null == agencyStaffs) {
            logger.debug("没有查到该员工");
        }
        return agencyStaffs;
    }

    /**
     * zwd-apple
     * 更新员工
     *
     * @return
     */
    @RequestMapping("update")
    public AgencyStaffs updateStaff(AgencyStaffs agencyStaffs) throws FrontParameterException, ServiceException {
        if (null == agencyStaffs) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        boolean isSucess = staffsService.updateStaff(agencyStaffs);
        if (isSucess) {
            logger.debug("员工[" + agencyStaffs.getStaffId() + "]修改成功!");
            return agencyStaffs;
        } else {
            //logger.debug("服务[\" + agencyStaffs.getStaffId() + \"]修改失败!");
            throw new ServiceException("员工[" + agencyStaffs.getStaffId() + "]修改失败!");
        }
    }



}
