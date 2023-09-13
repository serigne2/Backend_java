package com.Filrouge.webapp.SecurityConfig;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.nimbusds.jose.jwk.source.ImmutableSecret;

import com.Filrouge.webapp.model.AppUser;
import com.Filrouge.webapp.repository.AppUserRepository;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private AppUserRepository gestionUserService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	
	
	/*
	 * @Bean public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
	 * 
	 * PasswordEncoder passwordEncoder =passwordEncoder();
	 * 
	 * return new InMemoryUserDetailsManager(
	 * 
	 * User.withUsername("francis")
	 * .password(passwordEncoder.encode("Test1234")).authorities("USER","ADMIN").
	 * build(),
	 * 
	 * User.withUsername("user")
	 * .password(passwordEncoder.encode("Test1234")).authorities("USER").build()
	 * 
	 * );
	 * 
	 * }
	 */
	 
	 
	
	/* 
	 * @Bean public UserDetailsService userDetailsService() {
	 * 
	 * return new UserDetailsService() {
	 * 
	 * @Override public UserDetails loadUserByUsername(String username) throws
	 * UsernameNotFoundException {
	 * 
	 * AppUser user = gestionUserDao.findUserByUsername(username);
	 * 
	 * List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	 * 
	 * user.getListRoles().forEach(r->{ authorities.add(new
	 * SimpleGrantedAuthority(r.getRole())); });
	 * 
	 * return new User(user.getUsername(),user.getPassword(),authorities);
	 * 
	 * } }; }
	 */
	 
	 
	

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		return http.
				sessionManagement(sa->sa.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.csrf(csrf->csrf.disable())
				.authorizeHttpRequests(ar->ar.requestMatchers("/auth/login/**").permitAll())
				.authorizeHttpRequests(ar->ar.anyRequest().authenticated())
				//.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
				.oauth2ResourceServer(oa->oa.jwt(Customizer.withDefaults()))
				.userDetailsService(userDetailsService)
				.build();
	}
	@Bean
	JwtEncoder jwtEncoder() {
		String secretKey ="123s456dfghj456987ertyuiopm214qsdfghjklmnbv321654qwxertyuio9783k";
		return new NimbusJwtEncoder(new ImmutableSecret(secretKey.getBytes()));
	}
	@Bean
	JwtDecoder jwtDecoder() {
		String secretKey ="123s456dfghj456987ertyuiopm214qsdfghjklmnbv321654qwxertyuio9783k";
		SecretKeySpec secretKeySpec  = new SecretKeySpec(secretKey.getBytes(), "RSA");
		return NimbusJwtDecoder.withSecretKey(secretKeySpec).macAlgorithm(MacAlgorithm.HS512).build();
	}
	@Bean
	public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		
		return new ProviderManager(daoAuthenticationProvider);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
