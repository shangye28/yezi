package com.example.sshtest.security;

import com.example.sshtest.dao.UserDao;
import com.example.sshtest.pojo.User;
import com.example.sshtest.pojo.UserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
 * 自定义认证
 *
 * */
@Component
public class AppUserDetailsService implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDao userDao;

    /**
     * @param username 用户输入的 账号
     * @return 用户信息（账号密码 权限，是否过期等 方法）
     * @throws UsernameNotFoundException 没有账号会抛该异常类型
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*通过账号查询用户*/
        User user = userDao.getByUsername(username);
        UserDetail userDetail = new UserDetail();
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        /*根据用户的id 获取用户的 权限字符串 集合*/
        List<String> permissions = userDao.getPermissionByUsername(user.getUsername());
        /*将 字符串集合 转换为  权限对象集合*/
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissions) {
            /*根据权限字符串 生成 对应的 权限对象*/
            authorities.add(new SimpleGrantedAuthority(permission));
        }
        /*将权限集合封装到 user对象中*/
        userDetail.setPermissions(authorities);
        return userDetail;
    }
}
