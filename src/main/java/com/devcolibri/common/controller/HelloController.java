package com.devcolibri.common.controller;

import com.devcolibri.common.dao.userDAO;
import com.devcolibri.common.dao.userDAOImpl;
import com.devcolibri.common.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HelloController {

//	@Autowired
//	private userDAO userDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView printWelcome(ModelAndView model) {

		model.setViewName("mainPage");
		model.addObject("message", "Stanislav");
		return model;
	}

	@RequestMapping(value = "/mainPageParam", method = RequestMethod.GET)
	public String printSomeData(@RequestParam("login") String column1,
								  ModelMap model) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext("userDAO-context.xml");
		testClass obj;
		userDAO userDao;
		userDao = (userDAO)ctx2.getBean("userDao");
		obj = (testClass)ctx.getBean("helloBean");
		List<Users> list = userDao.getListOfUsers();

		int size = list.size();
		Users user = new Users();
		user.setEmail("def327@gmail.com");
		user.setId(size);
		user.setLogin("Dima");
		user.setPassword("3842940Dima");
		userDao.insertUser(user);
		list = userDao.getListOfUsers();

		model.addAttribute("message", "Authorised User " + obj.testMethod(column1));
		model.addAttribute("users", list);

		return "hello";
	}


//	@RequestMapping(value = "/admin", method = RequestMethod.GET)
//    public ModelAndView adminPage(ModelAndView model){
//        model.setViewName("signin");
//        model.addObject("messageAdmin", "Hello, Stanislav! Please sign in!");
//        return model;
//    }


	
}