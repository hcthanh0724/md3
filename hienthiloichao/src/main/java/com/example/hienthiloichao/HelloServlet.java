package com.example.hienthiloichao;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class HelloServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        if("admin".equals(username) && "admin".equals(password)){
            writer.println("<h1>Welcome " +username+ "to website </h1>");
        }
        else {
            writer.println("<h1>Login Error</h1>");
        }
        writer.println("</html>");
    }
}