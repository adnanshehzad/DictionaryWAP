package com.wap.Dictionary.daos;

import com.mysql.cj.Session;
import com.wap.Dictionary.Model.SearchInfo.SearchEntity;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.jnlp.ClipboardService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchDao {
    private DataSource dataSource;
    public SearchDao(){
        try{
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:comp/env");
            this.dataSource = (DataSource) envContext.lookup("jdbc/dictionary_schema");
        }
        catch (NamingException ex){
            System.err.println(ex);
        }
    }
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void insertAPIData(SearchEntity searchEntity) {
        String sql="insert into `dictionary_schema`.searchdata(word,username,data) values(?,?,?)";
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            String uname= (String) searchEntity.getSession().getAttribute("username");
            ps.setString(1, searchEntity.getWord());
            ps.setString(2, uname);
            ps.setString(3,  searchEntity.getJsondata());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }

    public JSONObject searchWordFromDatabase(String word){
        JSONObject value=null;
        String sql="SELECT data from `dictionary_schema`.searchdata where word=?";
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, word);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String data=rs.getString("data");
                value=new JSONObject(data);
                return value;
            }
        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
        return value;
    }
    public List<String> ShowUserPreviousSearchWords(String uname){
        List<String> wordsdata=new ArrayList<String>();
        String sql="SELECT word from `dictionary_schema`.searchdata where username=?";
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, uname);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                wordsdata.add(rs.getString("word"));
            }
            return wordsdata;
        } catch (SQLException exc) {
            throw new RuntimeException(exc);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
