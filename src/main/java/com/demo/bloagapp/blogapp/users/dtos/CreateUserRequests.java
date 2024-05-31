package com.demo.bloagapp.blogapp.users.dtos;

import org.springframework.lang.NonNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class CreateUserRequests {

	@NonNull
	private String username;
	@NonNull
	private String password;
	@NonNull
	private String email;

	

}
