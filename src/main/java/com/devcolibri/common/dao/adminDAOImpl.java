package com.devcolibri.common.dao;

import com.devcolibri.common.model.Projects;
import com.devcolibri.common.model.UserProfile;
import com.devcolibri.common.model.Users;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class adminDAOImpl implements adminDAO{

    private SessionFactory sessionFactory;

    public adminDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public void addUser(Users user, UserProfile profile) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        session.save(profile);
    }

    @Override
    @Transactional
    public void deleteUser(String name) {
        Session session = sessionFactory.getCurrentSession();
        Users user = (Users)session.createQuery("from Users where username = :name").
                setParameter("name", name).
                list().get(0);
        session.delete(user);
    }

    @Override
    @Transactional
    public void changeProfileInfo(Users user, UserProfile profile) {
        String username = user.getUsername();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Users where username = :name");
        query.setParameter("name", username);
        session.update(user);
        query = session.createQuery("from UserProfile where username = :name");
        query.setParameter("name", username);
        session.update(profile);

    }

    @Override
    public void changeMainPageContent() {

    }

    @Override
    public void addProject(Projects project) {

    }

    @Override
    public void changeProjectInfo(Projects project) {

    }

    @Override
    public void deleteProject(Projects project) {

    }

    @Override
    public void addTask(Projects project) {

    }

    @Override
    public void changeTask(Projects project) {

    }

    @Override
    public void deleteTask(Projects project) {

    }
}
