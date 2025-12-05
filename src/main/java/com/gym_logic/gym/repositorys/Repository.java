package com.gym_logic.gym.repositorys;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym_logic.gym.entitys.myentity;

public interface Repository extends JpaRepository<myentity, Long>{
	
	Optional<myentity> findByusername (String username);

}
