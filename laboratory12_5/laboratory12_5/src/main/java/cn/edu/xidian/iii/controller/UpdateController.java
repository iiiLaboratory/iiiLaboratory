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

@Controller
public class UpdateController {
	@Autowired
	private UserService userService;
	
	private User user;
	
	@RequestMapping(value = "/update.do", method = RequestMethod.POST)
	public ModelAndView userResister(HttpServletRequest request, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView("update");
		
		
		String studentNum = request.getParameter("student_num");
		if (CheckString.checkStudentnum(studentNum)) {
			user=userService.findByStudentNum(studentNum);
			if(user==null){
				mav.addObject("error","该用户不存在！");
				return mav;
			}		
		}else {
			mav.addObject("error","学号格式错误！");
			return mav;
		}
		
		String email = request.getParameter("email");
		
		String phone = request.getParameter("phone");
		
		if (email == "" && phone == "") {
			mav.addObject("error", "没有进行任何修改！");
			return mav;
		}
		
		if (email != "") {
			if (CheckString.checkEmail(email)) {
				user.setEmail(email);
				mav.addObject("email", "邮箱");
			}else {
				mav.addObject("error","邮箱格式错误！");
				return mav;
			}
			
		}else {
			mav.addObject("email", "");
		}
		
		if (phone != "") {
			user.setPhone(phone);
			mav.addObject("phone", "手机");
		}
		else {
			mav.addObject("phone", "");
		}
		
		
		if (userService.updateUser(user)) {
			mav.addObject("success","修改成功！");
		}
		else {
			mav.addObject("fail", "修改失败，存在未知错误！");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/update.do", method = RequestMethod.GET)
	public ModelAndView userResisterGET(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("update");
		
		
		return mav;
	}
	

}
