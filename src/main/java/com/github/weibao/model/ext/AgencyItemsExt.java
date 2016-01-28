package com.github.weibao.model.ext;

import com.github.weibao.model.AgencyItems;

/**
 * Created by wb on 2016-01-12.
 */
public class AgencyItemsExt extends AgencyItems{
    // TODO: 16/1/17 因该 extend AgencyItems
    private String companyName;
    private String nameAndPhone;
    private String telephone;
    private String province;
    private String city;
    private String address;
    private String county;
    //公司规模
    private int companyScale;
    private int pageNumber;
    //服务简介



    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCompanyScale() {
        return companyScale;
    }

    public void setCompanyScale(int companyScale) {
        this.companyScale = companyScale;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getNameAndPhone() {
        return nameAndPhone;
    }

    public void setNameAndPhone(String nameAndPhone) {
        this.nameAndPhone = nameAndPhone;
    }
}


