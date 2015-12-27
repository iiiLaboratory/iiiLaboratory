package cn.edu.xidian.iii.controller;
import java.util.Date;

import javax.swing.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.service.CourseService;
import cn.edu.xidian.iii.util.*;


@Controller
public class UserCourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/user-course.do", method = RequestMethod.POST)
	public ModelAndView courseResister(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("user_course");
		
		String courseName= request.getParameter("courseName");
		String teacher = request.getParameter("teacher");
		String tphone = request.getParameter("tphone");
		String classroom = request.getParameter("classroom");
		String identifier = request.getParameter("identifier");		//��֪���ж�����һ����
		
		
//		if((courseName==null)||(teacher==null)||(tphone==null)||(classroom=="null")
//				||(identifier==null)){
//			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE); 
//			return mav;
//			
//		}
		if(courseName.trim().equals("")||teacher.trim().equals("")||tphone.trim().equals("")||classroom.trim().equals("")
				||identifier.trim().equals("")){
			JOptionPane.showMessageDialog(null, "", "", JOptionPane.ERROR_MESSAGE); 
			return mav;
			
		}
		
		
		
		if(    !(NumMatches.lengthMatches(courseName, 50)
				&&NumMatches.lengthMatches(teacher, 20)
				&&NumMatches.lengthMatches(classroom, 20)
				&&NumMatches.lengthMatches(identifier, 10) ) )   {
			
			JOptionPane.showMessageDialog(null, "长度溢出", "错误", JOptionPane.ERROR_MESSAGE);
			return mav;
			
		}
		
		if(!NumMatches.phoneFormatMatches(tphone)){
			JOptionPane.showMessageDialog(null, "号码格式不对", "错误", JOptionPane.ERROR_MESSAGE);
			return mav;
		}
		
		
		if(courseService.findByCourseMember(courseName, teacher, tphone, classroom, identifier)){
			JOptionPane.showMessageDialog(null, "注册重复", "错误", JOptionPane.ERROR_MESSAGE);
			return mav;
		}
		
		
		if(!IsChinese.isChineseString(teacher)) {
			JOptionPane.showMessageDialog(null, "老师姓名必须中文", "错误", JOptionPane.ERROR_MESSAGE);
			return mav;
		}
		
		
		
		
		
		Course course = new Course(courseName,teacher,tphone,classroom,identifier);
		courseService.selectCourse(course);
		
		return mav;
		 /****跳转***/
		
		
		
		
	}
	
	@RequestMapping(value = "/user-course.do", method = RequestMethod.GET)
	public ModelAndView courseResisterGET(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("user_course");
		
		
		return mav;
	}
	
}
