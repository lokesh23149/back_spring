package com.gym_logic.gym.securitymanage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.gym_logic.gym.jwtsecurity.jwtFilter;
import com.gym_logic.gym.services.customedetailservice;



@Configuration
@EnableWebSecurity
public class securityconfig {
	
	@Autowired
	private jwtFilter jwtfilter;
	@Bean
	public DefaultSecurityFilterChain securitylock(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers(HttpMethod.POST, "/api/users").permitAll()
				.requestMatchers("/api/users**").authenticated().requestMatchers("/dashboad").permitAll()
				.requestMatchers("/").permitAll().anyRequest().permitAll())
                //		.formLogin(log -> log.permitAll().defaultSuccessUrl("/dashboad"))
				.csrf(c -> c.disable())
						.sessionManagement(se->se.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
								).addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);

		return http.build();
	}

	@Bean
	public UserDetailsService userdetil() {
		return new customedetailservice();
	}

	public DaoAuthenticationProvider authendication() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setUserDetailsService(userdetil());
		dao.setPasswordEncoder(passEncoder());
		;

		return dao;
	}

	@Bean
	public PasswordEncoder passEncoder() {
		return new BCryptPasswordEncoder();

	}

	@Bean
	public AuthenticationManager authencationmanager() {
		return new ProviderManager(List.of(authendication()));
	}
}