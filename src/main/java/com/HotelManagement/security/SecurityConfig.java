///*
//package com.HotelManagement.security;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/rooms/addRoom").permitAll() // Permit access to this endpoint without authentication
//                .anyRequest().authenticated() // Require authentication for all other endpoints
//                .and()
//                .httpBasic(); // Use HTTP Basic Authentication
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // Configure your authentication provider, such as in-memory users, database users, or LDAP
//        auth
//                .inMemoryAuthentication()
//                .withUser("khagen").password("{noop}1234").roles("USER"); // Example in-memory user
//    }
//}
//*/
