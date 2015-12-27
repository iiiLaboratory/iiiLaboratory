package cn.edu.xidian.iii.service;

import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.domain.Elective;
import cn.edu.xidian.iii.domain.User;

public interface ElectiveService {
	   public User findUserByStuNum(String stunum);
	   public  Course findCourseById(String courseid);
	   public boolean saveElective(Elective elective);
	   public boolean isElectiveExist(Elective elective);
}
