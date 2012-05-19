package com.company.travel.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * 一个 Route 包含多个 RoutePrice
 */
@Entity
@Table(name="tbl_route_price")
public class RoutePrice extends BaseEntity{
	// 线路ID
	private String routeID;
	// 起始日期
	private Date startDate;
	// 结束日期
	private Date endDate;
    // 出团日期
    private Date publishDate;
    // 儿童价格
    private String childenPrice;
    // 成人价格
    private String adultPrice;
    // 去程航班信息
    private String startFlightInfo;
    // 返程航班信息
    private String endFlightInfo;
    // 当天总舱位
    private String flightSpace;
    // 人数
    private String totalPeople;
     // 线路信息
    private Route route;

    //constructors
    public RoutePrice() {
    }

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    @Transient
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Transient
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getAdultPrice() {
        return adultPrice;
    }

    public void setAdultPrice(String adultPrice) {
        this.adultPrice = adultPrice;
    }

    public String getChildenPrice() {
        return childenPrice;
    }

    public void setChildenPrice(String childenPrice) {
        this.childenPrice = childenPrice;
    }

    public String getStartFlightInfo() {
        return startFlightInfo;
    }

    public void setStartFlightInfo(String startFlightInfo) {
        this.startFlightInfo = startFlightInfo;
    }

    public String getEndFlightInfo() {
        return endFlightInfo;
    }

    public void setEndFlightInfo(String endFlightInfo) {
        this.endFlightInfo = endFlightInfo;
    }

    public String getFlightSpace() {
        return flightSpace;
    }

    public void setFlightSpace(String flightSpace) {
        this.flightSpace = flightSpace;
    }

    public String getTotalPeople() {
        return totalPeople;
    }

    public void setTotalPeople(String totalPeople) {
        this.totalPeople = totalPeople;
    }

    @Transient
    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
