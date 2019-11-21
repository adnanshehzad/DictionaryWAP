package com.wap.Dictionary.Model.SearchInfo;

import org.json.JSONObject;

public class SearchEntity {
    private String word;
    private String jsondata;

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
