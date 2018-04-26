package com.gps.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gps.entity.User;

public interface UserService {
	User getUserInfoByPassWord(String userName,String passWord);
	List<User> getUserList();
	void deleteUser(String userId);
	void updateUserById(String userId,String newPassWord);
}
