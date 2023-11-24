package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserDto;

@Repository
public interface UserDtoRepository extends JpaRepository<UserDto, Long>{

	UserDto findByUserName(String userName);
}
