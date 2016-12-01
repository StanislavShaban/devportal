package com.devcolibri.common.controller;

import com.devcolibri.common.dao.projectsDAO;
import com.devcolibri.common.dao.userDAO;
import com.devcolibri.common.model.Projects;
import com.devcolibri.common.model.Users;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(value={"/user", "/admin"})
public class HelloController {

	projectsDAO projectsDao;
	ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
	@RequestMapping(value = "/mainPageParam", method = RequestMethod.GET)
	public String printSomeData(@RequestParam("login") String column1,
								  ModelMap model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext("context.xml");
		testClass obj;
		userDAO userDao;
		userDao = (userDAO)ctx2.getBean("userDao");
		obj = (testClass)ctx.getBean("helloBean");
		List<Users> list = userDao.getListOfUsers();

//		int size = list.size();
//		Users user = new Users();
//		user.setEmail("def327@gmail.com");
//		user.setId(size);
//		user.setLogin("Dima");
//		user.setPassword("3842940Dima");
//		userDao.insertUser(user);
//		list = userDao.getListOfUsers();

		model.addAttribute("message", "Authorised User " + obj.testMethod(column1));
		model.addAttribute("users", list);

		return "hello";
	}


	@RequestMapping(value = "/main", method = RequestMethod.GET)
    public ModelAndView mainPage(ModelAndView model){
        model.setViewName("main");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelMap modelMap = new ModelMap();
		projectsDao = (projectsDAO)context.getBean("projectDao");
		List<Projects> list = projectsDao.getListOfProjects();
		modelMap.addAttribute("currentSessionUsername", auth.getName());
		modelMap.addAttribute("projectCount", list.size());
		model.addAllObjects(modelMap);
		return model;
    }

//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ModelAndView mainPage(ModelAndView model){
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		String name = auth.getName();
//		model.setViewName("mainPage");
//		model.addObject("message", name);
//        return model;
//    }
//
//	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
//	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
//
//		ModelAndView model = new ModelAndView();
//		if (error != null) {
//			model.addObject("error", "Invalid username or password!");
//		}
//
//		model.setViewName("login");
//
//		return model;
//
//	}
	
}