package com.ngoctm.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//add our users for in memory authentication
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication().withUser(user.username("ngocnano").password("123456").roles("manager","employee"))
		                             .withUser(user.username("jame").password("123456").roles("ad","employee"))
		                             .withUser(user.username("hulu").password("123456").roles("employee"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		     .antMatchers("/").hasRole("employee")
		     .antMatchers("/leaders/**").hasRole("manager")
		     .antMatchers("/systems/**").hasRole("ad")
		     .and()
		     .formLogin()
		     .loginPage("/showMyLoginPage")
		     .loginProcessingUrl("/authenticateTheUser")
		     .permitAll()
		     .and()
		     .logout().permitAll()
		     .and()
		     .exceptionHandling()
		     .accessDeniedPage("/access-denied");
	}
	
	
	

	
}
