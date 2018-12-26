package com.auma.deinwagen.security;

import org.springframework.context.annotation.Configuration;

/*@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {





 @Autowired
 private AuthenticationEntryPoint authEntryPoint;

 protected void configure(HttpSecurity http) throws Exception {

     http.csrf().disable().authorizeRequests().anyRequest().authenticated().and().httpBasic()
             .authenticationEntryPoint(authEntryPoint);

 }

 @Autowired
 public void configureGlobal(AuthenticationManagerBuilder auth, UserDetailsService userDetailsService)
         throws Exception {

     auth.userDetailsService(userDetailsService);
 }
 
}*/