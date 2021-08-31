package com.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "olxlogin")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString


public class UserMongoEntity {
	@Id
    private int id;
	
	private String userName;

	private String password;
	
	private String firstName;

	private String lastName;

	private String email;

	private String phone;
	
	public UserMongoEntity(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

}
