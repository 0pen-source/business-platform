package com.github.weibao.service;

import com.github.weibao.mapper.AgencyCompnayExtMapper;
import com.github.weibao.mapper.AgencyStaffsMapper;
import com.github.weibao.model.AgencyCompanyHasStaffs;
import com.github.weibao.model.AgencyStaffs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zwd-apple on 2016/1/8.
 */
@Service
public class StaffsService {

    // STOPSHIP: 2016/1/8 添加人员
    @Autowired
    AgencyStaffsMapper agencyStaffsMapper;
    @Autowired
    AgencyCompnayExtMapper agencyCompanyExtMapper;

    public Boolean insertStaffs(AgencyStaffs agencyStaffs) {
        int insertStaffsStatus = agencyStaffsMapper.insertSelective(agencyStaffs);
        if (insertStaffsStatus == 1) {
            return true;
        }
        return false;

    }

    public Boolean deleteStasff(AgencyStaffs agencyStaffs) {
        agencyStaffs.setIsDeleted("-1");
        int deleteStaffsStatus = agencyStaffsMapper.updateByPrimaryKeySelective(agencyStaffs);
        if (deleteStaffsStatus == 1) {
            return true;
        }
        return false;
    }

    public void deleteStasffAndCompanyLink(AgencyCompanyHasStaffs agencyCompanyHasStaffs) {
        agencyCompanyExtMapper.deleteStasffAndCompanyLink(agencyCompanyHasStaffs);

    }

    public AgencyStaffs selectStaff(AgencyStaffs agencyStaffs) {
        agencyStaffs = agencyStaffsMapper.selectByPrimaryKey(agencyStaffs);
        if (agencyStaffs==null){
            return null;
        }
        return agencyStaffs;
    }

    public boolean updateStaff(AgencyStaffs agencyStaffs) {
        agencyStaffsMapper.updateByPrimaryKeySelective(agencyStaffs);
        int isSucess = agencyStaffsMapper.updateByPrimaryKeySelective(agencyStaffs);
        if (isSucess == 1) {
            return true;
        }
        return false;
    }
}
