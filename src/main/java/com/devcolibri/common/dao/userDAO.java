package com.devcolibri.common.dao;

import com.devcolibri.common.model.Users;

import java.util.List;

/**
 * Created by s on 11.11.16.
 */
public interface userDAO {
    public List<Users> getListOfUsers();
    public void insertUser(Users users);
}
