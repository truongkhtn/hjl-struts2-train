package com.company.travel.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 实体类 - 订单, 由1个Route(路线对象)和N个BookingPerson(预订人员)组成
 */
@Entity
@Table(name="tbl_traveller_info")
public class TravellerInfo extends BaseEntity{
    //订单ID
    private String orderID;
    //序号
    private String seq;
    //姓名
    private String traverName;
    //性别
    private String sex;
    //性别(名称)
    private String sexName;
    //成人/儿童
    private String peopleType;
    //成人/儿童(名称)
    private String peopleTypeName;
    //证件类型
    private String certificateType;
    //证件类型(名称)
    private String certificateTypeName;
    //证件号码
    private String certificateNumber;
    //联系电话
    private String contactTel;
    //备注
    private String memo;

    //constructor
    public TravellerInfo() {
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getTraverName() {
        return traverName;
    }

    public void setTraverName(String traverName) {
        this.traverName = traverName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Transient
    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

    @Transient
    public String getPeopleTypeName() {
        return peopleTypeName;
    }

    public void setPeopleTypeName(String peopleTypeName) {
        this.peopleTypeName = peopleTypeName;
    }

    @Transient
    public String getCertificateTypeName() {
        return certificateTypeName;
    }

    public void setCertificateTypeName(String certificateTypeName) {
        this.certificateTypeName = certificateTypeName;
    }

    public String getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(String peopleType) {
        this.peopleType = peopleType;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
