package com.test.servlet; /**
 * Created by IntelliJ IDEA.
 * User: Administrator
 * Date: 12-12-14
 * Time: 下午3:54
 * To change this template use File | Settings | File Templates.
 */

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;

@WebListener()
public class MyAppListener implements ServletContextListener {

    // Public constructor is required by servlet spec
    public MyAppListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        String cron = context.getInitParameter("cron");
        try {
            SchedulerFactory sf = new StdSchedulerFactory();
            Scheduler scheduler = sf.getScheduler();

            JobDetail job = JobBuilder.newJob(SimpleJob.class)
            .build();

            CronTrigger trigger = TriggerBuilder.newTrigger()
            .withSchedule(cronSchedule(cron))
            .build();

            Date date = scheduler.scheduleJob(job, trigger);
            System.out.println("计划任务将运行于:"+date.toLocaleString());

            scheduler.start();//启动调度
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is invoked when the Servlet Context 
           (the Web application) is undeployed or 
           Application Server shuts down.
        */
    }
}
