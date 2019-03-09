
package com.educacionit.profile.web.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.educacionit.profile.data.db.DBConnectionManager;


@WebListener
public class AppContextListener implements ServletContextListener {


    public AppContextListener () {

        super ();
    }


    public void contextInitialized (ServletContextEvent servletContextEvent) {


    	ServletContext ctx = servletContextEvent.getServletContext ();
    	
    	String url = ctx.getInitParameter ("DBURL");
    	String u   = ctx.getInitParameter ("DBUSER");
    	String p   = ctx.getInitParameter ("DBPWD");
        String d   = ctx.getInitParameter ("DRIVER");

    	DBConnectionManager dbManager = new DBConnectionManager (url, u, p, d);
    	ctx.setAttribute ("db", dbManager);
    }

    public void contextDestroyed (ServletContextEvent servletContextEvent) {

    	ServletContext ctx = servletContextEvent.getServletContext ();
    	DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute ("db");
    	dbManager.closeConnection ();
    }
}