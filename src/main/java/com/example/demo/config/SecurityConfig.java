package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	UserDetailsService userDetailsService;
	
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return new BCryptPasswordEncoder();
//	}
//	
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails normalUser = User.withUsername("mayur")
//				.password(passwordEncoder().encode("password"))
//				.roles("NORMAL")
//				.build();
//		
//		UserDetails adminUser = User.withUsername("admin")
//				.password(passwordEncoder().encode("password"))
//				.roles("ADMIN")
//				.build();
//		
//		return new InMemoryUserDetailsManager(normalUser,adminUser);
//	}
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception 
	{
		
		httpSecurity.csrf().disable()
		.authorizeHttpRequests()
//		.requestMatchers("/public")
//		.permitAll()
		.anyRequest()
		.authenticated().and()
		.formLogin();
		
		return httpSecurity.build();
	}
	
	
}
