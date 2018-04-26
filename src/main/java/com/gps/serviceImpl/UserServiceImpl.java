package com.gps.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gps.dao.UserDao;
import com.gps.entity.User;
import com.gps.service.UserService;
import com.gps.util.GPSUtil;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	
	public User getUserInfoByPassWord(String userName, String passWord) {
		// TODO Auto-generated method stub
		Map userMap=new HashMap();
		userMap.put("userName", userName);
		userMap.put("passWord", GPSUtil.getMd5(passWord));
		
		return userDao.getUserInfoByPassWord(userMap);
	}

	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return userDao.getUserList();
	}

	public void deleteUser(String userId) {
		// TODO Auto-generated method stub
		userDao.deleteUserById(userId);
	}

	public void updateUserById(String userId, String newPassWord) {
		// TODO Auto-generated method stub
		userDao.updateUserPassWord(userId, GPSUtil.getMd5(newPassWord));
	}

}
