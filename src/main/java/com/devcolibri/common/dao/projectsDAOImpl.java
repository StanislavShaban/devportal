package com.devcolibri.common.dao;

import com.devcolibri.common.model.Projects;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by s on 24.11.16.
 */
public class projectsDAOImpl implements projectsDAO {
    private SessionFactory sessionFactory;

    public projectsDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public List<Projects> getListOfProjects() {
        @SuppressWarnings("unchecked")
        List<Projects> list = sessionFactory.getCurrentSession()
                .createQuery("from Projects")
                .list();
        return list;
    }

    @Override
    @Transactional
    public void addProject(Projects  projects){
        Session session = sessionFactory.getCurrentSession();
        session.save(projects);
    }
}
