package com.user.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.user.dto.User;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data
@Entity
@Table(name = "user_entity")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String userName;

	private String password;
	
	private String firstName;

	private String lastName;

	private String email;

	private String phone;

	public UserEntity(String userName, String password, String firstName, String lastName, String email, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}

	public UserEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	
	
	
	
	

}
