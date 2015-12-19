package cn.edu.xidian.iii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
	public ModelAndView userManage(HttpServletRequest request,
			HttpSession session) throws Exception {
		ModelAndView mav = new ModelAndView("user_manage");

		String studentNum = request.getParameter("student_num");
		String password = request.getParameter("password");
		session = request.getSession();
		User user = userService.findByStudentNum(studentNum);
		if (user != null) {
			System.out.println(user.getRole());

			if (userService.loginCheck(studentNum, password)) {
				System.out.println("mi ma zheng que");
				//ession.setAttribute("user", user);
				session.setAttribute("userphone", user.getPhone());//不知道这个以后用不用  我看见的异地次它就存在 所以我也没有删除这个
				session.setAttribute("userName", user.getUserName());				
				session.setAttribute("password", user.getPassword());
				//mav.addObject("username", user.getUserName());
				mav.addObject("role", user.getRole());
				session = request.getSession();
				String user_name= (String)session.getAttribute("userName");
				String pass_word=(String)session.getAttribute("password");
				JOptionPane.showMessageDialog(null, "welcome! "+"\n"+user_name+" "+pass_word);
			} else {
				JOptionPane.showMessageDialog(null,"用户名或密码错误!");
			}

		} else {
			JOptionPane.showMessageDialog(null,"this user is not exist!");
		}
		return mav;
	}

	@RequestMapping(value = "/user-manage.do", method = RequestMethod.GET)
	public ModelAndView userManageGET(HttpServletRequest request,
			HttpSession session) {
		ModelAndView mav = new ModelAndView("user_manage");

		return mav;
	}

}
