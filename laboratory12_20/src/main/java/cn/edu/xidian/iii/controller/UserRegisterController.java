package cn.edu.xidian.iii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.domain.User;
import cn.edu.xidian.iii.service.UserService;
import cn.edu.xidian.iii.util.CheckString;
import cn.edu.xidian.iii.util.Encryption;

@Controller
public class UserRegisterController {

	@Autowired
	private UserService userService;
	
@RequestMapping(value = "/user-register.do", method = RequestMethod.POST)
	public ModelAndView userRegister(HttpServletRequest request, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView("user_register");
		
		String studentNum = request.getParameter("student_num");
		if(!CheckString.checkStudentnum(studentNum)){
			mav.addObject("error", "学号格式不对！");
			return mav;
		}
		String password = request.getParameter("password");
		if (!CheckString.checkPassword(password)) {
			mav.addObject("error", "密码为6~16位！");
			return mav;
		}
		String userName = request.getParameter("user_name");
		//String cardcodeString = request.getParameter("cardcode");
		String email = request.getParameter("email");
		if (!CheckString.checkEmail(email)) {
			mav.addObject("error", "邮箱格式有误！");
			return mav;
		}
		String phone = request.getParameter("phone");
	
		//int cardcode = Integer.parseInt(cardcodeString);
		
		String password_jiami=Encryption.encryptSHA(password);
		//System.out.println(password_jiami);
		
		User user = new User(userName, "student", Integer.parseInt(phone.substring(3)), password_jiami, email, phone, studentNum);
		
		userService.register(user);
		mav.addObject("success","注册成功！");
		return mav;
	}
	
	@RequestMapping(value = "/user-register.do", method = RequestMethod.GET)
	public ModelAndView userRegisterGET(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("user_register");
		
		
		return mav;
	}
	
}
