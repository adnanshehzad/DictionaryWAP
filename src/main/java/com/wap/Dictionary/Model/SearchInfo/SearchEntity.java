package com.wap.Dictionary.Model.SearchInfo;

import org.json.JSONObject;

import javax.servlet.http.HttpSession;

public class SearchEntity {
    private String word;
    private String jsondata;
    HttpSession session;

    public SearchEntity(String word, String jsondata, HttpSession session) {
        this.word = word;
        this.jsondata = jsondata;
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public SearchEntity(String word, String jsondata) {
        this.word = word;
        this.jsondata = jsondata;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getJsondata() {
        return jsondata;
    }

    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }

    @Override
    public String toString() {
        return "SearchEntity{" +
                "word='" + word + '\'' +
                ", jsondata=" + jsondata +
                '}';
    }
}
