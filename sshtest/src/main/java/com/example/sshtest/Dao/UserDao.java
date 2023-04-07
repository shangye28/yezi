package com.example.sshtest.Dao;

import com.example.sshtest.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends CrudRepository<User,Integer> {

    @Query(value = "select * from user where username = :username", nativeQuery = true)
    User findByUsername(@Param("username") String username);

    @Query(value = "select * from user where nickname = :nickname", nativeQuery = true)
    User findByNickname(@Param("nickname") String nickname);
}