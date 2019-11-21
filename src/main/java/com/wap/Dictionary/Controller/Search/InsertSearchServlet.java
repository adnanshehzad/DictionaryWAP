package com.wap.Dictionary.Controller.Search;

import com.wap.Dictionary.Model.SearchInfo.SearchEntity;
import com.wap.Dictionary.Model.User.UserEntity;
import com.wap.Dictionary.daos.SearchDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertSearchServlet",urlPatterns = "/Insert-search")
public class InsertSearchServlet extends HttpServlet {
    private SearchDao searchDao;
    public InsertSearchServlet(){this.searchDao=new SearchDao();};
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SearchEntity searchEntity= (SearchEntity) request.getAttribute("searchdata");
        searchDao.insertAPIData(searchEntity); //Inserting into Database
        System.out.println("API data Inserted Successfully into Database");
        response.sendRedirect(request.getContextPath()+ "/first.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
