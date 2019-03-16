package com.educacionit.profile.web.listener.web;

import com.educacionit.profile.data.db.DBConnectionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ServletContext ctx = req.getServletContext();


        DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("db");

        Connection conn = dbManager.getConnection()

                try {

                String email = req.getParameter("txtEmail");
                String password = req.getParameter("txtPassword");

                    Statement stm = conn.createStatement();

                    ResultSet resultSet = stm.executeQuery ("SELECT * from profile WHERE email='" + email + "' AND password='" + password + "'");

                    while (resultSet.next()){

                        resp.sendRedirect("home.jsp");
                        break;
                    }
                    resp.sendRedirect("index.jsp");
                } catch (Exception e) {

                    resp.sendRedirect("err.jsp");
                }








    }
}
