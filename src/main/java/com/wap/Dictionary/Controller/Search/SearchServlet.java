package com.wap.Dictionary.Controller.Search;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.GetRequest;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonValue;
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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SearchServlet",urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
    private SearchDao searchDao;
    public SearchServlet(){this.searchDao=new SearchDao();}; //Constructor

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchword=request.getParameter("searchkeyword");
        JSONObject jsondatabase=searchDao.searchWordFromDatabase(searchword);
        System.out.println("Json database value is : "+ jsondatabase);
        int code=200;
        JSONObject jsondata=null;
        if(jsondatabase==null) {
            String API_URL = "https://wordsapiv1.p.rapidapi.com/words/" + searchword;
            try {
                HttpResponse<JsonNode> response1 = Unirest.get("https://wordsapiv1.p.rapidapi.com/words/" + searchword)
                        .header("x-rapidapi-host", "wordsapiv1.p.rapidapi.com")
                        .header("x-rapidapi-key", "22251f27f5msh98b626b0aa00856p148b29jsn59ff32bb0141")
                        .asJson();
                 code = response1.getStatus();
                if(code==200) {
                    jsondata = response1.getBody().getObject();
                    String json = jsondata.toString();
                    String word = jsondata.getString("word");
                    System.out.println("Json data is " + jsondata);
                    System.out.println("Json word is " + word);
                    HttpSession session = request.getSession();
                    SearchEntity searchEntity = new SearchEntity(word, json, session);
                    request.setAttribute("searchdata", searchEntity);
                    showDatatoSearchJsp(request, response, jsondata,code);
                    RequestDispatcher rd = request.getRequestDispatcher("/Insert-search");
                    rd.forward(request, response);
                }
                else
                {
                    showDatatoSearchJsp(request, response, jsondata,code);
                    RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
                    rd.forward(request, response);
                }


            /*JSONArray array=jsondata.getJSONArray("results");
            //for(int i=0;i<array.length();i++){
                JSONObject obj1= array.getJSONObject(1);
               String definition=obj1.getString("definition");
                String partofspeech=obj1.getString("partOfSpeech");
                System.out.println("Definition is :" + definition *//*+*//* *//*" Part of Speech is : " + partofspeech*//*);
               // }*/
            } catch (UnirestException | ServletException | IOException e) {
                e.printStackTrace();
            }
        }
        else{
            //Show data From Database
            showDatatoSearchJsp(request,response,jsondatabase,code);
            RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
            rd.forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
    public void showDatatoSearchJsp(HttpServletRequest request, HttpServletResponse response,JSONObject obj,int code){
        if (code==404)
        {
            request.setAttribute("def", "Word Does,nt Exist in Dictionary. Please try Another One");
            request.setAttribute("word", "Sorry");
            request.setAttribute("pos", "");
        }
        else {
            JSONArray array = obj.getJSONArray("results");
            //for(int i=0;i<array.length();i++){
            JSONObject resultsdata = array.getJSONObject(1);
            String definition = resultsdata.getString("definition");
            String word = obj.getString("word");
            String partofspeech = resultsdata.getString("partOfSpeech");
            //JSONObject synonmns=obj.getJSONObject("synonyms");
            //List<String> list = new ArrayList<String>();

            //syno.append(synonmns.toString());
            //System.out.println(list.toString());
            request.setAttribute("def", definition);
            request.setAttribute("pos", partofspeech);
            request.setAttribute("word", word);
            //request.setAttribute("synonymns",synonmns);
            System.out.println("Definition is :" + definition + " Part of Speech is : " + partofspeech + "Synonmn is: ");
            // }
        }
    }
}