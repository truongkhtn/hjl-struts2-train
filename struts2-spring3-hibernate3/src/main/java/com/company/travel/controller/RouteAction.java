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
import java.util.*;

/**
 * Route Action 类，包含对于所有 Route 对象的操作
 *
 * @author 胡荆陵
 */
@Controller
@Scope("prototype")
public class RouteAction extends BasePagerAction {

    private Route route;
    private RoutePrice routePrice;
    private List<Route> routeList;
    private List<Journey> journeyList;

    @Resource
    private RouteService routeService;
    @Resource
    private RoutePriceService routePriceService;
    @Resource
    private JourneyService journeyService;

    //getter & setter
    public List<Route> getRouteList() {
        return routeList;
    }

    public void setRouteList(List<Route> routeList) {
        this.routeList = routeList;
    }

    public RoutePrice getRoutePrice() {
        return routePrice;
    }

    public void setRoutePrice(RoutePrice routePrice) {
        this.routePrice = routePrice;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public List<Journey> getJourneyList() {
        return journeyList;
    }

    public void setJourneyList(List<Journey> journeyList) {
        this.journeyList = journeyList;
    }

    public String blank() {
        return SUCCESS;
    }

    public String list() {
        routeList = routeService.getAll();
        for (int i = 0; i < routeList.size(); i++) {
            Route route = routeList.get(i);
            route.setProductTypeName(Utils.getProductNameByCode(route.getProductType()));
        }
        return SUCCESS;
    }

    public String initCreate() {
        route = new Route();
        journeyList = new ArrayList<Journey>();
        Journey journey = new Journey();
        journey.setSeq("1");
        journeyList.add(journey);
        return SUCCESS;
    }

    public String create() {
        routeService.save(route);
        for (int i = 0; i < journeyList.size(); i++) {
            Journey journey = journeyList.get(i);
            journey.setRouteID(route.getId());
            journey.setSeq(String.valueOf(i + 1));
            journeyService.save(journey);
        }
        return SUCCESS;
    }

    public String view() {
        route = routeService.get(id);
        route.setProductTypeName(Utils.getProductNameByCode(route.getProductType()));
        journeyList = new ArrayList<Journey>();
        for (Journey journey : route.getJourneySet()) {
            journey.setTrafficName(Utils.getTrafficName(journey.getTraffic()));
            journeyList.add(journey);
        }
        return SUCCESS;
    }

    public String initUpdate() {
        route = routeService.get(id);
        route.setProductTypeName(Utils.getProductNameByCode(route.getProductType()));
        journeyList = new ArrayList<Journey>();
        for (Journey journey : route.getJourneySet()) {
            journey.setTrafficName(Utils.getTrafficName(journey.getTraffic()));
            journeyList.add(journey);
        }
        return SUCCESS;
    }

    public String update() {
        //step 1 : delete old values
        List<Journey> list = journeyService.getList("routeID", route.getId());
        for (Journey oldValue : list) {
            journeyService.delete(oldValue);
        }
        //step 2 : update route
        routeService.update(route);
        //step 3 : save new journey
        if (journeyList != null && journeyList.size() > 0) {
            for (int i = 0; i < journeyList.size(); i++) {
                Journey journey = journeyList.get(i);
                journey.setRouteID(route.getId());
                journey.setSeq(String.valueOf(i + 1));
                journeyService.save(journey);
            }
        }
        return SUCCESS;
    }

    public String delete() {
        routeService.delete(id);
        return SUCCESS;
    }
}
