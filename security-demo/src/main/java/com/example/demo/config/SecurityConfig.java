package com.example.demo.config;

import com.example.demo.security.AppAuthenticationFailureHandler;
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

  /*注入 登录 失败处理器*/
  @Autowired
  private AppAuthenticationFailureHandler appAuthenticationFailureHandler;

  @Autowired
  private JwtAuthenticationFilter jwtAuthenticationFilter;

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
    auth.userDetailsService(userDetailsService).passwordEncoder(password());
//    auth.userDetailsService(userDetailsService);
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
            .antMatchers(HttpMethod.GET, // 允许对于网站静态资源的无授权访问
                    "/",
                    "/*.html",
                    "/favicon.ico",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js",
                    "/swagger-resources/**",
                    "/v2/api-docs/**"
            )
            .permitAll()
            .antMatchers("/admin/login", "/register")// 对登录注册要允许匿名访问
            .permitAll()
            .antMatchers(HttpMethod.OPTIONS)//跨域请求会先进行一次options请求
            .permitAll()
//                .antMatchers("/**")//测试时全部运行访问
//                .permitAll()
            .anyRequest()// 除上面外的所有请求全部需要鉴权认证
            .authenticated()
      .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            .formLogin()
//            .usernameParameter("username")//页面表单账号的参数名  默认 为 username
//            .passwordParameter("password")//页面表单密码的参数名   默认 为 password
//            .loginProcessingUrl("/login")// 表单提交的 地址(不需要提供)，登录验证.....
//            .failureHandler(appAuthenticationFailureHandler)//登录失败处理器
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
