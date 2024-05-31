package com.demo.bloagapp.blogapp.users;

import org.aspectj.weaver.patterns.ConcreteCflowPointcut;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.demo.bloagapp.blogapp.users.dtos.CreateUserRequests;

@SpringBootTest
@ActiveProfiles("test")
public class UsersServiceTest {
	
	@Autowired
	UserService userService;
	
	
	@Test
	public void create_user_test() {
		
		var user = userService.createUser(new CreateUserRequests("rohan", "trest", "rb@gmail.com"));
		
		Assertions.assertNotNull(user);
		
		Assertions.assertEquals("rohan", user.getUsername());
		System.out.println(user.getEmail());
		
	}

}
