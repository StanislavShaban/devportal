package com.devcolibri.common.controller.user;

/**
 * Created by s on 23.11.16.
 */

import com.devcolibri.common.dao.projectsDAO;
import com.devcolibri.common.dao.userDAO;
import com.devcolibri.common.model.Projects;
import com.devcolibri.common.model.UserProfile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

@Controller
public class userController {
    userDAO userDao;
    projectsDAO projectsDao;
    UserProfile userProfile;
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

    @RequestMapping(value = "/user/profile")
    public ModelAndView getUserProfile(ModelAndView model){
        String currentSession_username;
        ModelMap modelMap = new ModelMap();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        currentSession_username = auth.getName();

        userDao = (userDAO)context.getBean("userDao");
        userProfile = userDao.findUser(currentSession_username);
        model.setViewName("userProfile");
        modelMap.addAttribute("NameSurname", userProfile.getName()+ " " + userProfile.getSurname());
        modelMap.addAttribute("UserMail", userProfile.getEmail());
        modelMap.addAttribute("UserBirthday", userProfile.getBirthday());
        modelMap.addAttribute("UserCountry", userProfile.getCountry());
        model.addAllObjects(modelMap);
        return model;
    }

    @RequestMapping(value = "/user/projects", method = RequestMethod.GET)
    public ModelAndView getProjects(ModelAndView model){
        ModelMap modelMap = new ModelMap();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();

        projectsDao = (projectsDAO)context.getBean("projectDao");
        List<Projects> list = projectsDao.getListOfProjects();
        model.setViewName("projectPage");
        modelMap.addAttribute("projectList", list);
        modelMap.addAttribute("projectCount", list.size());
        model.addAllObjects(modelMap);
        return model;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("mainPage");
        projectsDao = (projectsDAO)context.getBean("projectDao");
        List<Projects> list = projectsDao.getListOfProjects();
        model.addAttribute("currentSessionUsername", auth.getName());
        model.addAttribute("projectCount", list.size());
        mv.addAllObjects(model);
        return mv;
    }

    @RequestMapping(value = "/user/test", method = RequestMethod.GET)
    public ModelAndView test(ModelAndView model){
        model.setViewName("blank-page");
        return model;
    }

    @RequestMapping(value = "/user/workers")
    public ModelAndView getCoWorkers(ModelAndView model){
        userDao = (userDAO)context.getBean("userDao");
        model.setViewName("userProfileList");
        model.addObject(userDao.getUserProfileList());
        return model;
    }

    @RequestMapping(value = "/user/projects/description")
    public ModelAndView getProjectDescription(int id){
        ModelMap mp = new ModelMap();
        ModelAndView model = new ModelAndView();
        model.setViewName("projectDescription");
        projectsDao = (projectsDAO)context.getBean("projectDao");
        List<Projects> list = projectsDao.getListOfProjects();
        Iterator<Projects> iter = list.iterator();
        Projects proj = null;
        while(iter.hasNext()){
            proj = iter.next();
            if(proj.getProjectId() == id){
                mp.addAttribute("title", proj.getProjectName());
                mp.addAttribute("description", proj.getProjectDescription());
            }
        }
        model.addAllObjects(mp);
        return model;
    }
}
