package com.example.sshtest.pojo;


import javax.persistence.*;

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

    private String parentName;          //父部门名称

    @Column(name = "deptSort")
    private String deptSort;            //排序

    @Column(name = "status")
    private String status;              //部门状态

    @Column(name = "remake")
    private String remake;              //备注
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
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

    @Override
    public String toString() {
        return "Dept{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", parentId='" + parentId + '\'' +
                ", parentName='" + parentName + '\'' +
                ", deptSort='" + deptSort + '\'' +
                ", status='" + status + '\'' +
                ", remake='" + remake + '\'' +
                '}';
    }
}