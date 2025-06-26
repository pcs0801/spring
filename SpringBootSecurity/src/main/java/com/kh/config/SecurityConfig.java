package com.kh.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.kh.common.security.CustomAccessDeniedHandler;
import com.kh.common.security.CustomLoginSuccessHandler;
import com.kh.common.security.CustomNoOpPasswordEncoder;
import com.kh.common.security.CustomUserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private DataSource dataSource;

	@Bean
	SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
		log.info("Security 환경설정 시작");
		http.csrf().disable();

		http.authorizeRequests().requestMatchers("/board/list").permitAll();
		http.authorizeRequests().requestMatchers("/board/register").hasRole("MEMBER");
		http.authorizeRequests().requestMatchers("/notice/list").permitAll();
		http.authorizeRequests().requestMatchers("/notice/register").hasRole("ADMIN");

		// http.exceptionHandling().accessDeniedPage("/accessError");

		http.exceptionHandling().accessDeniedHandler(createAccessDeniedHandler());

		// http.formLogin().loginPage("/login");

		http.formLogin().loginPage("/login").successHandler(createAuthenticationSuccessHandler());

		http.logout().logoutUrl("/logout").invalidateHttpSession(true);

		return http.build();
	}

//	@Autowired
//	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// 지정된 아이디와 패스워드로 로그인이 가능하도록 설정한다. auth.inMemoryAuthentication()
//		auth.inMemoryAuthentication().withUser("member").password("{noop}123456").roles("MEMBER");
//		auth.inMemoryAuthentication().withUser("admin").password("{noop}123456").roles("ADMIN", "MEMBER");
//	}
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(createUserDetailsService()).passwordEncoder(createPasswordEncoder());
	}

	@Bean
	public AccessDeniedHandler createAccessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}

	@Bean
	public AuthenticationSuccessHandler createAuthenticationSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	public UserDetailsService createUserDetailsService() {
	return new CustomUserDetailsService();
	}
	@Bean
	public PasswordEncoder createPasswordEncoder() {
	return new CustomNoOpPasswordEncoder();
	}
}
