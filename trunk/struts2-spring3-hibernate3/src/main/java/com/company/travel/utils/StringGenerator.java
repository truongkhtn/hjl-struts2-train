package com.company.travel.utils;

import java.util.Random;

/**
 * public 账户随机产生工具
 */
public class StringGenerator {

    /**
     * public 账户随机产生方法
     * @param begin 开发字符串
     * @param length 随机字符长度
     * @return 随机账户
     */
    public static String getRandomString(String begin , int length) {
        begin += "-";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum))  // 字符串
            {
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母
                begin += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                // 数字
                begin += String.valueOf(random.nextInt(10));
            }
        }
        return  begin.toLowerCase();
    }
}
