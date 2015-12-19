package cn.edu.xidian.iii.controller;

import cn.edu.xidian.iii.controller.LoginController;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.domain.User;
import cn.edu.xidian.iii.service.UserService;
import cn.edu.xidian.iii.util.CheckStyle;
import cn.edu.xidian.iii.util.Encryption;

@Controller
public class UserRegisterController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user-register.do", method = RequestMethod.POST)
	public ModelAndView userResister(HttpServletRequest request,
			HttpSession session) throws Exception {

		ModelAndView mav = new ModelAndView("user_register");

		String studentNum = request.getParameter("student_num");
		if (!CheckStyle.checkStringStudentnum(studentNum)) {
			System.out.println("学号格式不对");
			return mav;
		}
		String password = request.getParameter("password");
		String userName = request.getParameter("user_name");
		String cardcodeString = request.getParameter("cardcode");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");

		int cardcode = Integer.parseInt(cardcodeString);

		String password_jiami = Encryption.encryptSHA(password);
		System.out.println(password_jiami);

		User user = new User(userName, "student", cardcode, password_jiami,
				email, phone, studentNum);

		userService.register(user);

		return mav;
	}

	@RequestMapping(value = "/user-register.do", method = RequestMethod.GET)
	public ModelAndView userResisterGET(HttpServletRequest request,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("user_register");

		return mav;
	}

}
