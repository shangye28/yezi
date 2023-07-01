package com.example.demo.domain;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

/**
 * 用户信息
 */
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
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
    private LocalDateTime createTime;

    @Column(name = "remake")
    private String remake;

    @Column(name = "deptId")
    private Integer deptId;

    /**
     * user与role多对多关系映射
     */
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "userId", referencedColumnName = "userId"),
            inverseJoinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"))
    private List<RoleEntity> roleEntities = new ArrayList<>();

    /**
     * user与dept多对一关系映射
     */
    @ManyToOne
    @JoinColumn(name = "deptId", insertable = false, updatable = false)
    private DeptEntity deptEntity;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getRemake() {
        return remake;
    }

    public void setRemake(String remake) {
        this.remake = remake;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public List<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(List<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    public DeptEntity getDeptEntity() {
        if(deptEntity ==null)
            return deptEntity;
        else {
            DeptEntity deptEntity1 = new DeptEntity();
            deptEntity1.setDeptId(deptEntity.getDeptId());
            deptEntity1.setDeptName(deptEntity.getDeptName());
            return deptEntity1;
        }
    }

    public void setDeptEntity(DeptEntity deptEntity) {
        this.deptEntity = deptEntity;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", status='" + status + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", remake='" + remake + '\'' +
                ", deptId=" + deptId +
                ", roleEntities=" + roleEntities +
                ", deptEntity=" + deptEntity +
                '}';
    }


}