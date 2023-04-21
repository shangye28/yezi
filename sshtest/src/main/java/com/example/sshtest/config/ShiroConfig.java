package com.example.sshtest.config;


import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.example.sshtest.dao.MenuDao;
import com.example.sshtest.pojo.Menu;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



/**
 * shiro配置类
 */
@Configuration
public class ShiroConfig {

    /**
     * 工厂对象3
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //给filter设置安全管理
        bean.setSecurityManager(defaultWebSecurityManager);


        /**
         *
         * 基于路径拦截资源
         *   anon 无需认证
         *   authc 必须认证
         *   user 记住我功能
         *   perms 拥有对某个资源
         *   roles 用某个角色权限
         */


        Map<String,String> map = new HashMap<>();
//        map.put("/index","authc");
        map.put("/login","anon");
        map.put("/","authc");
        map.put("/save","perms[add]");
        map.put("/update","perms[update]");
        map.put("/user:view", "roles[超级管理员]");
        //更改默认的登录请求路径
        bean.setLoginUrl("/login");
        //未授权请求路径
        bean.setUnauthorizedUrl("/unauthorized");
        bean.setFilterChainDefinitionMap(map);
        return bean;
    }
    /**
     * 安全对象2
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 管理realm
        securityManager.setRealm(userRealm);
        return securityManager;

    }



    /**
     * 创建realm对象，先创建，再接管1
     */
    @Bean(name = "userRealm")
    public UserRealm userRealm(){
        return new UserRealm();
    }


    /**
     * 页面的Shiro标签生效
     * @return
     */
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

}
