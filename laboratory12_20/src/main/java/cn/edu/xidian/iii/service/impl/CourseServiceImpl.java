  package cn.edu.xidian.iii.service.impl;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xidian.iii.dao.CourseDao;
import cn.edu.xidian.iii.domain.Course;
import cn.edu.xidian.iii.service.CourseService;

public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao 	courseDao;

	public boolean selectCourse(Course course) {
		
		course.setBeginTime(new Date());/*-------------------*/
		courseDao.save(course);
		return true;
	}

	public Course findById(int id) {

		return courseDao.findById(Course.class, id);

	}

	public Course findByCourseName(String courseName) {//这个不大明白

		Course example = new Course();
		//example.setStudentNum(studentNum);
		example.setCourseName(courseName);

		List<Course> list = courseDao.findByExample(example);
//		System.out.println("####### " + list.size() + " ######");
		if (list.size() == 0)
			return null;
		else {
			return list.get(0);
		}
	}
	
	
	public boolean findByCourseMember(String courseName,String teacher,String tphone,
			String classroom,String identifier){
		
		Course example = new Course();
		example.setCourseName(courseName);
		example.setTeacher(teacher);
		example.setTphone(tphone);
		example.setClassroom(classroom);
		example.setIdentifier(identifier);

		
		
		//example.setStudentNum(studentNum);
		List<Course> list = courseDao.findByExample(example);
//		System.out.println("####### " + list.size() + " ######");
		if (list.size() == 0)
			return false;
		else {
			return true; 
		}
		
	}

}
