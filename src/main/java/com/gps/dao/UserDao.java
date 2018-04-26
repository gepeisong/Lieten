package com.gps.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.gps.entity.User;
@Repository
public interface UserDao {
	User getUserInfoByPassWord(Map userInfo);
	List<User> getUserList();
	void deleteUserById(String userId);
	void updateUserPassWord(String userId,String passWord);
}
