package com.wap.Dictionary.Controller.SignIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/*@WebServlet(name = "SignInServlet" )*/
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignIn"}, description = "SignInController")
public class SignInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.println("fafa");
        System.out.println("Hello");
        request.getRequestDispatcher("/SignIn.jsp").forward(request, response);
    }
}
