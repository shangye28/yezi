package com.example.demo.config;

import com.example.demo.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserDetailsService userDetailsService;

  /*注入 jwt过滤器*/
  @Autowired
  private JwtAuthenticationFilter jwtAuthenticationFilter;


  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService).passwordEncoder(password());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                    "/",
                    "/favicon.ico"
            )
            .permitAll()
            .antMatchers("/login", "/register")// 对登录注册要允许匿名访问
            .permitAll()
            .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
            .permitAll()
//                .antMatchers("/**")//测试时全部运行访问
//                .permitAll()
            .anyRequest()// 除上面外的所有请求全部需要鉴权认证
            .authenticated()
      .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
            .csrf().disable();
    // 添加JWT filter
    http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
  }

  @Bean
  public PasswordEncoder password(){
    return new BCryptPasswordEncoder();
  }
}
