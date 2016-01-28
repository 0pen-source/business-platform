package com.github.weibao.model.ext;

import com.github.weibao.model.AgencyItems;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/20.
 */
public class AgencyItemsExt2 extends AgencyItems{
  public List<AgencyStaffsExt> getStaffsList() {
    return staffsList;
  }

  public void setStaffsList(List<AgencyStaffsExt> staffsList) {
    this.staffsList = staffsList;
  }

  private List<AgencyStaffsExt> staffsList;
}
