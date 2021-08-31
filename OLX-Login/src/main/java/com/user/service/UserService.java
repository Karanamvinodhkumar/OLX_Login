package com.user.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.user.dto.Login;
import com.user.dto.User;
import com.user.dto.UserInfo;
import com.user.entity.UserEntity;
import com.user.exception.UsernameNotFoundException;


public interface UserService {
	
	
	
	public Boolean userLogout(String authToken);
	
	public User createUser(User user);
	
	public List<User> getUserList(String authToken);

	
	ResponseEntity<?> findByUserName(String username);
	
	

	

}
