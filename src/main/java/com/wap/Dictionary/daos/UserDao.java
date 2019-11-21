package com.wap.Dictionary.daos;

import com.wap.Dictionary.Model.User.UserEntity;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements IUser{
    private DataSource dataSource;

    public UserDao(){
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
    @Override
    public void insertUserInfo(UserEntity user) {
        String sql="insert into `dictionary_schema`.userinfo values(?,?,?,?,?)";
        Connection connection=null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPassword());
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

    @Override
    public boolean userNameAlreadyExist(String username) {
        String sql="Select * from `dictionary_schema`.userinfo where username=?";
        Connection connection=null;

        try{
        connection=dataSource.getConnection();
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs= ps.executeQuery();
        while(rs.next()){
            String uname=rs.getString("username");
            String fname=rs.getString("firstname");
            String lname=rs.getString("lastname");
            String email=rs.getString("email");
            String pass=rs.getString("password");
            UserEntity user=new UserEntity(uname,fname,lname,email,pass);
            ps.close();
            rs.close();
            return true;
        }
        }
        catch (Exception exc){
            throw new RuntimeException(exc);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        return false;
    }

    @Override
    public boolean checkUserNameandPassword(String username, String password) {
        String sql="Select * from `dictionary_schema`.userinfo where username=? and password=?";
        Connection connection=null;
        try {
            connection=dataSource.getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                String uname=rs.getString("username");
                String fname=rs.getString("firstname");
                String lname=rs.getString("lastname");
                String email=rs.getString("email");
                String pass=rs.getString("password");
                UserEntity user=new UserEntity(uname,fname,lname,email,pass);
                return true;
            }
        }
        catch (Exception exc){
            throw new RuntimeException(exc);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
        return false;
    }
}
