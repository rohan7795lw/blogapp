package com.demo.bloagapp.blogapp.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("test")
public class UsersRepositoryTest {

	@Autowired
	private UsersRepository usersRepository;
	
	@Test
	void createAndTestUserRepository() {
		
		var user = UserEntity.builder()
				.username("rohantest")
				.email("rb@gmail.com")
				.build();
	
		System.out.println(user.getUsername());
		usersRepository.save(user);
	
		var users = usersRepository.findAll();
		Assertions.assertEquals(1,users.size());
		
	}
}
