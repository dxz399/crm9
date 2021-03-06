package com.zking.crm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class CstActivity implements Serializable{
    private Integer atvId;

    private String atvCustNo;

    private String atvCustName;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date atvDate;

    private String atvPlace;

    private String atvTitle;

    private String atvRemark;

    private String atvDesc;

    @Override
    public String toString() {
        return "CstActivity{" +
                "atvId=" + atvId +
                ", atvCustNo='" + atvCustNo + '\'' +
                ", atvCustName='" + atvCustName + '\'' +
                ", atvDate=" + atvDate +
                ", atvPlace='" + atvPlace + '\'' +
                ", atvTitle='" + atvTitle + '\'' +
                ", atvRemark='" + atvRemark + '\'' +
                ", atvDesc='" + atvDesc + '\'' +
                '}';
    }

    public CstActivity(Integer atvId, String atvCustNo, String atvCustName, Date atvDate, String atvPlace, String atvTitle, String atvRemark, String atvDesc) {
        this.atvId = atvId;
        this.atvCustNo = atvCustNo;
        this.atvCustName = atvCustName;
        this.atvDate = atvDate;
        this.atvPlace = atvPlace;
        this.atvTitle = atvTitle;
        this.atvRemark = atvRemark;
        this.atvDesc = atvDesc;
    }

    public CstActivity() {
        super();
    }

    public Integer getAtvId() {
        return atvId;
    }

    public void setAtvId(Integer atvId) {
        this.atvId = atvId;
    }

    public String getAtvCustNo() {
        return atvCustNo;
    }

    public void setAtvCustNo(String atvCustNo) {
        this.atvCustNo = atvCustNo;
    }

    public String getAtvCustName() {
        return atvCustName;
    }

    public void setAtvCustName(String atvCustName) {
        this.atvCustName = atvCustName;
    }

    public Date getAtvDate() {
        return atvDate;
    }

    public void setAtvDate(Date atvDate) {
        this.atvDate = atvDate;
    }

    public String getAtvPlace() {
        return atvPlace;
    }

    public void setAtvPlace(String atvPlace) {
        this.atvPlace = atvPlace;
    }

    public String getAtvTitle() {
        return atvTitle;
    }

    public void setAtvTitle(String atvTitle) {
        this.atvTitle = atvTitle;
    }

    public String getAtvRemark() {
        return atvRemark;
    }

    public void setAtvRemark(String atvRemark) {
        this.atvRemark = atvRemark;
    }

    public String getAtvDesc() {
        return atvDesc;
    }

    public void setAtvDesc(String atvDesc) {
        this.atvDesc = atvDesc;
    }
}