package com.company.travel.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * 实体类 - 旅游线路,如：黄山2日游,黄山3日游
 * 一个 Route 包含多个 Journey
 */
@Entity
@Table(name="tbl_route")
public class Route extends BaseEntity{
	// 产品名称
	private String productName;
	// 产品类别
	private String productType;
	// 产品类别名称
	private String productTypeName;
	// 年龄限制
	private String ageLimit;
	// 景点
	private String scenerySpot;
	// 购物
	private String shopping;
	// 住宿标准
	private String accomodationStandard;
	// 赠送
	private String present;
	// 出港地点
	private String portOfDeparture;
	// 产品特色
	private String productItem;
	// 服务标准
	private String serviceStandard;
	// 特别说明
	private String specialInstruction;
	// 温馨提示
	private String friendlyTips;
    //集合-行程
    private List<Journey> journeySet;

    //constructors
    public Route() {
    }

    public String getAccomodationStandard() {
        return accomodationStandard;
    }

    public void setAccomodationStandard(String accomodationStandard) {
        this.accomodationStandard = accomodationStandard;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }

    @Column(length = 1000)
    public String getFriendlyTips() {
        return friendlyTips;
    }

    public void setFriendlyTips(String friendlyTips) {
        this.friendlyTips = friendlyTips;
    }

    public String getPortOfDeparture() {
        return portOfDeparture;
    }

    public void setPortOfDeparture(String portOfDeparture) {
        this.portOfDeparture = portOfDeparture;
    }

    @Column(length = 1000)
    public String getPresent() {
        return present;
    }

    public void setPresent(String present) {
        this.present = present;
    }

    @Column(length = 1000)
    public String getProductItem() {
        return productItem;
    }

    public void setProductItem(String productItem) {
        this.productItem = productItem;
    }

    @Column(length = 1000)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Transient
    public String getProductTypeName() {
        return productTypeName;
    }

    public void setProductTypeName(String productTypeName) {
        this.productTypeName = productTypeName;
    }

    @Column(length = 1000)
    public String getScenerySpot() {
        return scenerySpot;
    }

    public void setScenerySpot(String scenerySpot) {
        this.scenerySpot = scenerySpot;
    }

    @Column(length = 1000)
    public String getServiceStandard() {
        return serviceStandard;
    }

    public void setServiceStandard(String serviceStandard) {
        this.serviceStandard = serviceStandard;
    }

    public String getShopping() {
        return shopping;
    }

    public void setShopping(String shopping) {
        this.shopping = shopping;
    }

    @Column(length = 1000)
    public String getSpecialInstruction() {
        return specialInstruction;
    }

    public void setSpecialInstruction(String specialInstruction) {
        this.specialInstruction = specialInstruction;
    }

    @OneToMany(targetEntity= Journey.class,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="routeID")
    @OrderBy("seq asc")
    public List<Journey> getJourneySet() {
        return journeySet;
    }

    public void setJourneySet(List<Journey> journeySet) {
        this.journeySet = journeySet;
    }
}
