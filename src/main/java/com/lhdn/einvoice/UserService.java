package com.lhdn.einvoice;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService 
{
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		return new User("admin", "$2a$10$mKz3ziN2OvY/oT2nSMo30eNSEqhfZ6Et8kUU6QJhz24BQ6hWe4KdK", new ArrayList<>());
	}
}