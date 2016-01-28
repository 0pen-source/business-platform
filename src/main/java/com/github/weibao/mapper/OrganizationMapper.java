package com.github.weibao.mapper;

import com.github.weibao.model.Organization;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/19.
 */
public interface OrganizationMapper {


  List<Organization> selectCompanyByTelphoneOnView(String telphone);
}
