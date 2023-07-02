package com.example.demo.dao;

import com.example.demo.domain.UserEntity;
import java.util.List;

public interface UserDao extends BaseDao<UserEntity> {
    public List<UserEntity> findByUsername(String username);

    public List<UserEntity> findByNickname(String nickname);

    public List<UserEntity> findByDeptName(String deptName);

    public List<String> getPermissionByUsername(String username);

    public Long countByUsername(String username);

    public Long countByNickname(String nickname);

    public Long countByDeptName(String deptName);

    public UserEntity getByUsername(String username);
}
