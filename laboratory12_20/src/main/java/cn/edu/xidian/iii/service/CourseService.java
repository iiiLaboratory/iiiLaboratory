package cn.edu.xidian.iii.service;
import cn.edu.xidian.iii.domain.Course;
public interface CourseService {

	public boolean selectCourse(Course course);
	
	public Course findById(int id);
	
	public Course findByCourseName(String courseName);
	
	public boolean findByCourseMember(String courseName,String teacher,String tphone,
			String classroom,String identifier);
		
}
