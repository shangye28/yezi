package com.example.demo.service;

import com.example.demo.domain.UserEntity;
import com.example.demo.domain.vo.PageVO;

public interface UserService extends BaseService<UserEntity>{
    public PageVO<UserEntity> findByName(String username, String nickname);

    public PageVO<UserEntity> findByDeptName(String deptName);

    public UserEntity getByUsername(String username);

    public boolean checkUsernameUnique(String username);
}