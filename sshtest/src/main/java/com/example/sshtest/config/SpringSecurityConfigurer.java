//package com.example.sshtest.config;
//
//import com.example.sshtest.result.R;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//import org.springframework.security.web.authentication.AuthenticationFailureHandler;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {
//
////    @Autowired
////    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // 配置Spring Security的拦截规则
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http
////                //关闭跨站请求防护
////                .cors()
////                .and()
////                .csrf()
////                .disable()                                                             // 关闭csrf
////                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)     // 指定session的创建策略，不使用session
////                .and()                                                                          // 再次获取到HttpSecurity对象
////                .authorizeRequests()                                                            // 进行认证请求的配置
////                .antMatchers("/login").anonymous()                                         // 对于登录接口，允许匿名访问
//////                .antMatchers("/user/view").hasAnyAuthority("user:view")
////                .anyRequest().authenticated();                                                  // 除了上面的请求以外所有的请求全部需要认证
//        http.authorizeRequests().antMatchers("/").permitAll()
//                .antMatchers("/user/**").hasRole("vip1")
//                .antMatchers("/role/**").hasRole("vip2")
//                .antMatchers("/dept/**").hasRole("vip3");
//        http.formLogin();
//    }
//
//    //定义认证规则
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        //在内存中定义，也可以在jdbc中去拿....
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("kuangshen").password(new BCryptPasswordEncoder().encode("123456")).roles("vip2", "vip3")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2", "vip3")
//                .and()
//                .withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1", "vip2");
//
//    }
//
//    @Bean
//    @Override
//    public AuthenticationManager authenticationManagerBean() throws Exception{
//        return super.authenticationManagerBean();
//    }
//}
