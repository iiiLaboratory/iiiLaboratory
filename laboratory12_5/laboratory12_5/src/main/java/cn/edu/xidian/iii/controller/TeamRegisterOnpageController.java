package cn.edu.xidian.iii.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.domain.Team;
import cn.edu.xidian.iii.domain.Teaming;
import cn.edu.xidian.iii.domain.User;
import cn.edu.xidian.iii.service.DeviceTypeService;
import cn.edu.xidian.iii.service.TeamService;
import cn.edu.xidian.iii.util.CheckString;


@Controller
public class TeamRegisterOnpageController {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(value = "/Teamregisteronpage.do", method = RequestMethod.POST)
	public ModelAndView teamResisterPost(HttpServletRequest request, HttpSession session) {
		
		ModelAndView mav = new ModelAndView("teamregisteronpage");
		
		String courseIdString=request.getParameter("courseID");
		//System.out.println("courseId="+courseIdString);
		String[] userIdString=request.getParameterValues("userID");
		String cteamIdString=request.getParameter("cteamID");
		for(int i=0;i<userIdString.length;i++){
			if(!CheckString.checkStudentnum(userIdString[i])){
				 mav.addObject("error","第"+(i+1)+"个学号："+userIdString[i]+"  格式有误！");
				 return mav;
				 
			}		
		}
		if(cteamIdString==null||cteamIdString.equals("")){
			mav.addObject("error","队伍号不能为空！");
			return mav;
		}
		Course course=teamService.findCourseById(courseIdString);
		if(course!=null){
			
			//int  cteamid=Integer.parseInt(cteamIdString);
			
			int cteamid=teamService.findMaxTeamid(course);
			//System.out.println("cteamId"+cteamid);
			
			Team team=new Team(course,cteamid+1);
			if(!teamService.teamExist(team)){
				teamService.saveTeam(team);
				//Team team=teamService.findTeam(new Team(course, cteamid));
				for(int i=0;i<userIdString.length;i++){
				    User user=teamService.findUserByStuNum(userIdString[i]);
				    if(user==null){
				    	mav.addObject("error",userIdString[i]+"没有注册！");
				    	return mav;
				    }
					Teaming teaming=new Teaming(user,team);		    
			    	if(!teamService.teamingExist(teaming)){
			    		teamService.saveTeaming(teaming);	  //队伍注册，对应teaming表
			    	}
			    	else {
			    		mav.addObject("error","组队已存在！");
			    		return mav;
			    	}
				}
		    	
			}
			else {
		    	//team=teamService.findTeam(team);
		    	mav.addObject("error","队伍已经存在！");
		    	return mav;
		   }
		}else {
			mav.addObject("error","该课程为空！");
			return mav;
		}			
	
		return mav;
	}
	
	@RequestMapping(value = "/Teamregisteronpage.do", method = RequestMethod.GET)
	public ModelAndView teamResisterGET(HttpServletRequest request, HttpSession session) {
		ModelAndView mav = new ModelAndView("teamregisteronpage");
		return mav;
	}
	

}
