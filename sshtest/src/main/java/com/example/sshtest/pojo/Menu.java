package com.example.sshtest.pojo;


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
public class Menu {
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
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parentId", insertable = false, updatable = false)
    private Menu parent;

    /**
     * 子菜单一多多
     */
    @JsonIgnore     //json输出时忽略，防止出现数据死循环
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menuId", orphanRemoval = true)
    private Set<Menu> menus = new LinkedHashSet<>();

    /**
     * menu与role多对多关系映射
     */
    @JsonIgnore     //json输出时忽略，防止出现数据死循环
    @ManyToMany(fetch = LAZY, cascade = CascadeType.DETACH)
    @JoinTable(name = "role_menu",
            joinColumns = @JoinColumn(name = "menuId", referencedColumnName = "menuId"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"))
    private Set<Role> roles = new LinkedHashSet<>();


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

    public Menu getParent() {
        if(parent == null)
            return parent;
        else{
            Menu parent1 = new Menu();
            parent1.setMenuId(parent.getMenuId());
            parent1.setMenuName(parent.getMenuName());
            return parent1;
        }
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }

    public Set<Menu> getMenus() {
        return menus;
    }

    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", menuSort='" + menuSort + '\'' +
                ", menuType='" + menuType + '\'' +
                ", status='" + status + '\'' +
                ", permission='" + permission + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", parent=" + parent +
                ", menus=" + menus +
                '}';
    }
}
