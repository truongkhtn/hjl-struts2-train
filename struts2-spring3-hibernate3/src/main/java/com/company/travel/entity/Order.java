package com.company.travel.entity;

import javax.persistence.*;
import java.util.List;

/**
 * 订单信息
 */
@Entity
@Table(name="tbl_order")
public class Order extends BaseEntity{

    // 旅行社用户ID
    private String userID;
    //包含价格的线路ID
    private String routePriceID;
    //成人人数
    private String adultCount;
    //儿童人数
    private String childenCount;
    //组团操作人
    private String operator;
    //联系电话
    private String contactTel;
    //备注说明
    private String memo;
    // 订单状态(1:未确认/2:已确认/3:已取消)
    private String status;
    // 订单状态(1:未确认/2:已确认/3:已取消)
    private String statusName;
    // 旅行社信息
    private User user;
    // 线路信息
    private RoutePrice routePrice;
    // 订单旅客详细信息
    private List<TravellerInfo> travellerInfoList;

    //constructor
    public Order() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getRoutePriceID() {
        return routePriceID;
    }

    public void setRoutePriceID(String routePriceID) {
        this.routePriceID = routePriceID;
    }

    public String getAdultCount() {
        return adultCount;
    }

    public void setAdultCount(String adultCount) {
        this.adultCount = adultCount;
    }

    public String getChildenCount() {
        return childenCount;
    }

    public void setChildenCount(String childenCount) {
        this.childenCount = childenCount;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Transient
    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Transient
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Transient
    public RoutePrice getRoutePrice() {
        return routePrice;
    }

    public void setRoutePrice(RoutePrice routePrice) {
        this.routePrice = routePrice;
    }

    @OneToMany(targetEntity= TravellerInfo.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="orderID")
    @OrderBy("seq asc")
    public List<TravellerInfo> getTravellerInfoList() {
        return travellerInfoList;
    }

    public void setTravellerInfoList(List<TravellerInfo> travellerInfoList) {
        this.travellerInfoList = travellerInfoList;
    }
}
