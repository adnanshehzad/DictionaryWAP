package com.wap.Dictionary.daos;

import com.wap.Dictionary.Model.User.UserEntity;

public interface IUser {
    public void insertUserInfo(UserEntity user);
    public boolean userNameAlreadyExist(String username);
    public boolean checkUserNameandPassword(String username,String password);
}
