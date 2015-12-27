package cn.edu.xidian.iii.dao;

import cn.edu.xidian.iii.domain.User;

public interface UserDao extends CommonDao<User> {

	 public void addUserCarcode(String studentNum, String carcode);

}
