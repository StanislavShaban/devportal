package com.devcolibri.common.dao;

import com.devcolibri.common.model.Projects;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s on 24.11.16.
 */
public interface projectsDAO {
    public List<Projects> getListOfProjects();
}
