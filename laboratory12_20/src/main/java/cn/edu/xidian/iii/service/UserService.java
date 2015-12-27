package cn.edu.xidian.iii.service;

import cn.edu.xidian.iii.domain.User;

public interface UserService {

	public boolean register(User user);
	
	public User findById(int id);
	
	public User findByStudentNum(String studentNum);
	/**修改电话和邮箱*/
	public boolean updateUser(User user);
	
	public boolean loginCheck(String studentNum,String password) throws Exception ;
	
	public boolean addUserCarcode(String studentNum, String carcode);
	
	public boolean findUserByNum(String student_num) ;
	
}
