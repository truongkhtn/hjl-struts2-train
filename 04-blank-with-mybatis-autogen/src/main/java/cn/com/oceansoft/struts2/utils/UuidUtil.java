package cn.com.oceansoft.struts2.utils;

import java.util.UUID;

/**
 * Author: 胡荆陵
 * Description: UUID 工具类
 */
public class UuidUtil {

    /**
     * 产生一个 uuid
     * @return uuid
     */
    public static String genUuid(){
        return UUID.randomUUID().toString().replaceAll("-" , "");
    };

    public static void main(String[] args) {
        System.out.println(genUuid());
        System.out.println(genUuid().length());
    }

}
