package com.gym_logic.gym.services;


import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.gym_logic.gym.entitys.myentity;
import com.gym_logic.gym.repositorys.Repository;

@Component
public class customedetailservice implements UserDetailsService {

	@Autowired
	private Repository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	myentity user=	repo.findByusername(username)
		.orElseThrow(()->new UsernameNotFoundException("user not found"));
	
		return new User(user.getUsername(), user.getPassword(), Collections.singleton(new SimpleGrantedAuthority("user role")));
	}

	

	
	
}