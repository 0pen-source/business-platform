package com.github.weibao.model;

import javax.persistence.*;

/**
 * Created by zwd-apple on 2016/1/19.
 */
@Table(name = "v_organization")
public class Organization {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer orgId;

  private String orgName;

  private String userName;

  private String telphone;

  public Integer getOrgId() {
    return orgId;
  }

  public void setOrgId(Integer orgId) {
    this.orgId = orgId;
  }

  public String getTelphone() {
    return telphone;
  }

  public void setTelphone(String telphone) {
    this.telphone = telphone;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getOrgName() {
    return orgName;
  }

  public void setOrgName(String orgName) {
    this.orgName = orgName;
  }


}
