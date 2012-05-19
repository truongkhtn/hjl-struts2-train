package com.company.travel.controller;

import com.company.travel.entity.*;
import com.company.travel.service.*;
import com.company.travel.utils.Utils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Route Action 类，包含对于所有 Route 对象的操作
 *
 * @author 胡荆陵
 */
@Controller
@Scope("prototype")
public class OrderAction extends BasePagerAction {

    private String routePriceID;
    private Order order;
    private String status;
    private List<Order> orderList;

    @Resource
    private OrderService orderService;
    @Resource
    private TravellerInfoService travellerInfoService;
    @Resource
    private RouteService routeService;
    @Resource
    private UserService userService;
    @Resource
    private RoutePriceService routePriceService;

    //getter & setter
    public String getRoutePriceID() {
        return routePriceID;
    }

    public void setRoutePriceID(String routePriceID) {
        this.routePriceID = routePriceID;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public RouteService getRouteService() {
        return routeService;
    }

    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    public RoutePriceService getRoutePriceService() {
        return routePriceService;
    }

    public void setRoutePriceService(RoutePriceService routePriceService) {
        this.routePriceService = routePriceService;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String list() {
        if (pager == null) {
            pager = new Pager();
        }
        String[] orderBys = new String[2];
        Pager.OrderType[] orderTypes = new Pager.OrderType[2];
        orderBys[0] = "createDate";
        orderBys[1] = "userID";
        orderTypes[0] = Pager.OrderType.desc;
        orderTypes[1] = Pager.OrderType.asc;
        pager.setOrderBys(orderBys);
        pager.setOrderTypes(orderTypes);
        pager = orderService.findByPager(pager);
        if (pager.getList() != null && pager.getList().size() > 0) {
            for (int i = 0; i < pager.getList().size(); i++) {
                Order order = (Order) pager.getList().get(i);
                order.setStatusName(Utils.getOrderStatus(order.getStatus()));
                if (order.getId() != null && !order.getId().equals("")) {
                    // 设置旅客信息
                    List<TravellerInfo> travellerInfoList = travellerInfoService.getList("orderID", order.getId());
                    order.setTravellerInfoList(travellerInfoList);
                }
                // 设置旅行社信息
                if (order.getUserID() != null && !order.getUserID().equals("")) {
                    User user = userService.get(order.getUserID());
                    order.setStatusName(Utils.getOrderStatus(order.getStatus()));
                    order.setUser(user);
                }
                // 设置线路相关信息
                if (order.getRoutePriceID() != null && !order.getRoutePriceID().equals("")) {
                    RoutePrice routePrice = routePriceService.get(order.getRoutePriceID());
                    Route route = routeService.get(routePrice.getRouteID());
                    route.setProductTypeName(Utils.getProductNameByCode(route.getProductType()));
                    routePrice.setRoute(route);
                    order.setRoutePrice(routePrice);
                }
            }
        }
        return SUCCESS;
    }

    public String initBooking() {
        order = new Order();
        order.setStatus("1");
        order.setStatusName(Utils.getOrderStatus("1"));
        order.setVersion(0);
        // 设置线路价格信息
        RoutePrice routePrice = routePriceService.get(routePriceID);
        order.setRoutePrice(routePrice);
        order.setRoutePriceID(routePrice.getId());
        // 设置线路基本信息
        if (routePrice.getRouteID() != null && !routePrice.getRouteID().equals("")) {
            Route route = routeService.get(routePrice.getRouteID());
            routePrice.setRoute(route);
        }
        // 设置登录旅行社信息
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        order.setUser(user);
        order.setUserID(user.getId());
        // 默认添加一行旅客信息
        List<TravellerInfo> travellerInfoList = new ArrayList<TravellerInfo>();
        TravellerInfo travellerInfo = new TravellerInfo();
        travellerInfo.setSeq("1");
        travellerInfo.setSex("1");
        travellerInfoList.add(travellerInfo);
        order.setTravellerInfoList(travellerInfoList);
        return SUCCESS;
    }

    public String view() {
        order = orderService.get(id);
        order.setStatusName(Utils.getOrderStatus(order.getStatus()));
        if (order.getRoutePriceID() != null && !order.getRoutePriceID().equals("")) {
            // 设置线路价格信息
            RoutePrice routePrice = routePriceService.get(order.getRoutePriceID());
            order.setRoutePrice(routePrice);
            // 设置线路基本信息
            Route route = routeService.get(routePrice.getRouteID());
            routePrice.setRoute(route);
        }
        // 设置登录旅行社信息
        if (order.getUserID() != null && !order.getUserID().equals("")) {
            User user = userService.get(order.getUserID());
            order.setUser(user);
        }
        // 取得所有旅客信息
        List<TravellerInfo> travellerInfoList = travellerInfoService.getList("orderID", order.getId());
        for (int i = 0; i < travellerInfoList.size(); i++) {
            TravellerInfo travellerInfo = travellerInfoList.get(i);
            travellerInfo.setSexName(Utils.getSexName(travellerInfo.getSex()));
            travellerInfo.setPeopleTypeName(Utils.getPeopleTypeName(travellerInfo.getPeopleType()));
            travellerInfo.setCertificateTypeName(Utils.getCertificateType(travellerInfo.getCertificateType()));
        }
        order.setTravellerInfoList(travellerInfoList);
        return SUCCESS;
    }

    public String booking() {
        for (int i = 0; i < order.getTravellerInfoList().size(); i++) {
            TravellerInfo travellerInfo = order.getTravellerInfoList().get(i);
            travellerInfo.setSeq(String.valueOf(i + 1));
        }
        orderService.save(order);
        return SUCCESS;
    }

    public String updateBooking() {
        List<TravellerInfo> list = travellerInfoService.getList("orderID", order.getId());
        for (TravellerInfo travellerInfo : list) {
            travellerInfoService.delete(travellerInfo);
        }
        for (int i = 0; i < order.getTravellerInfoList().size(); i++) {
            TravellerInfo travellerInfo = order.getTravellerInfoList().get(i);
            travellerInfo.setSeq(String.valueOf(i + 1));
        }
        orderService.update(order);
        return SUCCESS;
    }

    public String updateOrderStatus() {
        orderService.updateOrderStatus(id, status);
        return SUCCESS;
    }

    //更新订单状态 ajax 方法
    public String updateOrderStatusAjax() {
        orderService.updateOrderStatus(id, status);
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put(MESSAGE, SUCCESS);
        String content = "操作成功:订单处于";
        //1:未确认/2:已确认/3:已取消
        if("1".equals(status)){
            content += "未确认";
        }else if("2".equals(status)){
            content += "已确认";
        }else if("3".equals(status)){
            content += "已取消";
        }
        jsonMap.put(CONTENT, content);
        return ajaxJson(jsonMap);
    }

    public String delete() {
        orderService.delete(id);
        List<TravellerInfo> list = travellerInfoService.getList("orderID", id);
        for (TravellerInfo travellerInfo : list) {
            travellerInfoService.delete(travellerInfo);
        }
        return SUCCESS;
    }

    public String query() {
        if ("0".equals(order.getStatus())
                && order.getCreateDate() == null
                && order.getModifyDate() == null) {
            return LIST;
        } else {
            DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Order.class);
            if (order.getCreateDate() != null) {
                detachedCriteria.add(Restrictions.gt("createDate", order.getCreateDate()));
            }
            if (order.getModifyDate() != null) {
                detachedCriteria.add(Restrictions.lt("createDate", order.getModifyDate()));
            }
            if (!"0".equals(order.getStatus())) {
                detachedCriteria.add(Restrictions.eq("status", order.getStatus()));
            }
            pager = orderService.findByPager(pager, detachedCriteria);
            if (pager.getList() != null && pager.getList().size() > 0) {
                for (int i = 0; i < pager.getList().size(); i++) {
                    Order order = (Order) pager.getList().get(i);
                    order.setStatusName(Utils.getOrderStatus(order.getStatus()));
                    if (order.getId() != null && !order.getId().equals("")) {
                        // 设置旅客信息
                        List<TravellerInfo> travellerInfoList = travellerInfoService.getList("orderID", order.getId());
                        order.setTravellerInfoList(travellerInfoList);
                    }
                    // 设置旅行社信息
                    if (order.getUserID() != null && !order.getUserID().equals("")) {
                        User user = userService.get(order.getUserID());
                        order.setStatusName(Utils.getOrderStatus(order.getStatus()));
                        order.setUser(user);
                    }
                    // 设置线路相关信息
                    if (order.getRoutePriceID() != null && !order.getRoutePriceID().equals("")) {
                        RoutePrice routePrice = routePriceService.get(order.getRoutePriceID());
                        Route route = routeService.get(routePrice.getRouteID());
                        route.setProductTypeName(Utils.getProductNameByCode(route.getProductType()));
                        routePrice.setRoute(route);
                        order.setRoutePrice(routePrice);
                    }
                }
            }
            return SUCCESS;
        }
    }
}
