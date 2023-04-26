package com.example.sshtest.dao;


import com.example.sshtest.pojo.User;

import java.util.List;


public interface UserDao extends BaseDao<User> {

    public List<User> findByUsername(String username);

    public List<User> findByNickname(String nickname);

    public List<User> findByDeptName(String deptName);

    public Long countByUsername(String username);

    public Long countByNickname(String nickname);

    public Long countByDeptName(String deptName);

    public User getByUsername(String username);
//    /**
//     * 查询所有
//     *
//     * @return
//     */
//    public List<User> findByAll();
//
//    /**
//     * 根据username模糊匹配查询
//     *
//     * @param username
//     * @return
//     */
//    public List<User> findByUsername(String username);
//
//    /**
//     * 根据nickname模糊匹配查询
//     *
//     * @param nickname
//     * @return
//     */
//    public List<User> findByNickname(String nickname);
//
//    /**
//     * 根据用户名查询
//     *
//     * @param username
//     * @return
//     */
//    public User getByUsername(String username);
//
//    /**
//     * 根据id查询
//     *
//     * @param id
//     * @return
//     */
//    public User getByUserId(Integer id);
//
//    /**
//     * 根据邮箱查询
//     *
//     * @param email
//     * @return
//     */
//    public User getByEmail(String email);
//
//    /**
//     * 根据手机号查询
//     *
//     * @param phone
//     * @return
//     */
//    public User getByPhone(String phone);
//
//    /**
//     * 查询所有记录条数
//     *
//     * @return
//     */
//    public Long countAll();
//
//    /**
//     * 用户名模糊匹配查询记录条数
//     *
//     * @param str
//     * @return
//     */
//    public Long countUsername(String str);
//
//    /**
//     * 昵称模糊匹配查询记录条数
//     *
//     * @param str
//     * @return
//     */
//    public Long countNickname(String str);
//
//    /**
//     * 删除用户
//     *
//     * @param user
//     */
//    public void delete(User user);
//
//    /**
//     * 新增用户
//     *
//     * @param user
//     */
//    public void save(User user);
//
//    /**
//     * 更新用户
//     *
//     * @param user
//     */
//    public void updata(User user);
}
