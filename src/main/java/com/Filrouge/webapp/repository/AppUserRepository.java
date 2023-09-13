package com.Filrouge.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Filrouge.webapp.model.AppUser;

@Repository
public interface AppUserRepository 
	extends JpaRepository<AppUser, Integer>{

	public AppUser findUserByUsername(String username);
}
