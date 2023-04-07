package com.example.sshtest.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
// Jpa规范，必须标识这是个entity，指向对应table，两者关联。
@Entity
@Table(name = "dept")
public class Dept {
    // Jpa规范，必须有一个唯一标识标识，此注解标识标识成员属性id为唯一标识。
    @Id
    // Jpa规范，唯一标识必须有增长策略
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



}