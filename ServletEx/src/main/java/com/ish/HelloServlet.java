package com.ish;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {

//    important method in servlet is service
//    protected void service (HttpServletRequest request, HttpServletResponse response){
//        System.out.println("Servlet called");
//    }

    @Override
    protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet called");
//        resp.getWriter().write("Hello Servlet");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<p><i>Hello World</i></p>");
    }
}
