package com.Filrouge.webapp.SecurityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.Filrouge.webapp.model.AppUser;
import com.Filrouge.webapp.repository.AppUserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{
	@Autowired
	private AppUserRepository gestionUserService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser appUser = gestionUserService.findUserByUsername(username);
		
		System.out.println("=====> "  + appUser);
		  
		if(appUser==null)throw new UsernameNotFoundException(String.format("User %s not found", username));
		
		String[] roles = appUser.getListRoles().stream().map(u->u.getRole()).toArray(String[]::new);
		
		UserDetails userDetails =
				User
				.withUsername(appUser.getUsername())
				.password(appUser.getPassword())
				.roles(roles).build();		
		
		return userDetails;
	}

}
