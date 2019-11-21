package com.wap.Dictionary.Controller.SignIn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.Dictionary.Model.User.UserEntity;
import com.wap.Dictionary.daos.UserDao;

import java.io.IOException;
import java.io.PrintWriter;


/*@WebServlet(name = "SignInServlet" )*/
@WebServlet(name = "SignInServlet", urlPatterns = {"/SignIn"}, description = "SignInController")
public class SignInServlet extends HttpServlet {
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doGet(request,response);
         
    }//end_doPost

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
    	request.getRequestDispatcher("/SignIn.jsp").forward(request, response);

    }//end_doGet
}//end_class
