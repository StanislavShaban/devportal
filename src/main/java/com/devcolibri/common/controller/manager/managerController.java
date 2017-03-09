package com.devcolibri.common.controller.manager;

import com.devcolibri.common.dao.projectsDAO;
import com.devcolibri.common.model.Projects;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by s on 01.12.16.
 */
@Controller
public class managerController {

    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    projectsDAO projectsDao;

    @RequestMapping(value="/management")
    public ModelAndView mainPageView(ModelAndView model){
        model.setViewName("mainPage");
        return model;
    }

    @RequestMapping(value="/management/projectForm")
    public ModelAndView getView(ModelAndView model){
        model.setViewName("createProjectForm");
        return model;
    }

    @RequestMapping(value="/management/addProject", method = RequestMethod.POST)
    public @ResponseBody String addProject(String projectName, String description,
                    ModelAndView model){
        String result = "";
        Projects projects = new Projects();
        projectsDao = (projectsDAO)context.getBean("projectDao");
        try {
            projects.setProjectName(projectName);
            projects.setProjectDescription(description);
            projectsDao.addProject(projects);
            result = "<div class = 'alert alert-success' role = 'alert'>Succesfully inserted</div>";
        }catch(Exception e){
            result = "<div class = 'alert alert-danger' role = 'alert'>Not inserted</div>";
        }
        model.setViewName("createProjectForm");
        return result;
    }
}
