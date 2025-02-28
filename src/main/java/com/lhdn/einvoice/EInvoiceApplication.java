package com.lhdn.einvoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EInvoiceApplication extends SpringBootServletInitializer 
{
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) 
	{
		return application.sources(EInvoiceApplication.class);
	}

	public static void main(String[] args) 
	{
		SpringApplication.run(EInvoiceApplication.class, args);
	}
}