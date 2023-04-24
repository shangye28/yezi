package com.example.sshtest.config;

import com.example.sshtest.result.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomizeAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 配置Spring Security的拦截规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //关闭跨站请求防护
                .cors()
                .and()
                .csrf()
                .disable()                                                             // 关闭csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)     // 指定session的创建策略，不使用session
//                //异常处理(权限拒绝、登录失效等)
//                .and().exceptionHandling().
//                authenticationEntryPoint(authenticationEntryPoint)//匿名用户访问无权限资源时的异常处理
                //登入
//                .and().formLogin()
//                    .permitAll()//允许所有用户
//                    successHandler(authenticationSuccessHandler).//登录成功处理逻辑
//                    failureHandler(authenticationFailureHandler).//登录失败处理逻辑
                //退出
//                .and().logout()
//                    .permitAll().//允许所有用户
////                    logoutSuccessHandler(logoutSuccessHandler).//登出成功处理逻辑
//                    deleteCookies("JSESSIONID")//登出之后删除cookie
                .and()                                                                          // 再次获取到HttpSecurity对象
                .authorizeRequests()                                                            // 进行认证请求的配置
                .antMatchers("/login").anonymous()                                         // 对于登录接口，允许匿名访问
//                .antMatchers("/user/view").hasAnyAuthority("user:view")
                .anyRequest().authenticated();                                                  // 除了上面的请求以外所有的请求全部需要认证

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
