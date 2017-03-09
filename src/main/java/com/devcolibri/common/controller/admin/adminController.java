package com.devcolibri.common.controller.admin;

import com.devcolibri.common.dao.adminDAO;
import com.devcolibri.common.dao.projectsDAO;
import com.devcolibri.common.dao.userDAO;
import com.devcolibri.common.model.Projects;
import com.devcolibri.common.model.UserProfile;
import com.devcolibri.common.model.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by s on 27.11.16.
 */

@Controller
public class adminController {
    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    userDAO userDao;
    adminDAO adminDao;
    projectsDAO projectsDao;
    String response = "";

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelMap model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("adminPage");
        projectsDao = (projectsDAO)context.getBean("projectDao");
        List<Projects> list = projectsDao.getListOfProjects();
        model.addAttribute("currentSessionUsername", auth.getName());
        model.addAttribute("projectCount", list.size());
        mv.addAllObjects(model);
        return mv;
    }

    @RequestMapping(value = "/admin/insertUser", method = RequestMethod.POST)
    public @ResponseBody String insertUser(String firstName, String lastName, String email, String userName,
                           String password, String birthday, String country){
//        ModelAndView model = new ModelAndView();
//        model.setViewName("createUserForm");
        try{
            //Objects to fill in
            Users user = new Users();
            UserProfile userProfile = new UserProfile();

            //userDao init from context
            adminDao = (adminDAO)context.getBean("adminDao");

            //Setting parameters for user
            user.setUsername(userName);
            user.setPassword(password);
            user.setEnabled((byte)1);

            //Setting parameters for user profile
            userProfile.setUsername(userName);
            userProfile.setName(firstName);
            userProfile.setSurname(lastName);
            userProfile.setEmail(email);
            userProfile.setCountry(country);
            userProfile.setBirthday(birthday);
            adminDao.addUser(user, userProfile);
            response = "<div class = 'alert alert-success' role = 'alert'>Succesfully registered</div>";
//            model.addObject("result", response);
        }catch(Exception e) {
            response = "<div class = 'alert alert-danger' role = 'alert'>Registration error</div>";
//            model.addObject("result", response);
        }
        return response;
    }

    @RequestMapping(value = "/admin/userForm", method = RequestMethod.GET)
    public ModelAndView getUserForm(ModelAndView model){
        model.setViewName("createUserForm");
        return model;
    }

    @RequestMapping(value = "/admin/deleteUser")
    public @ResponseBody String deleteUser(String username){
        String result = "";
        try {
            adminDao = (adminDAO) context.getBean("adminDao");
            adminDao.deleteUser(username);
            result = "<div class = 'alert alert-success' role = 'alert'>Succesfully deleted</div>";
        }catch(Exception e){
            result = "<div class = 'alert alert-danger' role = 'alert'>Not deleted. Try again</div>";
        }
        return result;
    }

    @RequestMapping(value="/admin/editForm", method = RequestMethod.GET)
    public ModelAndView getEditForm(String username){
        userDao = (userDAO) context.getBean("userDao");
        UserProfile profile = userDao.findUser(username);
        Users user = userDao.getUserByName(username);
        ModelAndView model = new ModelAndView();
        model.setViewName("editForm");
        ModelMap mp = new ModelMap();
        mp.addAttribute("firstName", profile.getName());
        mp.addAttribute("lastName", profile.getSurname());
        mp.addAttribute("email", profile.getEmail());
        mp.addAttribute("userName", user.getUsername());
        mp.addAttribute("password", user.getPassword());
        mp.addAttribute("birthDate", profile.getBirthday());
        mp.addAttribute("country", profile.getCountry());
        model.addAllObjects(mp);
        return model;
    }

    @RequestMapping(value = "/admin/editUser", method = RequestMethod.GET)
    public @ResponseBody String editUser(String firstName, String lastName, String email,
                                 String password, String birthday, String userName, String country){
        String result = "";
        Users user = new Users();
        UserProfile profile = new UserProfile();
        user.setPassword(password);
        user.setUsername(userName);
        profile.setUsername(userName);
        profile.setName(firstName);
        profile.setSurname(lastName);
        profile.setEmail(email);
        profile.setBirthday(birthday);
        profile.setCountry(country);
        try {
            adminDao = (adminDAO) context.getBean("adminDao");
            adminDao.changeProfileInfo(user, profile);
            result = "<div class = 'alert alert-success' role = 'alert'>Succesfully changed</div>";
        }catch(Exception e){
            result = "<div class = 'alert alert-danger' role = 'alert'>Not changed. Try again</div>";
        }
        return result;
    }
}
