package com.Filrouge.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Filrouge.webapp.model.AppRole;
import com.Filrouge.webapp.model.AppUser;

@Repository
public interface AppRoleRepository 
	extends JpaRepository<AppRole, Integer>	{
	
	public AppRole findRoleByRole(String role);
}
