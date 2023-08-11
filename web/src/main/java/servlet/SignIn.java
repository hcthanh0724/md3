package servlet;

import Manager.ManagerAccount;
import Model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Login")
public class SignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("accounts", ManagerAccount.accounts);
        RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
        dispatcher.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("uname");
        String pass = req.getParameter("psw");
        boolean check = false;
        for (Account acc1: ManagerAccount.accounts) {
            if(name.equals(acc1.getUsername()) && pass.equals(acc1.getPassword())){
                resp.sendRedirect("/Login.jsp");
                check = true;
                break;
            }
        }
        if(!check){
        resp.sendRedirect("/home.jsp");
    }}

}
