package cn.edu.xidian.iii.dao.impl;


import java.util.List;

import cn.edu.xidian.iii.dao.UserDao;
import cn.edu.xidian.iii.domain.User;

public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {

	public void addUserCarcode(String studentNum, String carcode) {
		// TODO Auto-generated method stub
		String sql="update user set cardcode="+"'"+carcode+"'"+"where student_num="+"'"+studentNum+"'";
		execute(sql);
	}
}
