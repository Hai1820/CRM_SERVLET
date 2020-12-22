package com.myclass.service;

import org.mindrot.jbcrypt.BCrypt;

import com.myclass.dto.UserDto;
import com.myclass.entity.Role;
import com.myclass.entity.User;
import com.myclass.repository.RoleRepository;
import com.myclass.repository.UserRepository;

public class AuthService {
	private UserRepository userRepository = null;
	private RoleRepository roleRepository = null;
	
	public AuthService() {
		userRepository = new UserRepository();
		roleRepository = new RoleRepository();
	}
	
	public UserDto checkLogin(String email, String pass) {
		User user = userRepository.findByEmail(email);
		if(user == null) return null;
		
		boolean result = BCrypt.checkpw(pass, user.getPassword());
		if(!result) return null;
		
		Role role = roleRepository.getRoleById(user.getRoleId());
		
		UserDto dto = new UserDto();
		dto.setEmail(user.getEmail());
		dto.setFullName(user.getFullName());
		dto.setRoleId(role.getId());
		
		return dto;
	}
}
