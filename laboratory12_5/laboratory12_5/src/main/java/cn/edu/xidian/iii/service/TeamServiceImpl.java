package cn.edu.xidian.iii.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xidian.iii.dao.CourseDao;
import cn.edu.xidian.iii.dao.TeamDao;
import cn.edu.xidian.iii.dao.TeamingDao;
import cn.edu.xidian.iii.dao.UserDao;
import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.domain.Team;
import cn.edu.xidian.iii.domain.Teaming;
import cn.edu.xidian.iii.domain.User;
import cn.edu.xidian.iii.service.TeamService;

public class TeamServiceImpl implements TeamService{
    @Autowired
	private UserDao  userDao;
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private TeamDao  teamDao;
    @Autowired
    private TeamingDao teamingDao;
	
	public User findUserByStuNum(String stunum) {
		// TODO Auto-generated method stub
		User user=new User();
		user.setStudentNum(stunum);	
	    List<User> userList=userDao.findByExample(user);
	    if(userList.size()==0)
	    	return null;
	    return userList.get(0);
		 
		 
	}

	public Course findCourseById(String courseid) {
		// TODO Auto-generated method stub
		Course course=new Course();
		course.setIdentifier(courseid);
		List<Course> courses=courseDao.findByExample(course);
		if(courses.size()==0)
			return null;
		return courses.get(0);
	}

	public boolean saveTeam(Team team) {
		// TODO Auto-generated method stub
		teamDao.save(team);
		return true;
	}

	public int findTeamid(Team team) {
		// TODO Auto-generated method stub
		List<Team> teams=teamDao.findByExample(team);
		return teams.get(0).getTeamId();
	}

	public boolean saveTeaming(Teaming teaming) {
		// TODO Auto-generated method stub
		teaming.setAddTime(new Date());
		teaming.setStatus("student");
		teamingDao.save(teaming);
		return true;
	}

	public boolean teamExist(Team team) {
		// TODO Auto-generated method stub
		List<Team> teams=teamDao.findByExample(team);
		if(teams.size()>0)
			return true;
		return false;
	}

	public Team findTeam(Team team) {
		// TODO Auto-generated method stub
		List<Team> teams=teamDao.findByExample(team);
		
		return teams.get(0);
	}

	public boolean teamingExist(Teaming teaming) {
		// TODO Auto-generated method stub
		String userid=teaming.getId().getUserId().toString();
		String teamid=teaming.getId().getTeamId().toString();
		String sql="select * from teaming where user_id="+"'"+userid+"'"+" and "+"team_id="+"'"+teamid+"'";
		List<Map<String, Object>> teamings = teamingDao.query(sql);
		if(teamings.size()>0){
			//System.out.println("service"+teamings.get(0).get(teaming));
			return true;	
		}
			
		return false;
	}

	public int findMaxTeamid(Course course) {
		// TODO Auto-generated method stub
		String sql="select max(team_id) from team where course_id="+"'"+course.getCourseId()+"'";
		List<Map<String,Object>> results=teamingDao.query(sql);
		Map<String, Object> map=results.get(0);
		Iterator<String> iterator =map.keySet().iterator();
		
		Object key=iterator.next();
		return Integer.parseInt((map.get(key).toString()));
	}
	
	

}
