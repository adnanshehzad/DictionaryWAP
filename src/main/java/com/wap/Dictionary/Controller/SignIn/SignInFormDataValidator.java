package com.wap.Dictionary.Controller.SignIn;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wap.Dictionary.Model.User.UserEntity;
import com.wap.Dictionary.daos.UserDao;

/**
 * Servlet implementation class SignInValidatorServlet
 */
@WebServlet(name = "SignInFormDataValidator", urlPatterns = {"/signin-form-data-validator"}, description = "SignInFormDataValidator")
public class SignInFormDataValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInFormDataValidator() {
		super();
    	this.userDao=new UserDao();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/SignIn");
	}//end_doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   	
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        
        System.out.println("Username: " + userName);
        System.out.println("Password: " + password);
        
        UserEntity aUser = new UserEntity(userName,password);
        request.setAttribute("signinFormData", aUser);
        
        String missingFieldsMsg = "";
        if(userName.equals("")){
        	missingFieldsMsg += "<span style='color:red;font-size:1em'>Username is missing.</span><br/>";
        }
        if(password.equals("")){
        	missingFieldsMsg += "<span style='color:red; font-size:1em; '>Password is missing.</span><br/>";        	
        }
        
        if(!missingFieldsMsg.equals("")) {
            request.setAttribute("isErrMsgsPresent", true);
            request.setAttribute("errMsgs", missingFieldsMsg);
            System.out.println(missingFieldsMsg);
            request.getRequestDispatcher("/SignIn").forward(request, response);
            //request.getServletContext().getRequestDispatcher("/SignIn.jsp").forward(request, response);
            
        }
        else {
        	System.out.println("here to debug");
    		UserEntity userForm = (UserEntity)request.getAttribute("signinFormData");
    		String uname = userForm.getUserName();
    		String pwd = userForm.getPassword();
    		
        	boolean checkAccountExist = userDao.checkUserNameandPassword(uname, pwd);
        
        	if(checkAccountExist) {
        		String welcomeStr = "Welcome " + uname;
        		request.setAttribute("isAccountExist", true);
        		request.setAttribute("welcomeUser", welcomeStr);
        		System.out.println("Welcome " + welcomeStr);
           		//back to homepage + show Welcome , change SignIn - SignOut        	
        		response.sendRedirect(request.getContextPath() + "/Search.jsp");

        	}else {
        		
        		String errAccount = "<span style='color:red; font-size:1em; '>Username or Password do not match.</span><br/>";        	
        		request.setAttribute("isAccountNotExist", true);
        		request.setAttribute("errAccount", errAccount);
        		System.out.println(errAccount);
                request.getRequestDispatcher("/SignIn").forward(request, response);
        	}//end_if
    		
        }//end_if
                
	}//end_doPost

}//end_class
