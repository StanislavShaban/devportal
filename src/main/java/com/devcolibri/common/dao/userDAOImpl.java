package com.devcolibri.common.dao;

import com.devcolibri.common.model.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        List<Users> list = (List<Users>) sessionFactory.getCurrentSession()
                .createCriteria(Users.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        return list;
    }

    @Override
    @Transactional
    public void insertUser(Users user){
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

}
