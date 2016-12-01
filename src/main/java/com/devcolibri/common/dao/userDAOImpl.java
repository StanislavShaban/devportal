package com.devcolibri.common.dao;

import com.devcolibri.common.model.UserProfile;
import com.devcolibri.common.model.Users;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by s on 11.11.16.
 */
public class userDAOImpl implements userDAO {

    private SessionFactory sessionFactory;
    public userDAOImpl(SessionFactory sessionFactory){

        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Users> getListOfUsers() {
        @SuppressWarnings("unchecked")
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Users").list();
    }

    @Override
    @Transactional
    public UserProfile findUser(String username){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from UserProfile where username = :name");
        query.setParameter("name", username);
        UserProfile u_profile = (UserProfile)query.list().get(0);
        return u_profile;
    }

    @Override
    @Transactional
    public List<UserProfile> getUserProfileList(){
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from UserProfile").list();
    }

    @Override
    @Transactional
    public Users getUserRole(String name){
        Session session = sessionFactory.getCurrentSession();
        Users user = (Users)session.createQuery("from Users where username = :name").
                list().get(0);
        return user;
    }

    @Override
    @Transactional
    public Users getUserByName(String username) {
        Session session = sessionFactory.getCurrentSession();
        Users user = (Users)session.createQuery("from Users where username = :name").
                setParameter("name", username).
                list().get(0);
        return user;
    }
}
