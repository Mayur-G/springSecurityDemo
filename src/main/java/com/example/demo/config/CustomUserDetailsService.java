package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserDto;
import com.example.demo.repository.UserDtoRepository;

//https://bcrypt-generator.com/

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	UserDtoRepository userDtoRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		UserDto user = userDtoRepository.findByUserName(userName);
		System.out.println("user : "+user);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found");
		}
		return new CustomUserDetails(user);
	}

}
