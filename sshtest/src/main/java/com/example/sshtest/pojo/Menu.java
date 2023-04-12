package com.example.sshtest.pojo;


import javax.persistence.*;

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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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

    @Override
    public String toString() {
        return "Menu{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", parentName='" + parentName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", menuSort='" + menuSort + '\'' +
                ", menuType='" + menuType + '\'' +
                ", status='" + status + '\'' +
                ", permission='" + permission + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
