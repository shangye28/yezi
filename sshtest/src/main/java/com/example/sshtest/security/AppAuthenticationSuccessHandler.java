package com.example.sshtest.security;

import com.example.sshtest.result.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 自定义的 登录成功处理器  直接返回json数据
 * */
@Component
public class AppAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;

    /**
     * @param request        请求对象
     * @param response       响应对象
     * @param authentication 认证对象（用户信息）
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("登录成功");
        /*设置响应编码 放置乱码*/

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        /*将 result 转换为 json数据*/
        String json = objectMapper.writeValueAsString(R.SUCCESS(authentication));
        /*响应json数据*/
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
    }
}
