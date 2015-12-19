package cn.edu.xidian.iii.service;

import cn.edu.xidian.iii.domain.User;

public interface UserService {

	public boolean register(User user);
	
	public User findById(int id);
	
	public User findByStudentNum(String studentNum);
	
	public boolean loginCheck(String studentNum,String password) throws Exception ;
		
}
