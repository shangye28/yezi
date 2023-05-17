package com.example.sshtest.security;

import com.example.sshtest.result.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*登出成功处理器*/
@Component
public class AppLogoutSuccessHandler implements LogoutSuccessHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("登出成功");
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
