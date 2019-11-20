package com.wap.Dictionary.Controller.Search;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "SearchServlet")
@WebServlet(name = "SearchServlet", urlPatterns = {"/Search"}, description = "SearchController")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchword=request.getParameter("searchkeyword");
        String API_URL="https://wordsapiv1.p.rapidapi.com/words/" + searchword;
        //"https://wordsapiv1.p.mashape.com/words/soliloquy"
        try {
            HttpResponse<String> response1 = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/"+searchword)
                    .header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
                    .header("x-rapidapi-key", "22251f27f5msh98b626b0aa00856p148b29jsn59ff32bb0141")
                    .asString();
            System.out.println(response1.getBody());
        } catch (UnirestException e) {
            e.printStackTrace();
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Search.jsp").forward(request, response);
    }
}
