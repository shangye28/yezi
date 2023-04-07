package com.example.sshtest.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

/**
 * 用户信息
 */
// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// Jpa规范，必须标识这是个entity，指向对应table，两者关联。
@Entity
@Table(name = "user")
public class User {
    // Jpa规范，必须有一个唯一标识标识，此注解标识标识成员属性id为唯一标识。
    @Id
    // Jpa规范，唯一标识必须有增长策略
    @GeneratedValue(generator = "user",strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "sex")
    private String sex;

    @Column(name = "email")
    private String email;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "status")
    private String status;

    @Column(name = "phone")
    private String phone;

    @Column(name = "createTime")
    private String createTime;

    @Column(name = "remake")
    private String remake;


}