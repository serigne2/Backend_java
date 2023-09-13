package com.Filrouge.webapp.service;

import jakarta.transaction.Transactional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Filrouge.webapp.model.AppRole;
import com.Filrouge.webapp.model.AppUser;
import com.Filrouge.webapp.repository.AppRoleRepository;
import com.Filrouge.webapp.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@Transactional
@Service
public class GestionUserService {
	
	private AppUserRepository userRepository;
	private AppRoleRepository roleRepository;
	
	private PasswordEncoder passwordEncoder;
	
	
	
	public GestionUserService(AppUserRepository userRepository, AppRoleRepository roleRepository,
			PasswordEncoder passwordEncoder) {
	
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}
	public void insertUser(AppUser appUser) {
		//1-	Encoder le password de l'utilisateur
			//1-1	récupération du mot de passe dans l'objet
			String pwd = appUser.getPassword();
			//1-2	On encode le mot de passe
			String pwdCrypter = this.passwordEncoder.encode(pwd);			
			//1-3	On stocke le mot de passe encodé dans l'objet appUser
			appUser.setPassword(pwdCrypter);
			
			//1-4	On enregistre l'utilisateur dans la base 
		this.userRepository.save(appUser);
	}
	/**
	 * @param appRole
	 */
	public void insertRole(AppRole appRole) {
		this.roleRepository.save(appRole);
	}
	public void addRoleToUser(AppRole appRole,AppUser appUser) {
		AppRole role = this.
							roleRepository
							.getById(appRole.getIdRole());
		AppUser user = this.
							userRepository
							.getById(appUser.getIdUser())	;	
	
		user.getListRoles().add(role);
	}
	
	public AppUser findUserByUsername(String username) {
		return this.userRepository.findUserByUsername(username);
	}
	/*
	 * public AppRole findRoleByRole(String role) { return
	 * this.roleRepository.findRoleByRole(role); }
	 */
	
}
