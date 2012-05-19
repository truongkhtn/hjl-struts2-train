package com.company.travel.controller;

import com.company.travel.entity.Journey;
import com.company.travel.entity.Route;
import com.company.travel.entity.RoutePrice;
import com.company.travel.service.JourneyService;
import com.company.travel.service.RoutePriceService;
import com.company.travel.service.RouteService;
import com.company.travel.utils.Utils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Route Action 类，包含对于所有 Route 对象的操作
 *
 * @author 胡荆陵
 */
@Controller
@Scope("prototype")
public class RoutePriceAction extends BasePagerAction {

    private String routeID;
    public RoutePrice routePrice;
    private List<RoutePrice> routePriceList;

    @Resource
    private RouteService routeService;
    @Resource
    private RoutePriceService routePriceService;
    @Resource
    private JourneyService journeyService;

    //getter & setter

    public String getRouteID() {
        return routeID;
    }

    public void setRouteID(String routeID) {
        this.routeID = routeID;
    }

    public RoutePrice getRoutePrice() {
        return routePrice;
    }

    public void setRoutePrice(RoutePrice routePrice) {
        this.routePrice = routePrice;
    }

    public List<RoutePrice> getRoutePriceList() {
        return routePriceList;
    }

    public void setRoutePriceList(List<RoutePrice> routePriceList) {
        this.routePriceList = routePriceList;
    }

    public String blank() {
        return SUCCESS;
    }

    public String list() {
        if (pager == null) {
            pager = new Pager();
        }
        String[] orderBys = new String[2];
        Pager.OrderType[] orderTypes = new Pager.OrderType[2];
        orderBys[0] = "publishDate";
        orderBys[1] = "routeID";
        orderTypes[0] = Pager.OrderType.asc;
        orderTypes[1] = Pager.OrderType.asc;
        pager.setOrderBys(orderBys);
        pager.setOrderTypes(orderTypes);
        pager = routePriceService.findByPager(pager);
        for (int i = 0; i < pager.getList().size(); i++) {
            RoutePrice routePrice = (RoutePrice)pager.getList().get(i);
            Route route = routeService.get(routePrice.getRouteID());
            route.setProductTypeName(Utils.getProductNameByCode(route.getProductType()));
            routePrice.setRoute(route);
        }
        return SUCCESS;
    }

    public String initPublishRoute() {
        routePrice = new RoutePrice();
        routePrice.setRouteID(routeID);
        Route route = routeService.get(routeID);
        route.setProductTypeName(Utils.getProductNameByCode(route.getProductType()));
        List<Journey> journeyList = new ArrayList<Journey>();
        for (Journey journey : route.getJourneySet()) {
            journey.setTrafficName(Utils.getTrafficName(journey.getTraffic()));
            journeyList.add(journey);
        }
        route.setJourneySet(journeyList);
        routePrice.setRoute(route);
        return SUCCESS;
    }

    public String publishRoute() {
        // 线路ID
        String routeID = routePrice.getRouteID();
        // 开始日期
        Date startDate = routePrice.getStartDate();
        // 结束日期
        Date endDate = routePrice.getEndDate();
        int totalDay = Utils.getIntervalDays(startDate, endDate) + 1;
        for (int i = 0; i < totalDay; i++) {
            RoutePrice newRoutePrice = new RoutePrice();
            // 线路ID
            newRoutePrice.setRouteID(routeID);
            // 儿童价格         ;
            newRoutePrice.setChildenPrice(routePrice.getChildenPrice());
            // 成人价格
            newRoutePrice.setAdultPrice(routePrice.getAdultPrice());
            // 去程航班信息
            newRoutePrice.setStartFlightInfo(routePrice.getStartFlightInfo());
            // 返程航班信息
            newRoutePrice.setEndFlightInfo(routePrice.getEndFlightInfo());
            // 人数
            newRoutePrice.setTotalPeople(routePrice.getTotalPeople());
            // 出团日期
            newRoutePrice.setPublishDate(Utils.getDifferDate(startDate, i));
            routePriceService.save(newRoutePrice);
        }
        return SUCCESS;
    }

    public String initUpdateRoutePrice() {
        routePrice = routePriceService.get(id);
        Route route = routeService.get(routePrice.getRouteID());
        route.setProductTypeName(Utils.getProductNameByCode(route.getProductType()));
        List<Journey> journeyList = new ArrayList<Journey>();
        for (Journey journey : route.getJourneySet()) {
            journey.setTrafficName(Utils.getTrafficName(journey.getTraffic()));
            journeyList.add(journey);
        }
        route.setJourneySet(journeyList);
        routePrice.setRoute(route);
        return SUCCESS;
    }

    public String updateRoutePrice() {
        routePriceService.save(routePrice);
        return SUCCESS;
    }

    public String view() {
        routePrice = routePriceService.get(id);
        Route route = routeService.get(routePrice.getRouteID());
        for (int i = 0; i < route.getJourneySet().size(); i++) {
            Journey journey = route.getJourneySet().get(i);
            journey.setTrafficName(Utils.getTrafficName(journey.getTraffic()));
        }
        routePrice.setRoute(route);
        return SUCCESS;
    }

    public String delete() {
        routePriceService.delete(id);
        return SUCCESS;
    }
}
