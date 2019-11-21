package com.wap.Dictionary.Controller.Search;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mysql.cj.xdevapi.JsonArray;
import com.wap.Dictionary.Model.SearchInfo.SearchEntity;
import com.wap.Dictionary.daos.SearchDao;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet",urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    private SearchDao searchDao;
    public SearchServlet(){this.searchDao=new SearchDao();}; //Constructor

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchword=request.getParameter("searchkeyword");
        JSONObject jsondatabase=searchDao.searchWordFromDatabase(searchword);
        System.out.println("Json database value is : "+ jsondatabase);
        if(jsondatabase==null) {
            String API_URL = "https://wordsapiv1.p.rapidapi.com/words/" + searchword;
            try {
                HttpResponse<JsonNode> response1 = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/" + searchword)
                        .header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
                        .header("x-rapidapi-key", "22251f27f5msh98b626b0aa00856p148b29jsn59ff32bb0141")
                        .asJson();
                JSONObject jsondata = response1.getBody().getObject();
                String json = jsondata.toString();
                String word = response1.getBody().getObject().getString("word");
                System.out.println("Json data is " + jsondata);
                System.out.println("Json word is " + word);
                SearchEntity searchEntity = new SearchEntity(word, json);
                request.setAttribute("searchdata", searchEntity);
                RequestDispatcher rd = request.getRequestDispatcher("/Insert-search");
                rd.forward(request, response);
//            JSONArray array=response1.getBody().getObject().getJSONArray("results");
//            for(int i=0;i<array.length();i++){
//                JSONObject obj1= array.getJSONObject(i);
//                String definition=obj1.getString("definition");
//                String partofspeech=obj1.getString("partOfSpeech");
//                System.out.println("Definition is :" + definition + " Part of Speech is : " + partofspeech);
                //}
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        else{
            //Show data From Database
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
