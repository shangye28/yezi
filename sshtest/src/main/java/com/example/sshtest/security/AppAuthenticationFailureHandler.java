package com.example.sshtest.security;

import com.example.sshtest.result.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*登录失败处理器*/
@Component
public class AppAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        System.out.println("登录失败");
        /*设置响应编码 放置乱码*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        /*将 result 转换为 json数据*/
        String json = null;
        if (e instanceof BadCredentialsException) {
            json = objectMapper.writeValueAsString(R.FAIL(-1,"登录失败","失败原因:密码不正确"));
        } else if (e instanceof DisabledException) {
            json = objectMapper.writeValueAsString(R.FAIL(-1,"登录失败","失败原因:账号被禁用"));
        } else if (e instanceof UsernameNotFoundException) {
            json = objectMapper.writeValueAsString(R.FAIL(-1,"登录失败","失败原因:查无此账号"));
        } else if (e instanceof CredentialsExpiredException) {
            json = objectMapper.writeValueAsString(R.FAIL(-1,"登录失败","失败原因:密码过期"));
        } else if (e instanceof AccountExpiredException) {
            json = objectMapper.writeValueAsString(R.FAIL(-1,"登录失败","失败原因:账号过期"));
        } else if (e instanceof LockedException) {
            json = objectMapper.writeValueAsString(R.FAIL(-1,"登录失败","败原因:账号被锁定"));
        }

        /*响应json数据*/
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
    }
}