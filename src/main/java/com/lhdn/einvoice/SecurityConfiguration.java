package com.lhdn.einvoice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfiguration 
{
	private AuthenticationFilter authenticationFilter;

	public SecurityConfiguration(AuthenticationFilter authenticationFilter) 
	{
		super();
		this.authenticationFilter = authenticationFilter;
	}

	@Bean
	protected PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}

	@Bean
	protected AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception 
	{
		return authenticationConfiguration.getAuthenticationManager();
	}

	@Bean
	protected SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception 
	{
		return http.csrf(c -> c.disable()).authorizeHttpRequests(auth -> auth.requestMatchers("/login", "/createPass/**").permitAll().anyRequest().authenticated()).sessionManagement(s -> s.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class).build();
	}
}