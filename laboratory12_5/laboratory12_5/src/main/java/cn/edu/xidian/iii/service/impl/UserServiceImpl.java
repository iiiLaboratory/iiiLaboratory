package cn.edu.xidian.iii.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.edu.xidian.iii.dao.UserDao;
import cn.edu.xidian.iii.domain.User;
import cn.edu.xidian.iii.service.UserService;
import cn.edu.xidian.iii.util.Encryption;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	//private CommonDao<User> userDao;

	public boolean register(User user) {

		user.setRegisterTime(new Date());

		userDao.save(user);

		return true;
	}

	public User findById(int id) {

		return userDao.findById(User.class, id);

	}

	public User findByStudentNum(String studentNum) {

		User example = new User();
		example.setStudentNum(studentNum);

		List<User> list = userDao.findByExample(example);
//		System.out.println("####### " + list.size() + " ######");
		if (list.size() == 0)
			return null;
		else {
			return list.get(0);
		}
	}
	
	public boolean loginCheck(String studentNum,String password) throws Exception{//++++

		User user = new User();
		user.setStudentNum(studentNum);
		String password2=Encryption.encryptSHA(password);
		user.setPassword(password2);
		//System.out.println(password2);
		List<User> list = userDao.findByExample(user);
		return !list.isEmpty();
	}

}
