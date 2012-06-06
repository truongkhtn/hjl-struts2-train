package com.company.travel.utils;

import ognl.DefaultTypeConverter;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Hu Jing Ling
 * Date: 2/10/11
 * Time: 5:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class DateConverter extends DefaultTypeConverter {

    private static final Logger logger = Logger.getLogger(DateConverter.class);
    private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String MONTH_PATTERN = "yyyy-MM";

    public Object convertValue(Map ognlContext, Object value, Class toType) {
        Object result = null;
        if (toType == Date.class) {
            result = doConvertToDate(value);
        } else if (toType == String.class) {
            result = doConvertToString(value);
        }
        return result;
    }

    private Date doConvertToDate(Object value)  {
        Date result = null;
        if (value instanceof String) {
            if(StringUtils.isEmpty(String.valueOf(value))){
                return null;
            }
            try {
                result = DateUtils.parseDate((String) value, new String[]{DATE_PATTERN, DATETIME_PATTERN, MONTH_PATTERN});
            } catch (ParseException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            // all patterns failed, try a milliseconds constructor
            if (result == null && StringUtils.isNotEmpty((String) value)) {
                try {
                    result = new Date(new Long((String) value).longValue());
                } catch (Exception e) {
                    logger.error("Converting from milliseconds to Date fails!");
                    e.printStackTrace();
                }
            }
        } else if (value instanceof Object[]) {
            // let's try to convert the first element only
            Object[] array = (Object[]) value;
            if ((array != null) && (array.length >= 1)) {
                value = array[0];
                result = doConvertToDate(value);
            }
        } else if (Date.class.isAssignableFrom(value.getClass())) {
            result = (Date) value;
        }
        return result;
    }

    private String doConvertToString(Object value) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_PATTERN);
        String result = null;
        if (value instanceof Date) {
            result = simpleDateFormat.format(value);
        }
        return result;
    }

}
