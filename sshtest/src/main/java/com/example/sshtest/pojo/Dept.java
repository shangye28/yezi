package com.example.sshtest.pojo;


import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 部门信息
 */
@Entity
@Table(name = "dept")
public class Dept {
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptId", orphanRemoval = true)
    private Set<User> users = new LinkedHashSet<>();


//    private List<Dept> children = new ArrayList<>();       //子部门


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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", deptSort='" + deptSort + '\'' +
                ", status='" + status + '\'' +
                ", remake='" + remake + '\'' +
                ", users=" + users +
                '}';
    }
}