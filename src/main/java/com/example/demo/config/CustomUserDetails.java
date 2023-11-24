package com.example.demo.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserDto;

public class CustomUserDetails implements UserDetails{

	@Autowired
	UserDto userDto;
	
	public CustomUserDetails(UserDto userDto) {
		super();
		this.userDto = userDto;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//return Collections.singleton(new SimpleGrantedAuthority(userDto.getRole()));
		
		  List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		    authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		    authorities.add(new SimpleGrantedAuthority("ROLE_NORMAL"));

		    return authorities;
	}

	@Override
	public String getPassword() {
		return userDto.getPassword();
	}

	@Override
	public String getUsername() {
		return userDto.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
