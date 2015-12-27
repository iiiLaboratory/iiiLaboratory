package cn.edu.xidian.iii.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.domain.Elective;
import cn.edu.xidian.iii.domain.ElectiveId;
import cn.edu.xidian.iii.domain.User;
import cn.edu.xidian.iii.service.ElectiveService;
import cn.edu.xidian.iii.util.CheckString;



@Controller
public class SelectCourseController {
	@Autowired
	private ElectiveService electiveService;
	
	private User user;
	
	@RequestMapping(value = "/select-course.do", method = RequestMethod.POST)
	public ModelAndView userResister(HttpServletRequest request, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView("select_course");
		

		String studentNum = request.getParameter("student_num");
		if(CheckString.checkStudentnum(studentNum)){
			user = electiveService.findUserByStuNum(studentNum);
			if(user == null){
				mav.addObject("error","该用户不存在！");
				return mav;
			}	
			
		}
		else {
			mav.addObject("error","学号格式不正确！");
			return mav;
		}
		
		String courseId = request.getParameter("identifier");
		Course course = electiveService.findCourseById(courseId);
		if(course == null){
			mav.addObject("error","该课程不存在！");
			return  mav;
		}
		
		ElectiveId   electiveId = new ElectiveId(user.getUserId(), course.getCourseId());
				
		Elective elective = new Elective(electiveId,user,course);
		if(!electiveService.isElectiveExist(elective)){
			 electiveService.saveElective(elective);	
		}
		else {
			mav.addObject("error","你已经选中该课程了！");
			return mav;
		}
		
		mav.addObject("success","选课成功！");
		
		return mav;
	}
	
	@RequestMapping(value = "/select-course.do", method = RequestMethod.GET)
	public ModelAndView userResisterGET(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("select_course");
		
		
		return mav;
	}
	

}
