package com.company.travel.entity;

import javax.persistence.*;

/**
 * 实体类 - 行程，多个 Journey 对应一个 Route
 */
@Entity
@Table(name="tbl_journey")
public class Journey extends BaseEntity{

    // 线路ID
    private String routeID;
    // 序号
    private String seq;
	// 交通
	private String traffic;
	// 交通_名称
	private String trafficName;
	// 行程安排
	private String journeyInfo;
	// 餐饮
	private String catering;
	// 住宿
	private String accomodation;

    //constructors
    public Journey() {
    }

    //getter & setter
    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public String getSeq() {
        return seq;
    }

    public void setSeq(String seq) {
        this.seq = seq;
    }

    public String getAccomodation() {
        return accomodation;
    }

    public void setAccomodation(String accomodation) {
        this.accomodation = accomodation;
    }

    public String getCatering() {
        return catering;
    }

    public void setCatering(String catering) {
        this.catering = catering;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    @Transient
    public String getTrafficName() {
        return trafficName;
    }

    public void setTrafficName(String trafficName) {
        this.trafficName = trafficName;
    }

    @Column(length = 1000)
    public String getJourneyInfo() {
        return journeyInfo;
    }

    public void setJourneyInfo(String journeyInfo) {
        this.journeyInfo = journeyInfo;
    }
}
