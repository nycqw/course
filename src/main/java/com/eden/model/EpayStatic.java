package com.eden.model;

import java.util.Date;

public class EpayStatic {
    private Integer id;

    private String attrCode;

    private String attrCode1;

    private String attrCode2;

    private String attrName;

    private String attrValue;

    private String attrSource;

    private String remark;

    private Date updateTime;

    private Boolean flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAttrCode() {
        return attrCode;
    }

    public void setAttrCode(String attrCode) {
        this.attrCode = attrCode == null ? null : attrCode.trim();
    }

    public String getAttrCode1() {
        return attrCode1;
    }

    public void setAttrCode1(String attrCode1) {
        this.attrCode1 = attrCode1 == null ? null : attrCode1.trim();
    }

    public String getAttrCode2() {
        return attrCode2;
    }

    public void setAttrCode2(String attrCode2) {
        this.attrCode2 = attrCode2 == null ? null : attrCode2.trim();
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName == null ? null : attrName.trim();
    }

    public String getAttrValue() {
        return attrValue;
    }

    public void setAttrValue(String attrValue) {
        this.attrValue = attrValue == null ? null : attrValue.trim();
    }

    public String getAttrSource() {
        return attrSource;
    }

    public void setAttrSource(String attrSource) {
        this.attrSource = attrSource == null ? null : attrSource.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}