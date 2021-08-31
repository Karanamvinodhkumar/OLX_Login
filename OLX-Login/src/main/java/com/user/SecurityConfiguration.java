package com.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetailsService;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	

	
	
	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception  { 
		
		
		//To override default authentication
		
		
		/*
		 * PasswordEncoder encoder =
		 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
		 * 
		 * 
		 * auth.inMemoryAuthentication()
		 * .withUser("tom").password(encoder.encode("tom123")).roles("USER") .and()
		 * .withUser("jerry").password(encoder.encode("jerry123")).roles("ADMIN");
		 */
		 
	
		
		auth.userDetailsService(userDetailsService);
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception
	{
		http.csrf().disable()
		.authorizeRequests()
				/*
				 * .antMatchers("/admin").hasRole("ADMIN")
				 * .antMatchers("/user").hasAnyRole("ADMIN","USER")
				 */
		.antMatchers("/all","/authenticate").permitAll()
		.and()
		.formLogin();
		
	}
	
	@Bean
	public AuthenticationManager getAuthenticationManager() throws Exception
	{
		return super.authenticationManager();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() throws Exception
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
	
	
	

}
