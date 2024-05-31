package com.demo.bloagapp.blogapp.users;

import org.springframework.stereotype.Service;

import com.demo.bloagapp.blogapp.users.dtos.CreateUserRequests;

@Service
public class UserService {
	
	//create a CreateUserDto and use it in this class
	
	
	
	private final UsersRepository userRepository;

	public UserService(UsersRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserEntity createUser(CreateUserRequests u) {
        UserEntity  user = UserEntity.builder()
        		.username(u.getUsername())
        		.email(u.getEmail())
        		// .password(user.getPassword()) //TODO: encrype pasword
        		.build();
		return user;
        				
    }
	
	public UserEntity getUser(String username) {
		return userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
	}
	
	public UserEntity getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
	}
	
	public UserEntity loginUser(String username, String password) {
		
		var u = userRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
		
		return u;
	}
	
	public static class UserNotFoundException extends IllegalArgumentException {
		public UserNotFoundException(Long id) {
			super("username with "+id+" not found");
		}

		public UserNotFoundException(String username) {
			super("username with "+username+" not found");
		}
	}
}
