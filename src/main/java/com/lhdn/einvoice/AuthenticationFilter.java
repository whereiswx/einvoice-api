package com.lhdn.einvoice;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuthenticationFilter extends OncePerRequestFilter 
{
	private JwtService jwtService;
	private UserService userService;

	public AuthenticationFilter(JwtService jwtService, UserService userService) 
	{
		super();
		this.jwtService = jwtService;
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException 
	{
		String header = request.getHeader(HttpHeaders.AUTHORIZATION);
		String token = null, username = null;

		if (header != null && header.startsWith("Bearer ")) 
		{
			token = header.substring(7);

			try 
			{
				username = jwtService.getUsername(token);
			} 
			catch (Exception e) 
			{
				System.out.println("Invalid JWT");
			}
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) 
		{
			UserDetails userDetails = userService.loadUserByUsername(username);

			if (jwtService.validateToken(token, username)) 
			{
				UsernamePasswordAuthenticationToken token2 = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				SecurityContextHolder.getContext().setAuthentication(token2);
			}
		}
		filterChain.doFilter(request, response);
	}
}