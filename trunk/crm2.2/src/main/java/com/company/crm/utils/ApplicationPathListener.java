package com.company.crm.utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ApplicationPathListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute("path", event.getServletContext().getContextPath());
	}

}
