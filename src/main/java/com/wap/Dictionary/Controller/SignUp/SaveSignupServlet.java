package com.wap.Dictionary.Controller.SignUp;

import com.wap.Dictionary.Model.User.UserEntity;
import com.wap.Dictionary.daos.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Save-Signup-Servlet" ,urlPatterns = {"/Save-Signup-Servlet"})
public class SaveSignupServlet extends HttpServlet {
    private UserDao userDao;
    public SaveSignupServlet(){ //Intitalixation of Database in User Dao constructor
        this.userDao=new UserDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Adnan Shehzad Code for saving the data into the database
        UserEntity userEntity= (UserEntity) request.getAttribute("userdata");
        userDao.insertUserInfo(userEntity); //Inserting into Database
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.sendRedirect("/SignUp.jsp");
    }
}
