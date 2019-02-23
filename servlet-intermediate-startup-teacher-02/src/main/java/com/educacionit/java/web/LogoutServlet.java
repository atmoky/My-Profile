
package com.educacionit.java.web;


import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet ("/logout")
public class LogoutServlet extends HttpServlet {


    private static final Logger logger = LoggerFactory.getLogger (LogoutServlet.class);


    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType ("text/html");
    	Cookie[] cookies = request.getCookies ();

    	if (cookies != null) {

    	    for (Cookie cookie : cookies){

    	        if (cookie.getName().equals ("JSESSIONID")){

    			logger.debug (String.format ("JSESSIONID %s", cookie.getValue ()));
    			break;
    		}
    	}
    	}

    	HttpSession session = request.getSession (false);
    	logger.debug (String.format ("User %s", session.getAttribute ("user")));

    	if (session != null) {
    		session.invalidate ();
    	}
    	response.sendRedirect ("login.html");
    }

}
