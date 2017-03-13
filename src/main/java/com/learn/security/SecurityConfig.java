package com.learn.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by mohammad on 13/3/17.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Value("${admin.learn.username}")
  private String userName1;
  @Value("${admin.learn.password}")
  private String password1;
  @Value("${admin.learn.role")
  private String admin1;


  @Value("${admin.dba.learn.username}")
  private String userName2;
  @Value("${admin.dba.learn.password}")
  private String password2;
  @Value("${admin.dba.learn.role")
  private String admin2;

  @Autowired
  public void configureGlobalSecurity(AuthenticationManagerBuilder authenticationManagerBuilder)
      throws Exception {
    authenticationManagerBuilder.inMemoryAuthentication().withUser(userName1).password(password1)
        .roles(admin1);
    authenticationManagerBuilder.inMemoryAuthentication().withUser(userName2).password(password2)
        .roles(admin2);
  }

  @Override
  public void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests()
        .antMatchers("/", "/home").permitAll()
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
        .and().formLogin()
        .and().exceptionHandling().accessDeniedPage("/Access_Denied");
  }
}
