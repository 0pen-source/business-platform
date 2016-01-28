package com.github.weibao.model;

import javax.persistence.*;

@Table(name = "agency_company")
public class AgencyCompany {
    /**
     * ID主键
     */
    @Id
    @Column(name = "company_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;

    private String province;

    private String city;

    private String county;

    /**
     * 公司名
     */
    @Column(name = "company_name")
    private String companyName;

    /**
     * 公司性质
     */
    @Column(name = "company_type")
    private String companyType;

    @Column(name = "company_scale")
    private Integer companyScale;

    /**
     * 公司地址
     */
    private String address;

    /**
     * 公司法人代表

     */
    @Column(name = "law_person")
    private String lawPerson;

    /**
     * 公司联系电话
     */
    private String telephone;

    /**
     * 公司网址
     */
    private String url;

    /**
     * 公司简介
     */
    private String intro;

    /**
     * 关联账户表
     */
    @Column(name = "account_Id")
    private Integer accountId;

    /**
     * 状态
     */
    @Column(name = "is_deleted")
    private String isDeleted;

    /**
     * 获取ID主键
     *
     * @return company_Id - ID主键
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * 设置ID主键
     *
     * @param companyId ID主键
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return county
     */
    public String getCounty() {
        return county;
    }

    /**
     * @param county
     */
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 获取公司名
     *
     * @return company_name - 公司名
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置公司名
     *
     * @param companyName 公司名
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取公司性质
     *
     * @return company_type - 公司性质
     */
    public String getCompanyType() {
        return companyType;
    }

    /**
     * 设置公司性质
     *
     * @param companyType 公司性质
     */
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    /**
     * @return company_scale
     */
    public Integer getCompanyScale() {
        return companyScale;
    }

    /**
     * @param companyScale
     */
    public void setCompanyScale(Integer companyScale) {
        this.companyScale = companyScale;
    }

    /**
     * 获取公司地址
     *
     * @return address - 公司地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置公司地址
     *
     * @param address 公司地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取公司法人代表

     *
     * @return law_person - 公司法人代表

     */
    public String getLawPerson() {
        return lawPerson;
    }

    /**
     * 设置公司法人代表

     *
     * @param lawPerson 公司法人代表

     */
    public void setLawPerson(String lawPerson) {
        this.lawPerson = lawPerson;
    }

    /**
     * 获取公司联系电话
     *
     * @return telephone - 公司联系电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置公司联系电话
     *
     * @param telephone 公司联系电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取公司网址
     *
     * @return url - 公司网址
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置公司网址
     *
     * @param url 公司网址
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取公司简介
     *
     * @return intro - 公司简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置公司简介
     *
     * @param intro 公司简介
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 获取关联账户表
     *
     * @return account_Id - 关联账户表
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置关联账户表
     *
     * @param accountId 关联账户表
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取状态
     *
     * @return is_deleted - 状态
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置状态
     *
     * @param isDeleted 状态
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}