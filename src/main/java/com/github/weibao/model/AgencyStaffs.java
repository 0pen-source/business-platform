package com.github.weibao.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import javax.persistence.*;

@Table(name = "agency_staffs")
public class AgencyStaffs {
    /**
     * ID主键
     */
    @Id
    @Column(name = "staff_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer staffId;

    /**
     * 职员名字
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 职员职位
     */
    private String post;

    private String qq;

    private String phone;

    /**
     * 联系人Email
     */
    private String email;

    /**
     * 微信号
     */
    private String weichat;

    /**
     * 关联账户表

     */
    @Column(name = "account_Id")
    private Integer accountId;

    @Column(name = "createTime")
    private Date createtime;

    /**
     * 状态
     */
    @Column(name = "is_deleted")
    private String isDeleted;

    /**
     * 二维码
     */
    @Column(name = "weichatCode")
    private String weichatcode;

    /**
     * 头像
     */
    private byte[] head;
    /**
     * 获取ID主键
     *
     * @return staff_Id - ID主键
     */
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * 设置ID主键
     *
     * @param staffId ID主键
     */
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    /**
     * 获取职员名字
     *
     * @return name - 职员名字
     */
    public String getName() {
        return name;
    }

    /**
     * 设置职员名字
     *
     * @param name 职员名字
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取职员职位
     *
     * @return post - 职员职位
     */
    public String getPost() {
        return post;
    }

    /**
     * 设置职员职位
     *
     * @param post 职员职位
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * @return qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取联系人Email
     *
     * @return email - 联系人Email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置联系人Email
     *
     * @param email 联系人Email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取微信号
     *
     * @return weichat - 微信号
     */
    public String getWeichat() {
        return weichat;
    }

    /**
     * 设置微信号
     *
     * @param weichat 微信号
     */
    public void setWeichat(String weichat) {
        this.weichat = weichat;
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
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    /**
     * 获取二维码
     *
     * @return weichatCode - 二维码
     */
    public String getWeichatcode() {
        return weichatcode;
    }

    /**
     * 设置二维码
     *
     * @param weichatcode 二维码
     */
    public void setWeichatcode(String weichatcode) {
        this.weichatcode = weichatcode;
    }

    /**
     * 获取头像
     *
     * @return head - 头像
     */
    public byte[] getHead() {
        return head;
    }

    /**
     * 设置头像
     *
     * @param head 头像
     */
    public void setHead(byte[] head) {
        this.head = head;
    }
}