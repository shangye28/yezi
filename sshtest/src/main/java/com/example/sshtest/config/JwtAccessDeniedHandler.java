//package com.example.sshtest.config;
//
//
//import com.example.sshtest.result.R;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.security.web.access.AccessDeniedHandler;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 用户权限访问不足
// */
//
//@Configuration
//public class JwtAccessDeniedHandler implements AccessDeniedHandler {
//    @Override
//    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        response.setStatus(403);
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write(new ObjectMapper().writeValueAsString(R.FAIL("权限不足，请联系管理员！")));
//        printWriter.flush();
//        printWriter.close();
//    }
//}
