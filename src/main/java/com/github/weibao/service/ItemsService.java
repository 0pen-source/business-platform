package com.github.weibao.service;

import com.github.weibao.mapper.AgencyItemsExtMapper;
import com.github.weibao.mapper.AgencyItemsMapper;
import com.github.weibao.model.AgencyItems;
import com.github.weibao.model.ext.ItemStaffLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/8.
 */
@Service
public class ItemsService {

    @Autowired
    AgencyItemsMapper agencyItemsMapper;

    @Autowired
    AgencyItemsExtMapper agencyItemsExtMapper;

    public boolean insertItems(AgencyItems agencyItems) {
        if (agencyItemsMapper.insert(agencyItems) == 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean insertItemStaffLink(ItemStaffLink itemStaffLink){
        if (agencyItemsExtMapper.insertItemStaffLink(itemStaffLink) == 1){
            return true;
        }

        return false;
    }

    public void removeItem(Integer itemId) {
        agencyItemsMapper.deleteByPrimaryKey(itemId);
    }

    public List<AgencyItems> selectItems(Integer companyId) {
        AgencyItems agencyItems = new AgencyItems();
        agencyItems.setCompanyId(companyId);
        List<AgencyItems> listAgencyItems = agencyItemsMapper.select(agencyItems);
        return listAgencyItems;
    }

    public AgencyItems selectItemsById(AgencyItems agencyItems) {
        agencyItems = agencyItemsMapper.selectByPrimaryKey(agencyItems);
        return agencyItems;
    }

    public boolean updateItemsById(AgencyItems agencyItems) {
        agencyItemsMapper.updateByPrimaryKeySelective(agencyItems);
        int isSucess = agencyItemsMapper.updateByPrimaryKeySelective(agencyItems);
        if (isSucess == 1) {
            return true;
        }
        return false;
    }
}
