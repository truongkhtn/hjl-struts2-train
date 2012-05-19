package com.company.travel.controller;

import com.company.travel.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

/**
 * Common Action 类，包含系统普通操作
 *
 * @author 胡荆陵
 */
@Controller
public class CommonAction extends BaseAction {

    private static final Logger log = Logger.getLogger(CommonAction.class);

    public String index() {
        log.debug("index run ...");

        log.debug("index end ...");
        return SUCCESS;
    }


}
