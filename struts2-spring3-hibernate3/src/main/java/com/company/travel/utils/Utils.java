package com.company.travel.utils;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-3-29
 * Time: 下午10:18
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    public static String getProductNameByCode(String productCode) {
        if (productCode == null || productCode.equals("")) {
            return "";
        }
        if (productCode.equals("1")) {
            return "物价";
        } else if(productCode.equals("2")) {
            return "常规";
        } else if(productCode.equals("3")) {
            return "尊品";
        } else if(productCode.equals("4")) {
            return "纯玩";
        } else if(productCode.equals("5")) {
            return "老年团";
        } else {
            return "";
        }
    }
    public static String getOrderStatus(String status) {
        if (status == null || status.equals("")) {
            return "";
        }
        if (status.equals("1")) {
            return "未确认";
        } else if(status.equals("2")) {
            return "已确认";
        } else if(status.equals("3")) {
            return "已取消";
        } else {
            return "";
        }
    }

    public static int getIntervalDays(Date startday, Date endday) {
        if (startday.after(endday)) {
            Date cal = startday;
            startday = endday;
            endday = cal;
        }
        long sl = startday.getTime();
        long el = endday.getTime();
        long ei = el - sl;
        return (int) (ei / (1000 * 60 * 60 * 24));
    }

    public static Date getDifferDate(Date date, int days) {
        return new Date(date.getTime() + (long)days * 24 * 60 * 60 * 1000);
    }

    public static String getSexName(String sex) {
        if (sex == null || sex.equals("")) {
            return "";
        }
        if (sex.equals("1")) {
            return "男";
        } else if(sex.equals("2")) {
            return "女";
        } else {
            return "";
        }
    }

    public static String getPeopleTypeName(String peopleType) {
        if (peopleType == null || peopleType.equals("")) {
            return "";
        }
        if (peopleType.equals("1")) {
            return "成人";
        } else if(peopleType.equals("2")) {
            return "儿童";
        } else {
            return "";
        }
    }

    public static String getCertificateType(String certificateType) {
        if (certificateType == null || certificateType.equals("")) {
            return "";
        }
        if (certificateType.equals("1")) {
            return "身份证";
        } else if(certificateType.equals("2")) {
            return "护照";
        } else {
            return "";
        }
    }

    public static String getTrafficName(String traffic) {
        if (traffic == null || traffic.equals("")) {
            return "";
        }
        if (traffic.equals("1")) {
            return "飞机";
        } else if(traffic.equals("2")) {
            return "大巴";
        } else {
            return "";
        }
    }
}
