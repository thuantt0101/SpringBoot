package com.laptrinhjavaweb.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


//Để kích hoạt Spring Security, trước tiên ta cần phải viết một lớp kế thừa 
//abstract class WebSecurityConfigurerAdapter:
/*
 * @Configuration: xác định lớp SpringSecurityConfigurationBasicAuth của ta là một lớp dùng dể cấu hình
 * @EnableWebSecurity sẽ kích hoạt việc tích hợp Spring Security với Spring Boot.
 * configure(HttpSecurity http) : câu hình chi tiết về bảo mật
 * antMatchers(): khai báo đường dẫn của request
 * permitAll() : cho phép tất cả các user đều được truy cập
 * 
 */
@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter{

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http
	        .csrf().disable()   
	        .authorizeRequests()
	        .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            //.formLogin().and()
	            .httpBasic();
	    }
	
}
