//package com.example.sshtest.config;
//
//
//import com.example.sshtest.result.R;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.io.PrintWriter;
//
///**
// * 用户访问无权限访问异常
// */
//@Configuration
//public class JwtAuthenticationEntryPoint  implements AuthenticationEntryPoint {
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("application/json");
//        response.setStatus(401);
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write(new ObjectMapper().writeValueAsString(R.FAIL("您尚未登录或登录信息已过期，请重新登录！")));
//        printWriter.flush();
//        printWriter.close();
//    }
//}
