package com.in28Minutes.springboot.myfirstWebApp.security;

import java.security.PublicKey;
import java.util.Collection;

import org.apache.catalina.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {
	
	private static final Collection<UserDetails> UserDetails = null;

	//InMemoryUserDetailsManager
    //InMemoryUserDetailsManager(UserDetails...users)

	@Bean
	  public UserDetailsService userDetailsService() {
	    return new InMemoryUserDetailsManager(
	        org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
	            .username("user")
	            .password("password")
	            .roles("USER")
	            .build());
}
	
}
