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

@Controller
public class UserManageController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user-manage.do", method = RequestMethod.POST)
	public ModelAndView userManage(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("user_manage");
		String studentNum = request.getParameter("student_num");
		String password = request.getParameter("password");
		session = request.getSession();
		User user = userService.findByStudentNum(studentNum);
		
		if (user != null) {
			System.out.println(user.getRole());

			if (userService.loginCheck(studentNum, password)) {
				System.out.println("mi ma zheng que");
				mav.addObject("user", user);
			} else {
				System.out.println("mi ma cuo wu");
			}

		} else {
		 System.out.println("this user is not exist");
		}
		
		return mav;
	}

	@RequestMapping(value = "/user-manage.do", method = RequestMethod.GET)
	public ModelAndView userManageGET(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("user_manage");

		return mav;
	}

}
