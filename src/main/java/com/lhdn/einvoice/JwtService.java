package com.lhdn.einvoice;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtService 
{
	@Value("${jwtSecret}")
	private String jwtSecret;
	private int token_validity = 1;

	// Generate token
	public String generateToken(String username) 
	{
		Map<String, Object> claims = new HashMap<>();

		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());

		cal.add(Calendar.DATE, token_validity);

		return Jwts.builder().claims(claims).subject(username).issuedAt(new Date()).expiration(cal.getTime()).signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes())).compact();
	}

	// Validate token
	public boolean validateToken(String token, String username) 
	{
		String newuser = getUsername(token);
		return (newuser.equals(username) && !tokenExpired(token));
	}

	// Check token if expired
	public boolean tokenExpired(String token) 
	{
		return getExpiration(token).before(new Date());
	}

	// Get username from token
	public String getUsername(String token) 
	{
		Claims claims = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(jwtSecret.getBytes())).build().parseSignedClaims(token).getPayload();
		return claims.getSubject();
	}

	// Get expiration date from token
	public Date getExpiration(String token) 
	{
		Claims claims = Jwts.parser().verifyWith(Keys.hmacShaKeyFor(jwtSecret.getBytes())).build().parseSignedClaims(token).getPayload();
		return claims.getExpiration();
	}
}