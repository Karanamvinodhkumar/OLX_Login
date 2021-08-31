package com.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

@ApiModel(value="User Model holds the details of the user")

public class User {
	@ApiModelProperty(value = "id of the user")
	private int id;
	@ApiModelProperty(value = "username of the user")
	private String userName;
	@ApiModelProperty(value = "password of the user")
	private String password;
	@ApiModelProperty(value = "firstname of the user")
	private String firstName;
	@ApiModelProperty(value = "lastname of the user")
	private String lastName;
	@ApiModelProperty(value = "email of the user")
	private String email;
	@ApiModelProperty(value = "phonenumber of the user")
	private String phone;
	
	
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}



	public void setJwtToken(String generateToken) {
		// TODO Auto-generated method stub
		
	}



	public User(String userName, String firstName, String lastName, String email, String phone) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}



	

}
