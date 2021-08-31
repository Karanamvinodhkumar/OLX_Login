package com.user.service;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.user.entity.UserEntity;
import com.user.repo.UserRepo;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	UserRepo userRepo;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserEntity> userEntityList = userRepo.findByUserName(username);
        if(userEntityList==null || userEntityList.size()==0) { //User not found
            throw new UsernameNotFoundException(username);
        }
        UserEntity userEntity = userEntityList.get(0);
        List<GrantedAuthority> authorities = new ArrayList<>();//GrantedAuthority it is interface
        //authorities.add(new SimpleGrantedAuthority(userEntity.getRoles()));//SimpleGrantedAuthority this is the class of GrantedAuthority inteface and getting authorities like roles
        User user = new User(userEntity.getUserName(),userEntity.getPassword(),authorities);//org.springframework.security.core.userdetails.User;
        return user;
	}
	

}
