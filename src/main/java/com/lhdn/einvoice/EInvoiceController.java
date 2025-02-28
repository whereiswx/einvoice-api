package com.lhdn.einvoice;

import java.util.Date;
import java.util.UUID;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EInvoiceController 
{
	private AuthenticationManager authenticationManager;
	private JwtService jwtService;
	private PasswordEncoder passwordEncoder;

	public EInvoiceController(AuthenticationManager authenticationManager, JwtService jwtService,
			PasswordEncoder passwordEncoder) 
	{
		super();
		this.authenticationManager = authenticationManager;
		this.jwtService = jwtService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/welcome")
	public String welcome() 
	{
		return "Welcome to EInvoice API with JWT";
	}
	
	@PostMapping("/einvoice")
	public EInvoice submitEInvoice(@RequestBody EInvoice invoice)
	{
		invoice.setUin(UUID.randomUUID().toString());
		invoice.setValidationDate(new Date().toString());
		invoice.setQrLink("http://www.google.com");
		return invoice;
	}

	@PostMapping("/login")
	public String login(@RequestBody Users users) 
	{
		try 
		{
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
		}
		catch (Exception e) 
		{
			return "Bad Credentials: " + e.getMessage();
		}
		
		String token = jwtService.generateToken(users.getUsername());
		return "Bearer " + token;
	}
}