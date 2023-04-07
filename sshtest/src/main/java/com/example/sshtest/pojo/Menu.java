package com.example.sshtest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单信息
 */
// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// Jpa规范，必须标识这是个entity，指向对应table，两者关联。
@Entity
@Table(name = "menu")
public class Menu {
    // Jpa规范，必须有一个唯一标识标识，此注解标识标识成员属性id为唯一标识。
    @Id
    // Jpa规范，唯一标识必须有增长策略
    @GeneratedValue(generator = "menu",strategy = GenerationType.IDENTITY)
    private Integer menuId;              //菜单ID
    @Column(name = "menuName")
    private String menuName;            //菜单名称

    private String parentName;          //父菜单名称
    @Column(name = "parentId")
    private String parentId;            //父菜单ID
    @Column(name = "menuSort")
    private String menuSort;            //排序
    @Column(name = "menuType")
    private String menuType;            //菜单类型
    @Column(name = "status")
    private String status;              //菜单状态
    @Column(name = "permission")
    private String permission;          //权限标识
    @Column(name = "icon")
    private String icon;                //菜单图标

//    private List<Menu> children = new ArrayList<>();       //子菜单

}
