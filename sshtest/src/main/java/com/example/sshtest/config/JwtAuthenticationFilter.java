//package com.example.sshtest.config;
//
//import com.example.sshtest.pojo.vo.LoginUser;
//import com.example.sshtest.utils.JWTUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Value("${jwt.tokenHeader}")
//    private String tokenHeader;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
//        JWTUtils jwtUtils = new JWTUtils();
//        //1:获取请求头中的token
//        String token = request.getHeader(tokenHeader);
//        //2：判断token是否存在
//        if(!StrUtil.isBlank(token)){
//            //根据token获取用户名
//            String userName = tokenUtil.getUserNameFromToken(token);
//            //3：token存在但是security里面没有登录信息，代表有token但是没登录
//            if(null == SecurityContextHolder.getContext().getAuthentication()){
//                //没有登录信息，直接登录
//                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
//                //判断token是否有效,token没有过期，并且和userdetail中的username一样，那么就将security中的登录信息进行刷新
//                if(tokenUtil.isExpiration(token) && userName.equals(userDetails.getUsername())){
//                    //刷新security中的用户信息
//                    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                    authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
//                }
//            }
//        }
//        chain.doFilter(request, response);
//    }
//
//}
