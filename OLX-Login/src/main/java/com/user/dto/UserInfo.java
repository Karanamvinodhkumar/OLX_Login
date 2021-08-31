package com.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	private String userName;
	
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private String phone;
	

}
