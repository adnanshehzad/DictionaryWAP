package com.wap.Dictionary.Controller.SignIn;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.Dictionary.Model.User.UserEntity;
import com.wap.Dictionary.daos.UserDao;

/**
 * Servlet implementation class SignInFormController
 */
@WebServlet(name = "SignInFormController", urlPatterns = {"/signin-form-controller"}, description = "SignInFormData")
public class SignInFormDataController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInFormDataController() {
        this.userDao = new UserDao();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.print("OMG");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		UserEntity userForm = (UserEntity)request.getAttribute("signinFormData");
		String userName = userForm.getUserName();
		String password = userForm.getPassword();
		
    	boolean checkAccountExist = userDao.checkUserNameandPassword(userName, password);
    
    	if(checkAccountExist) {
    		String welcomeStr = userName;
    		request.setAttribute("isAccountExist", true);
    		request.setAttribute("welcomeUser", welcomeStr);
    		System.out.println("Welcome " + welcomeStr);
       		//back to homepage + show Welcome , change SignIn - SignOut
    		request.getRequestDispatcher("/index.jsp").forward(request, response);

    	}else {
    		
    		String errAccount = "Username or Password do not match.";
    		request.setAttribute("isAccountNotExist", true);
    		request.setAttribute("errAccount", errAccount);
    		System.out.println(errAccount);
            request.getRequestDispatcher("/SignIn").forward(request, response);
    	}//end_if

	}//end_post

}//end_class
