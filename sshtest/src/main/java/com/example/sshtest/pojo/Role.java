package com.example.sshtest.pojo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

/**
 * 角色信息
 */
// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// Jpa规范，必须标识这是个entity，指向对应table，两者关联。
@Entity
@Table(name = "role")
public class Role {
    // Jpa规范，必须有一个唯一标识标识，此注解标识标识成员属性id为唯一标识。
    @Id
    // Jpa规范，唯一标识必须有增长策略
    @GeneratedValue(generator = "role",strategy = GenerationType.IDENTITY)
    private Integer roleId;              //角色ID

    @Column(name = "roleName")
    private String roleName;            //角色名
    @Column(name = "roleKey")
    private String roleKey;             //角色值
    @Column(name = "roleSort")
    private String roleSort;            //排序
    @Column(name = "status")
    private String status;              //角色状态
    @Column(name = "remake")
    private String remake;              //备注
//    private Long[] MenuIds;             //菜单权限

}