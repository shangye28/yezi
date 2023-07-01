package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

/**
 * 菜单信息
 */
@Entity
@Table(name = "menu")
public class MenuEntity {
    @Id
    @GeneratedValue(generator = "menu",strategy = GenerationType.IDENTITY)
    private Integer menuId;              //菜单ID

    @Column(name = "menuName")
    private String menuName;            //菜单名称

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

    @Column(name = "url")
    private String url;

    @Column(name = "icon")
    private String icon;                //菜单图标

    /**
     * 父菜单多对一
     */
    @JsonIgnore     //json输出时忽略，防止出现数据死循环
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parentId", insertable = false, updatable = false)
    private MenuEntity parent;

    /**
     * 子菜单一多多
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId", orphanRemoval = true)
    private Set<MenuEntity> menuEntities = new LinkedHashSet<>();

    /**
     * menu与role多对多关系映射
     */
    @JsonIgnore     //json输出时忽略，防止出现数据死循环
    @ManyToMany(fetch = LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "role_menu",
            joinColumns = @JoinColumn(name = "menuId", referencedColumnName = "menuId"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"))
    private Set<RoleEntity> roleEntities = new LinkedHashSet<>();


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuSort() {
        return menuSort;
    }

    public void setMenuSort(String menuSort) {
        this.menuSort = menuSort;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public MenuEntity getParent() {
            return parent;
    }

    public void setParent(MenuEntity parent) {
        this.parent = parent;
    }

    public Set<MenuEntity> getMenuEntities() {
        return menuEntities;
    }

    public void setMenuEntities(Set<MenuEntity> menuEntities) {
        this.menuEntities = menuEntities;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(Set<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    @Override
    public String toString() {
        return "MenuEntity{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", menuSort='" + menuSort + '\'' +
                ", menuType='" + menuType + '\'' +
                ", status='" + status + '\'' +
                ", permission='" + permission + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", menuEntities=" + menuEntities +
                '}';
    }
}
