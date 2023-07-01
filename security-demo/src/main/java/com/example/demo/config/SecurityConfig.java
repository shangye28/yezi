package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;

//  //创建内存数据源
//  @Bean
//  public UserDetailsService userDetailsService(){
//    InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
//    //admin用户 具有ADMIN 和 USER角色
//    inMemoryUserDetailsManager.createUser(User1.withUsername("admin").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN","USER").build());
//    //user用户 具有USER角色
//    inMemoryUserDetailsManager.createUser(User1.withUsername("User1").password(new BCryptPasswordEncoder().encode("123456")).roles("USER").build());
//    //info用户具有READ_INFO权限操作
//    inMemoryUserDetailsManager.createUser(User1.withUsername("info").password(new BCryptPasswordEncoder().encode("123456")).authorities("READ_INFO").build());
//    return inMemoryUserDetailsManager;
//  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(userDetailsService).passwordEncoder(password());
    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
//      //访问/admin必须有ADMIN角色
//      .mvcMatchers("/helloword1").hasRole("ADMIN")
//      //访问/user需要USER角色或者ADMIN角色
//      .mvcMatchers("/helloword2").hasRole("USER")
//      //访问/info必须有READ_INFO权限
//      .mvcMatchers("/helloword3").hasAuthority("READ_INFO")
      .anyRequest().authenticated()
      .and().formLogin()
      .and().csrf().disable();
  }

  @Bean
  public PasswordEncoder password(){
    return new BCryptPasswordEncoder();
  }
}
