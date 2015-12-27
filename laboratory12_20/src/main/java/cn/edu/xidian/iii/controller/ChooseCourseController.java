package cn.edu.xidian.iii.controller;


import java.io.InputStream;
import java.util.List;

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
import cn.edu.xidian.iii.util.HandleExcel;



@Controller
public class ChooseCourseController {
	@Autowired
	private ElectiveService electiveService;
	
	
	@RequestMapping(value = "/choose-course.do", method = RequestMethod.POST)
	public ModelAndView userResister(HttpServletRequest request, HttpSession session) throws Exception {
		
		ModelAndView mav = new ModelAndView("choose_course");
		int existElective=0;
		InputStream instream=HandleExcel.getExcelInputStream(request);
		List<String[]>  result=HandleExcel.readExcel(instream);
		
		for(String[] res:result){
			if(res[0].matches("[0-9]+")){
				Course course=electiveService.findCourseById(res[0]);
				if(course==null){
					mav.addObject("error","有课程不存在！");
					return  mav;
				}
					
				User user=electiveService.findUserByStuNum(res[1]);
				if(user==null){
					mav.addObject("error","有用户不存在！");
					return mav;
				}			
				int socre=Integer.parseInt(res[2]);
				int count=Integer.parseInt(res[3]);
				int totaltime=Integer.parseInt(res[4]);
				ElectiveId   electiveId=new ElectiveId(user.getUserId(), course.getCourseId());
				
				Elective elective=new Elective(electiveId,user,course);
				if(!electiveService.isElectiveExist(elective)){
			        electiveService.saveElective(elective);	
				}
				else {
					existElective++;
				}
			}
		}
		mav.addObject("success",(int)(result.size()-existElective)-1);
		mav.addObject("fail",existElective);
		return mav;
	}
	
	@RequestMapping(value = "/choose-course.do", method = RequestMethod.GET)
	public ModelAndView userResisterGET(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("choose_course");
		
		
		return mav;
	}
	

}
