package com.example.sshtest.security;

import com.example.sshtest.result.R;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
没有权限处理器
* */
@Component
public class AppAccessDeniedHandler implements AccessDeniedHandler {
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        System.out.println("没有权限");
        /*设置响应编码 放置乱码*/
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        /*将 result 转换为 json数据*/
        String json = objectMapper.writeValueAsString(R.FAIL(403,"没有权限"));
        /*响应json数据*/
        PrintWriter writer = response.getWriter();
        writer.write(json);
        writer.flush();
    }
}