package com.user.service;




import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.user.dto.Login;
import com.user.dto.User;
import com.user.dto.UserInfo;
import com.user.entity.UserEntity;
import com.user.exception.InvalidCredentialsException;
import com.user.exception.UsernameNotFoundException;
import com.user.exception.UsersNotFoundException;
import com.user.repo.UserRepo;
import com.user.utils.JwtUtils;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	JwtUtils jwtUtils;
	
	
	@Autowired
	UserDetailsServiceImpl userdetailsimpl;

	
	

	@Override
	public Boolean userLogout(String authToken) {
		if("VK0580".equalsIgnoreCase(authToken))
		{
			return true;
		}
		else
		{
			return false;
		
	}
	}

	@Override
	public User createUser(User user) {
		UserEntity userentity = new UserEntity(user.getUserName(),user.getPassword(),user.getFirstName(),user.getLastName()
				,user.getEmail(),user.getPhone());
		userentity = userRepo.save(userentity);
		User u = new User(userentity.getId(),userentity.getUserName(),userentity.getPassword(),userentity.getFirstName(),
				userentity.getLastName(),userentity.getEmail(),userentity.getPassword());
		return u;
	}

	@Override
	public List<User> getUserList(String authToken) {
		if("VK0580".equalsIgnoreCase(authToken))
		{
		List<UserEntity> entitylist = userRepo.findAll();
		List<User> userlist = new ArrayList<>();
		for(UserEntity userdata:entitylist)
		{
			User user= new User(userdata.getId(),userdata.getUserName(),userdata.getPassword(),userdata.getFirstName(),
					userdata.getLastName(),userdata.getEmail(),userdata.getPhone());
			userlist.add(user);
		}
		return userlist;
		}
		throw new UsersNotFoundException(""+authToken);
	}

	@Override
	public ResponseEntity<?> findByUserName(String username) {
	
		List<UserEntity> entitylist = userRepo.findByUserName(username);
		List<UserInfo> userlist = new ArrayList<>();
		for(UserEntity userdata:entitylist)
		{
			UserInfo user= new UserInfo(userdata.getUserName(),userdata.getFirstName(),
					userdata.getLastName(),userdata.getEmail(),userdata.getPhone());
			userlist.add(user);
		}
		
		return ResponseEntity.ok(userlist);
		
	}

	

	
	
	
	
	

}
