package com.example.sshtest.config;

import com.example.sshtest.security.AppAccessDeniedHandler;
import com.example.sshtest.security.AppAuthenticationFailureHandler;
import com.example.sshtest.security.AppAuthenticationSuccessHandler;
import com.example.sshtest.security.AppLogoutSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfigurer extends WebSecurityConfigurerAdapter {
    /*注入 登录成功处理器*/
    @Autowired
    private AppAuthenticationSuccessHandler appAuthenticationSuccessHandler;

    /*注入 登录 失败处理器*/
    @Autowired
    private AppAuthenticationFailureHandler appAuthenticationFailureHandler;

    /*注入  没有权限处理器*/
    @Autowired
    private AppAccessDeniedHandler appAccessDeniedHandler;

    /*注入 登出成功处理器*/
    @Autowired
    private AppLogoutSuccessHandler appLogoutSuccessHandler;



    private static final String URL_WHITELIST[] = {
            "/login",
            "/logout",
            "/captcha",
            "/password",
            "/image/**",
            "/user/**"
    };


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 配置Spring Security的拦截规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //开启跨域 关闭csrf攻击
        http
                .cors()
        .and()
                .csrf()
                .disable()

        //登录配置
                .formLogin()
                .usernameParameter("username")//页面表单账号的参数名  默认 为 username
                .passwordParameter("password")//页面表单密码的参数名   默认 为 password
                .loginProcessingUrl("/login")// 表单提交的 地址(不需要提供)，登录验证.....
//                .successForwardUrl("/welcome")//登录成功 跳转的路径
//                .failureForwardUrl("/fail")//登录失败 跳转的路径
                .successHandler(appAuthenticationSuccessHandler)//登录成功处理器
                .failureHandler(appAuthenticationFailureHandler)//登录失败处理器
                .permitAll()

//                .successHandler()
//                .failureHandler()
//        .and()
//                .logout()
//                .logoutSuccessHandler()

        //session禁用
        .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        //拦截配置
        .and()
                .authorizeRequests()
//                .antMatchers(URL_WHITELIST).permitAll()
//                .anyRequest().authenticated();
                //匹配资源与权限   资源                                   权限（角色）
                .antMatchers("/user/view").hasAnyAuthority("user:view")
                .antMatchers("/dept/view").hasAnyAuthority("dept:view")
                .antMatchers("/menu/view").hasAnyAuthority("menu:view")
                .antMatchers("/role/view").hasAnyAuthority("role:view")
                //给 父路径下 其所有资源 配置  权限 （觉得）
                .antMatchers("/user/**").hasRole("ADMIN");



        //登录异常配置

        //自定义配置
    }

    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //在内存中定义，也可以在jdbc中去拿....
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("ADMIN");

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }
}
