package com.wap.Dictionary.Controller.SignUp;

import com.wap.Dictionary.Model.User.UserEntity;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpServlet",urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String fname=request.getParameter("firstname");
        String lname=request.getParameter("lastname");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        // Check for missing fields data
        String missingFieldsMsg = "";
        if(username.equals("")) {
            missingFieldsMsg += "<span style='color:red;font-size:1em'>User Name is missing.</span><br/>";
        }
        if(fname.equals("null")) {
            missingFieldsMsg += "<span style='color:red;'>First Name is missing.</span><br/>";
        }
        if(lname.equals("null")) {
            missingFieldsMsg += "<span style='color:red;'>Last Name is missing.</span><br/>";
        }
        if(email.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Email is missing.</span><br/>";
        }
        if(password.equals("")) {
            missingFieldsMsg += "<span style='color:red;'>Password is missing.</span><br/>";
        }
        if(!missingFieldsMsg.equals("")) {
            request.setAttribute("isErrMsgsPresent", true);
            request.setAttribute("errMsgs", missingFieldsMsg);
            // forward (return) back to sender
            RequestDispatcher rd = request.getRequestDispatcher("/SignUp.jsp");
            rd.forward(request, response);
        } else {
            UserEntity userEntity=new UserEntity(username,fname,lname,email,password);
            request.setAttribute("userdata",userEntity);
            RequestDispatcher rd = request.getRequestDispatcher("/Save-Signup-Servlet");
            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("signin");
    }
}
