package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.antMatchers("/fonts/**").permitAll()
			.antMatchers("/img/**").permitAll()
			.antMatchers("/js/**").permitAll()
			.antMatchers("/DataTables/**").permitAll()
			.antMatchers("/**").hasRole("DOSEN")
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.defaultSuccessUrl("/dashboard")
			.and()
			.logout().permitAll();
	}
	
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("SELECT username,password,enabled FROM users WHERE username=?")
				.authoritiesByUsernameQuery("SELECT username,role FROM users WHERE username=?");
	}
}