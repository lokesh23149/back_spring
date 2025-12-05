package com.gym_logic.gym.connection;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym_logic.gym.entitys.myentity;
import com.gym_logic.gym.jwtsecurity.jwts;

@RestController
@RequestMapping("/auth")
public class jwt_connector {

	@Autowired
	private AuthenticationManager authmanager;

	@Autowired
	private jwts j;

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody myentity user) {

		try {
			Authentication auth = authmanager
					.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

			UserDetails userdetail = (UserDetails) auth.getPrincipal();

			String token = j.gendratar(userdetail);

			return ResponseEntity.ok(Map.of("token", token));
		} catch (Exception e) {

			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error","error founded"));
		}
		

	}

}
