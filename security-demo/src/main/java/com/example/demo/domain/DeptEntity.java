package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;
import static javax.persistence.FetchType.LAZY;

/**
 * 部门信息
 */
@Entity
@Table(name = "dept")
public class DeptEntity {
    @Id
    @GeneratedValue(generator = "dept",strategy = GenerationType.IDENTITY)
    private Integer deptId;              //部门ID

    @Column(name = "deptName")
    private String deptName;            //部门名称

    @Column(name = "parentId")
    private String parentId;            //父部门ID

    @Column(name = "deptSort")
    private String deptSort;            //排序

    @Column(name = "status")
    private String status;              //部门状态

    @Column(name = "remake")
    private String remake;              //备注

    /**
     * 父部门多对一
     */
    @JsonIgnore     //json输出时忽略，防止出现数据死循环
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "parentId", insertable = false, updatable = false)
    private DeptEntity parent;

    /**
     * 子部门一多多
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parentId", orphanRemoval = true)
    private Set<DeptEntity> deptEntities = new LinkedHashSet<>();

    /**
     * dept与user一对多
     */
    @JsonIgnore     //json输出时忽略，防止出现数据死循环
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId", orphanRemoval = true)
    private Set<UserEntity> userEntities = new LinkedHashSet<>();

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getDeptSort() {
        return deptSort;
    }

    public void setDeptSort(String deptSort) {
        this.deptSort = deptSort;
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

    public DeptEntity getParent() {
        if(parent == null)
            return parent;
        else{
            DeptEntity parent1 = new DeptEntity();
            parent1.setDeptId(parent.getDeptId());
            parent1.setDeptName(parent.getDeptName());
            return parent1;
        }
    }

    public void setParent(DeptEntity parent) {
        this.parent = parent;
    }

    public Set<DeptEntity> getDeptEntities() {
        return deptEntities;
    }

    public void setDeptEntities(Set<DeptEntity> deptEntities) {
        this.deptEntities = deptEntities;
    }

    public Set<UserEntity> getUserEntities() {
        return userEntities;
    }

    public void setUserEntities(Set<UserEntity> userEntities) {
        this.userEntities = userEntities;
    }

    @Override
    public String toString() {
        return "DeptEntity{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", deptSort='" + deptSort + '\'' +
                ", status='" + status + '\'' +
                ", remake='" + remake + '\'' +
                ", parent=" + parent +
                ", menus=" + deptEntities +
                ", userEntities=" + userEntities +
                '}';
    }
}