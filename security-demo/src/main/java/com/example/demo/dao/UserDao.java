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
//    /**
//     * 查询所有
//     *
//     * @return
//     */
//    public List<UserEntity> findByAll();
//
//    /**
//     * 根据username模糊匹配查询
//     *
//     * @param username
//     * @return
//     */
//    public List<UserEntity> findByUsername(String username);
//
//    /**
//     * 根据nickname模糊匹配查询
//     *
//     * @param nickname
//     * @return
//     */
//    public List<UserEntity> findByNickname(String nickname);
//
//    /**
//     * 根据用户名查询
//     *
//     * @param username
//     * @return
//     */
//    public UserEntity getByUsername(String username);
//
//    /**
//     * 根据id查询
//     *
//     * @param id
//     * @return
//     */
//    public UserEntity getByUserId(Integer id);
//
//    /**
//     * 根据邮箱查询
//     *
//     * @param email
//     * @return
//     */
//    public UserEntity getByEmail(String email);
//
//    /**
//     * 根据手机号查询
//     *
//     * @param phone
//     * @return
//     */
//    public UserEntity getByPhone(String phone);
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
//    public void delete(UserEntity user);
//
//    /**
//     * 新增用户
//     *
//     * @param user
//     */
//    public void save(UserEntity user);
//
//    /**
//     * 更新用户
//     *
//     * @param user
//     */
//    public void updata(UserEntity user);
}
