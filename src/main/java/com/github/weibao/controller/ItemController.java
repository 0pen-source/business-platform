package com.github.weibao.controller;

import com.github.weibao.exception.FrontParameterException;
import com.github.weibao.exception.ServiceException;
import com.github.weibao.model.AgencyItems;
import com.github.weibao.model.ext.ItemStaffLink;
import com.github.weibao.service.CompanyService;
import com.github.weibao.service.ItemsService;
import com.github.weibao.service.StaffsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/6.
 */
@RestController
@RequestMapping("item")
public class ItemController {
    private Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    CompanyService companyService;

    @Autowired
    ItemsService itemsService;

    @Autowired
    StaffsService staffsService;

    /**zwd-apple
     * 服务信息插入
     * @param agencyItems
     * @return
     */
    @RequestMapping("insert")
    public AgencyItems insertItems(AgencyItems agencyItems) throws Exception{
        if(null == agencyItems){
            throw new Exception("参数为null");
        }
        if(null == agencyItems.getCost() || null == agencyItems.getItemName()) {
            throw new Exception("服务的价格不能为null");
        }
        Boolean isSucess = itemsService.insertItems(agencyItems);
        if(isSucess){
            logger.debug("公司[" + agencyItems.getCompanyId() + "]插入服务[" + agencyItems.getItemId() + "]成功!");

            return agencyItems;
        }else{
            logger.debug("公司[" + agencyItems.getCompanyId() + "]插入服务失败!");

            return null;
        }
    }

    /**
     * 想服务和联系人表插入关系
     * @param itemId
     * @param staffId
     * @throws FrontParameterException
     * @throws ServiceException
     */
    @RequestMapping("insertItemStaffLink")
    public void insertItemStaffLink(String itemId, String staffId) throws FrontParameterException, ServiceException {
        if (null == itemId || null == staffId) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        ItemStaffLink itemStaffLink = new ItemStaffLink(Integer.valueOf(itemId),Integer.valueOf(staffId));
        itemsService.insertItemStaffLink(itemStaffLink);

    }

    /**
     * 删除服务
     * @param itemId
     * @param companyId
     * @throws FrontParameterException
     */
    @RequestMapping("remove")
    public void removeItems(String itemId,String companyId) throws FrontParameterException{
        if(null == itemId || "".equals(itemId)){
            throw new FrontParameterException("itemId为null");
        }

        itemsService.removeItem(Integer.valueOf(itemId));
        //todo:

        logger.debug("公司[" + companyId + "]删除服务!");
    }

    /**
     * 根据companyId查询服务
     * @param agencyItems
     * @return
     * @throws FrontParameterException
     */
    @RequestMapping("query")
    public ModelAndView selectItems(AgencyItems agencyItems)throws FrontParameterException{
        logger.info("--根据companyId查询服务--INFO级别:");
        if (null == agencyItems) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        List<AgencyItems> agencyItemsList = itemsService.selectItems(agencyItems.getCompanyId());
        ModelAndView mv = new ModelAndView();
        mv.setViewName("release-items");
        mv.addObject("agencyItemsList",agencyItemsList);
        return mv;
    }

    /**
     *根据主键查询服务
     * @param agencyItems
     * @return
     * @throws FrontParameterException
     */
    @RequestMapping("select")
    public AgencyItems selectItemsById(AgencyItems agencyItems)throws FrontParameterException{
        logger.info("--根据itemId查询服务--INFO级别:");
        if (null == agencyItems) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        agencyItems = itemsService.selectItemsById(agencyItems);
        if (null == agencyItems) {
            logger.debug("未查到服务信息");
        }
        return agencyItems;
    }

    /**
     *更新服务
     * @param agencyItems
     * @return
     * @throws FrontParameterException
     * @throws ServiceException
     */
    @RequestMapping("update")
    public AgencyItems updateItemsById(AgencyItems agencyItems)throws FrontParameterException, ServiceException {
        if (null == agencyItems) {
            throw new FrontParameterException("前端页面传入参数为null.");
        }
        boolean isSucess =  itemsService.updateItemsById(agencyItems);
        if (isSucess) {
            logger.debug("服务[" + agencyItems.getItemId() + "]修改成功!");
            return agencyItems;
        } else {
            //logger.debug("服务[\" + agencyStaffs.getStaffId() + \"]修改失败!");
            throw new ServiceException("服务[" +  agencyItems.getItemId() + "]修改失败!");
        }

    }

}
