package com.user.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class Login {
	
	private String userName;
	
	private String password;

}
