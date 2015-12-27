package cn.edu.xidian.iii.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.service.UserService;
import cn.edu.xidian.iii.util.CheckString;

@Controller
public class finishRegisterController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/Finishregister.do", method = RequestMethod.POST)
	public ModelAndView  finishRegisterPost(HttpServletRequest request, HttpSession session) throws FileUploadException {
		ModelAndView mav=new ModelAndView("finishregister");
		String student_num=request.getParameter("student_num");
		if(!CheckString.checkStudentnum(student_num)){
			System.out.println("xue hao ge shi bu dui");
			mav.addObject("error","xue hao ge shi bu dui");
			return mav;
	    }
		if (!userService.findUserByNum(student_num)) {
			System.out.println("bu cun zai gai xue sheng");
			mav.addObject("error","bu cun zai gai xue sheng");
			return mav;
		}
		String carcode=request.getParameter("carcode");
		if(!carcode.matches("[0-9]+"))
		{
			System.out.println("ka hao bu dui");
			mav.addObject("error","ka hao bu dui");
			return mav;
		}		
		userService.addUserCarcode(student_num, carcode);
		
				return mav;		
	}
	
	@RequestMapping(value = "/Finishregister.do", method = RequestMethod.GET)
	public ModelAndView finishRegisterGet(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("finishregister");	
		return mav;
	}
	
}
