package com.cognizant.security.config;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class SecurityConfiguration {


	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
		http.csrf(csrf -> csrf.disable());
		// http.sessionManagement(session ->
		// session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		http.httpBasic(Customizer.withDefaults());
		DefaultSecurityFilterChain filterChain = http.build();
		return filterChain;
	}


	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1=User.withUsername("admin")
				              .password("{noop}123")
				              .roles("admin")
				              .build();
		UserDetails user2 = User.withUsername("hrithik")
				                .password("{noop}1234")
				                .roles("user")
				                .build();
		
		return new InMemoryUserDetailsManager(user1,user2);
		
	}

}
