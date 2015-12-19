package cn.edu.xidian.iii.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.domain.User;
//import cn.edu.xidian.iii.service.RoleService;
import cn.edu.xidian.iii.service.UserService;
//importcn.edu.xidian.iii.util.Constant;

@Controller
public class LoginController
{

	@Autowired
	private UserService userService;
	
	//@Autowired
	//private RoleService roleService;

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String showLogin()
	{
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, HttpSession session)
	{
		session = request.getSession();
		
		ModelAndView mav = new ModelAndView("login");

		String name = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User();
		user.setUserName(name);
		
		 try {
			if (!userService.loginCheck(name, password))
			{
				mav.addObject("wrong", true);
			}
			else
			{
				mav.setViewName("welcome");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;
	}

}
