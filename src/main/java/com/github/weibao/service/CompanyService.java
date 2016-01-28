package com.github.weibao.service;

import com.github.weibao.mapper.AgencyCompanyMapper;
import com.github.weibao.mapper.AgencyCompnayExtMapper;
import com.github.weibao.mapper.OrganizationMapper;
import com.github.weibao.model.AgencyCompany;
import com.github.weibao.model.AgencyCompanyHasStaffs;
import com.github.weibao.model.Organization;
import com.github.weibao.model.ext.AgencyCompanyExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class CompanyService {

    @Autowired
    AgencyCompanyMapper agencyCompanyMapper;

    @Autowired
    OrganizationMapper organizationMapper;

    @Autowired
    private AgencyCompnayExtMapper agencyCompnayExtMapper;

    public Boolean insertCompany(AgencyCompany agencyCompany) {
        int companyId = agencyCompanyMapper.insert(agencyCompany);
        if (companyId == 1) {
            return true;
        }
        return false;
    }


    public AgencyCompany selectCompanyByPrimaryKey(Integer accountId) {
        AgencyCompany agenyCompany = agencyCompanyMapper.selectByPrimaryKey(accountId);
        if (agenyCompany != null) {
            return agenyCompany;
        } else {
            return null;
        }
    }

    public AgencyCompany updateCompany(AgencyCompany agencyCompany) {
        agencyCompanyMapper.updateByPrimaryKeySelective(agencyCompany);
        return agencyCompany;
    }

    public Boolean addCompanyOnRelease(String companyName) {
        AgencyCompany agencyCompany = new AgencyCompany();
        agencyCompany.setCompanyName(companyName);
        int companyId = agencyCompanyMapper.insertSelective(agencyCompany);
        if (companyId == 1) {
            return true;
        }
        return false;

    }


    public List<AgencyCompany> selectCompanyByAccountId(Integer accountId) {
        AgencyCompany agencyCompany = new AgencyCompany();
        agencyCompany.setAccountId(accountId);
        List<AgencyCompany> listCompany = agencyCompanyMapper.select(agencyCompany);
        return listCompany;
    }

//  public List<ItemsExtCompany> selectCompanyzByAccountId(Integer accountId) {
//    ItemsExtCompany itemsExt = new ItemsExtCompany();
//    itemsExt.setAccountId(accountId);
//    List listItemsExt = agencyCompanyMapper.select(itemsExt);
//    return listItemsExt;
//  }



    public List<AgencyCompanyExt> ext() {
        List<AgencyCompanyExt> listExt = agencyCompnayExtMapper.selectAllCompany();
        return listExt;
    }

    public List<Organization> selectCompanyByTelphoneOnView(String telphone) {
        List<Organization> organizationList = organizationMapper.selectCompanyByTelphoneOnView(telphone);
        return organizationList;
    }

    public List<AgencyCompanyExt> ext(int accountId) {
        List<AgencyCompanyExt> listExt = agencyCompnayExtMapper.selectAllCompany(accountId);
        return listExt;
    }

    public void insertStaffsItemsRelevance(AgencyCompanyHasStaffs agencyCompanyHasStaffs) {
        agencyCompnayExtMapper.insertStaffsItemsRelevance(agencyCompanyHasStaffs);
    }

    public void removeCompany(Integer companyKeyId) {
        agencyCompanyMapper.deleteByPrimaryKey(companyKeyId);
    }

    public AgencyCompany getCompanyById(int companyId) {
        AgencyCompany agenyCompany = agencyCompanyMapper.selectByPrimaryKey(companyId);
        if (agenyCompany != null) {
            return agenyCompany;
        } else {
            return null;
        }
    }


    public AgencyCompany selectCompanyById(AgencyCompany agencyCompany) {
        agencyCompany = agencyCompanyMapper.selectByPrimaryKey(agencyCompany.getCompanyId());
        if(agencyCompany==null){
            return null;
        }
        return agencyCompany;
    }

    public boolean updateCompanyById(AgencyCompany agencyCompany) {
         agencyCompanyMapper.updateByPrimaryKeySelective(agencyCompany);
        int isSucess = agencyCompanyMapper.updateByPrimaryKeySelective(agencyCompany);
        if (isSucess == 1) {
            return true;
        }
        return false;
    }
}
