package com.github.weibao.mapper;

import com.github.weibao.model.AgencyCompanyHasStaffs;
import com.github.weibao.model.ext.AgencyCompanyExt;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/14.
 */
public interface AgencyCompnayExtMapper {

  List<AgencyCompanyExt> selectAllCompany();

  List<AgencyCompanyExt> selectAllCompany(int accountId);

  void insertStaffsItemsRelevance(AgencyCompanyHasStaffs agencyCompanyHasStaffs);

  void deleteStasffAndCompanyLink(AgencyCompanyHasStaffs agencyCompanyHasStaffs);
}
