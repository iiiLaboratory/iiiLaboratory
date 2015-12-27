package cn.edu.xidian.iii.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xidian.iii.dao.CourseDao;
import cn.edu.xidian.iii.dao.ElectiveDao;
import cn.edu.xidian.iii.dao.UserDao;
import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.domain.Elective;
import cn.edu.xidian.iii.domain.User;
import cn.edu.xidian.iii.service.ElectiveService;

public class ElectiveServiceImpl implements ElectiveService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private CourseDao courseDao;
	@Autowired
	private ElectiveDao electiveDao;
		
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
		course.setCourseId(Integer.parseInt(courseid));
		List<Course> courses=courseDao.findByExample(course);
		if(courses.size()==0)
			return null;
		return courses.get(0);
	}

	public boolean saveElective(Elective elective) {
		// TODO Auto-generated method stub
		electiveDao.save(elective);
		return false;
	}

	public boolean isElectiveExist(Elective elective) {
		// TODO Auto-generated method stub
		String userid=elective.getId().getUserId().toString();
		String courseid=elective.getId().getCourseId().toString();
		String sql="select * from elective where user_id="+"'"+userid+"'"+" and "+"course_id="+"'"+courseid+"'";
		List<Map<String, Object>> electives = electiveDao.query(sql);
		if(electives.size()>0){
			//System.out.println("service"+teamings.get(0).get(teaming));
			return true;	
		}
			
		return false;
		
	}


}
