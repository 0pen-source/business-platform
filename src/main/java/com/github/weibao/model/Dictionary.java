package com.github.weibao.model;

import javax.persistence.*;

@Table(name = "dictionary")
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 编码

     */
    @Id
    private Integer code;

    @Id
    private String value;

    /**
     * 描述
     */
    private String intro;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取编码

     *
     * @return code - 编码

     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置编码

     *
     * @param code 编码

     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取描述
     *
     * @return intro - 描述
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置描述
     *
     * @param intro 描述
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }
}