package com.user.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.user.dto.Login;
import com.user.dto.User;
import com.user.dto.UserInfo;
import com.user.entity.UserEntity;
import com.user.exception.InvalidCredentialsException;
import com.user.service.UserService;
import com.user.utils.JwtUtils;

import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


@RestController
@RequestMapping("/userdetails")
public class UserController {

	 @Autowired
	 UserService userService;
	 
	 @Autowired
	 JwtUtils jwtUtils;
	 
	 @Autowired
	 AuthenticationManager authManager;
	 
	 @Autowired
	 UserDetailsService userDetailsService;

	 @ApiOperation(value = "To authenticate user details", notes = "To check valid user or not")
     @PostMapping(value = "/authenticate",consumes = MediaType.APPLICATION_JSON_VALUE)
		  public ResponseEntity<String> generateToken(@RequestBody Login login) throws Exception{ 
		try 
		{
		  authManager.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(),login.getPassword()));
		  
		  } 
		  catch(BadCredentialsException e) 
		  { 
			  return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		  }
		 String jwtToken = jwtUtils.generateToken(login.getUserName());
         return new ResponseEntity<String>(jwtToken,HttpStatus.OK);
		  } 
		  
	 @ApiOperation(value = "To validate user details", notes = "To check valid user or not")  
     @GetMapping(value="/token/validate")
		  public ResponseEntity<Boolean> isTokenValid(@RequestHeader("Authorization") String JwtToken)
		  {
			  JwtToken = JwtToken.substring(7);
			  String username = jwtUtils.extractUsername(JwtToken);
			  UserDetails userdetails = userDetailsService.loadUserByUsername(username);
			  boolean isValid = jwtUtils.validateToken(JwtToken, userdetails);
			  if(isValid)
			  {
				  return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			  }
			  else
			  {
			  return new ResponseEntity<Boolean>(false,HttpStatus.BAD_REQUEST);
			  }
			  
			  
			  
					  
			  
		  }

		  
		  
		 

	@ApiOperation(value = "check User Logout", notes = "To check user is logged out")
	@DeleteMapping(value = "/user/logout", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> userLogout(@RequestHeader("auth-token") String authToken) {
	
		return new ResponseEntity(userService.userLogout(authToken), HttpStatus.OK);
	
	}

	@ApiOperation(value = "Add user details", notes = "To add details of the user")
	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> createUser(@RequestBody User user) {

		return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Getting user details", notes = "To get details of the all users")
	@GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<User>> getUserList(@RequestHeader("auth-token") String authToken) {
					  
		return new ResponseEntity<List<User>>(userService.getUserList(authToken), HttpStatus.OK);
		
	}
	
	@ApiOperation(value = "Getting user details", notes = "To get details of the user")
	@GetMapping(value = "/user/details", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getUserDetails(@RequestHeader("Authorization") String JwtToken) {
					  
		  JwtToken = JwtToken.substring(7);
		  String username = jwtUtils.extractUsername(JwtToken);
		  if(username.isEmpty())
		  {
			  throw new InvalidCredentialsException(""+JwtToken);
		  }
		  else
		  {
			  return userService.findByUserName(username);
		  }
		  
		
	}
	
	
	
	
	

}
