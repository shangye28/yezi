package com.example.demo.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.CascadeType.DETACH;

/**
 * 角色信息
 */
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
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

    /**
     * user与role多对多映射
     */
    @JsonIgnore     //json输出时忽略，防止出现数据死循环
    @ManyToMany(fetch = FetchType.EAGER, cascade = DETACH)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"))
    private Set<UserEntity> userEntities = new LinkedHashSet<>();

    /**
     * role与menu多对多映射
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = DETACH)
    @JoinTable(name = "role_menu",
            joinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "menuId", referencedColumnName = "menuId"))
    private List<MenuEntity> menuEntities = new ArrayList<>();


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getRoleSort() {
        return roleSort;
    }

    public void setRoleSort(String roleSort) {
        this.roleSort = roleSort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    public List<MenuEntity> getMenuEntities() {
        return menuEntities;
    }

    public void setMenuEntities(List<MenuEntity> menuEntities) {
        this.menuEntities = menuEntities;
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleKey='" + roleKey + '\'' +
                ", roleSort='" + roleSort + '\'' +
                ", status='" + status + '\'' +
                ", remake='" + remake + '\'' +
                ", menuEntities=" + menuEntities +
                '}';
    }
}