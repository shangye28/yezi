package com.example.sshtest.pojo.dto;

public class PasswordDTO {
    private Integer userId;
    private String oldP;
    private String newP1;
    private String newP2;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getOldP() {
        return oldP;
    }

    public void setOldP(String oldP) {
        this.oldP = oldP;
    }

    public String getNewP1() {
        return newP1;
    }

    public void setNewP1(String newP1) {
        this.newP1 = newP1;
    }

    public String getNewP2() {
        return newP2;
    }

    public void setNewP2(String newP2) {
        this.newP2 = newP2;
    }

    @Override
    public String toString() {
        return "PasswordDTO{" +
                "userId=" + userId +
                ", oldP='" + oldP + '\'' +
                ", newP1='" + newP1 + '\'' +
                ", newP2='" + newP2 + '\'' +
                '}';
    }
}
