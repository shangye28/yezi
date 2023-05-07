package com.example.sshtest.config;

import com.example.sshtest.result.R;
import com.example.sshtest.utils.JWTUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理器
 */
public class LoginSuccesHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        httpServletRequest.setCharacterEncoding("application/json;charset=UTF-8");
        ServletOutputStream outputStream = httpServletResponse.getOutputStream();

        Map<String,String> hm = new HashMap<>();
        hm.put("username","user");
        hm.put("userId","1");
        String token = JWTUtils.getToken(hm);


        outputStream.write();
        outputStream.flush();
        outputStream.close();
    }
}
