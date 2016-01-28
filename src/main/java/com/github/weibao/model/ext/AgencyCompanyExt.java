package com.github.weibao.model.ext;

import com.github.weibao.model.AgencyCompany;
import com.github.weibao.model.AgencyStaffs;

import java.util.List;

/**
 * Created by zwd-apple on 2016/1/14.
 */
public class AgencyCompanyExt extends AgencyCompany {


  public List<AgencyItemsExt2> getItemList() {
    return itemList;
  }

  public void setItemList(List<AgencyItemsExt2> itemList) {
    this.itemList = itemList;
  }

  private List<AgencyItemsExt2> itemList;

  public List<AgencyStaffs> getStaffsList() {
    return staffsList;
  }

  public void setStaffsList(List<AgencyStaffs> staffsList) {
    this.staffsList = staffsList;
  }

  private List<AgencyStaffs> staffsList;

}
