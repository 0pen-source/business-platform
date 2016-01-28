package com.github.weibao.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "agency_items")
public class AgencyItems {
    @Id
    @Column(name = "item_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer itemId;

    /**
     * 服务名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 服务类型（从数据字典表取值）
     */
    @Column(name = "item_type")
    private Integer itemType;

    /**
     * 服务费
     */
    private BigDecimal cost;

    @Column(name = "max_cost")
    private BigDecimal maxCost;

    @Column(name = "min_cost")
    private BigDecimal minCost;

    /**
     * 代理服务项目简介
     */
    private String intro;

    @Column(name = "company_Id")
    private Integer companyId;

    @Column(name = "company_schema")
    private String companySchema;

    @Column(name = "is_deleted")
    private String isDeleted;

    /**
     * @return item_Id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * @param itemId
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 获取服务名称
     *
     * @return item_name - 服务名称
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * 设置服务名称
     *
     * @param itemName 服务名称
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * 获取服务类型（从数据字典表取值）
     *
     * @return item_type - 服务类型（从数据字典表取值）
     */
    public Integer getItemType() {
        return itemType;
    }

    /**
     * 设置服务类型（从数据字典表取值）
     *
     * @param itemType 服务类型（从数据字典表取值）
     */
    public void setItemType(Integer itemType) {
        this.itemType = itemType;
    }

    /**
     * 获取服务费
     *
     * @return cost - 服务费
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * 设置服务费
     *
     * @param cost 服务费
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * @return max_cost
     */
    public BigDecimal getMaxCost() {
        return maxCost;
    }

    /**
     * @param maxCost
     */
    public void setMaxCost(BigDecimal maxCost) {
        this.maxCost = maxCost;
    }

    /**
     * @return min_cost
     */
    public BigDecimal getMinCost() {
        return minCost;
    }

    /**
     * @param minCost
     */
    public void setMinCost(BigDecimal minCost) {
        this.minCost = minCost;
    }

    /**
     * 获取代理服务项目简介
     *
     * @return intro - 代理服务项目简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置代理服务项目简介
     *
     * @param intro 代理服务项目简介
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * @return company_Id
     */
    public Integer getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     */
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    /**
     * @return company_schema
     */
    public String getCompanySchema() {
        return companySchema;
    }

    /**
     * @param companySchema
     */
    public void setCompanySchema(String companySchema) {
        this.companySchema = companySchema;
    }

    /**
     * @return is_deleted
     */
    public String getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     */
    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }
}