package cn.edu.xidian.iii.controller;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.eclipse.jdt.internal.compiler.ExtraFlags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xidian.iii.dao.TeamDao;
import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.domain.Elective;
import cn.edu.xidian.iii.domain.ElectiveId;
import cn.edu.xidian.iii.domain.Team;
import cn.edu.xidian.iii.domain.Teaming;
import cn.edu.xidian.iii.domain.User;
import cn.edu.xidian.iii.service.ElectiveService;
import cn.edu.xidian.iii.service.TeamService;
import cn.edu.xidian.iii.util.CheckString;
import cn.edu.xidian.iii.util.HandleExcel;


@Controller
public class TeamRegisterController {
	@Autowired
	private  TeamService teamService;
	@Autowired
	private ElectiveService electiveService;
	
	@RequestMapping(value="/TeamRegister.do",method=RequestMethod.POST)
	public ModelAndView teamResister(HttpServletRequest request, HttpSession session) throws Exception {
		ModelAndView mav=new ModelAndView("teamRegister");
		InputStream instream=HandleExcel.getExcelInputStream(request);
		List<String[]>  result=HandleExcel.readExcel(instream);
		int numcount=0;
		int successteam=0, successteaming=0,existElective=0;
		
		for(int i=0;i<result.size()-1;){	//队伍注册，team表
			if(result.get(i)[1].matches("[0-9]+")){
				
				Course  course=teamService.findCourseById(result.get(i)[1]);
				if(course!=null){
					int  cteamid=Integer.parseInt(result.get(i)[2]);
					while(i<result.size()-1&&result.get(i)[2].equals(result.get(++i)[2])){
						numcount=numcount+1;;
					}		
					Team team=new Team(course,cteamid,numcount+1);
					if(!teamService.teamExist(team)){
						teamService.saveTeam(team);
						successteam++;
					}
					else {
    			    	//team=teamService.findTeam(team);
    			    	mav.addObject("eorror","有队伍已经存在！");
    			   }
					numcount=0;
				}else {
					mav.addObject("error","有课程为空！");
					System.out.println("you ke cheng wei kong");
					return mav;
				}			
			}
			else {
				i++;
			}
		}		
		mav.addObject("successteam",successteam);
		
    	for(Iterator<String[]> it=result.iterator();it.hasNext();){
			String[] teamStrings=it.next();			
			if(teamStrings[1].matches("[0-9]+")){
				
			    if(!CheckString.checkStudentnum(teamStrings[3])){
				     mav.addObject("inputstyle_error",true);
				     return mav;
			    }	
			    if(!CheckString.isNumber(teamStrings[1])){
			    	mav.addObject("inputstyle_error",true);
			    	return mav;
			    }	
			    
			    User user=teamService.findUserByStuNum(teamStrings[3]);
			    if(user==null){
			    	mav.addObject("error","有用户不存在！");
			    }
			    else {			
			    	Course  course=teamService.findCourseById(teamStrings[1]);			    
			    	ElectiveId   electiveId=new ElectiveId(user.getUserId(), course.getCourseId());				
			    	Elective elective=new Elective(electiveId,user,course);
			    	if(!electiveService.isElectiveExist(elective)){
			        electiveService.saveElective(elective);	  //选课记录注册，elective表
			    	}
			    	else {
			    		existElective=existElective+1;
			    	}		
			    	int  cteamid=Integer.parseInt(teamStrings[2]);			    
			    	Team team=teamService.findTeam(new Team(course, cteamid));			    
			    	Teaming teaming=new Teaming(user,team);
			    	// System.out.println("usr"+user.getStudentNum());			    
			    	if(!teamService.teamingExist(teaming)){
			    		teamService.saveTeaming(teaming);	  //队伍注册，对应teaming表
			    		successteaming++;
			    	}
			    	else {
			    		mav.addObject("error","组队已存在！");
			    	}
			    }
			}
			
		}
    	mav.addObject("successteaming",successteaming);
    	mav.addObject("failteaming",result.size()-successteaming-1);
    	mav.addObject("successelective",result.size()-1-existElective);
    	mav.addObject("failelective",existElective);
		return mav;
	
	}
	
	@RequestMapping(value="/TeamRegister.do",method=RequestMethod.GET)
	public ModelAndView teamResisterGET(HttpServletRequest request, HttpSession session) {
		ModelAndView mav=new ModelAndView("teamRegister");
		return mav;
	}  
	
	
}
