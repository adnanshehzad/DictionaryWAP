package com.wap.Dictionary.Controller.Search;

import com.wap.Dictionary.Model.SearchInfo.SearchEntity;
import com.wap.Dictionary.Model.User.UserEntity;
import com.wap.Dictionary.daos.SearchDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "InsertSearchServlet",urlPatterns = "/Insert-search")
public class InsertSearchServlet extends HttpServlet {
    private SearchDao searchDao;
    public InsertSearchServlet(){this.searchDao=new SearchDao();};
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SearchEntity searchEntity= (SearchEntity) request.getAttribute("searchdata");
        searchDao.insertAPIData(searchEntity); //Inserting into Database
        HttpSession session = request.getSession();
        List<String> previouswords=searchDao.ShowUserPreviousSearchWords((String) session.getAttribute("username"));
        System.out.println("Previous Words List for user is :" + previouswords.toString());
        session.setAttribute("previouswords",previouswords);
        System.out.println("API data Inserted Successfully into Database");
        RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
