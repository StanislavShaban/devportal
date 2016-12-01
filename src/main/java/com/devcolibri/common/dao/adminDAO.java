package com.devcolibri.common.dao;

import com.devcolibri.common.model.Projects;
import com.devcolibri.common.model.UserProfile;
import com.devcolibri.common.model.Users;

/**
 * Created by s on 27.11.16.
 */
public interface adminDAO {
    public void addUser(Users user, UserProfile profile);
    public void deleteUser(String username);

    public void changeProfileInfo(Users user, UserProfile profile);

    public void changeMainPageContent();

    public void addProject(Projects project);
    public void changeProjectInfo(Projects project);
    public void deleteProject(Projects project);

    public void addTask(Projects project);
    public void changeTask(Projects project);
    public void deleteTask(Projects project);
}
