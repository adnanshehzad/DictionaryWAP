package com.wap.Dictionary.daos;

import com.wap.Dictionary.Model.User.UserEntity;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String sql="insert into 'dictionary_schema'.userinfo values(?,?,?,?,?)";
        Connection connection=null;
        try{
            connection=dataSource.getConnection();
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getFirstName());
            ps.setString(3,user.getLastName());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPassword());
            ps.executeUpdate();
            ps.close();
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
    }

    @Override
    public boolean userNameAlreadyExist(String username) {
        //String sql=
        return false;
    }

    @Override
    public boolean checkUserNameandPassword(String username, String password) {
        return false;
    }
}
