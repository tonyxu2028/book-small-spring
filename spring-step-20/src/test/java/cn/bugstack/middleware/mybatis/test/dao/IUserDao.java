package cn.bugstack.middleware.mybatis.test.dao;

import cn.bugstack.middleware.mybatis.test.po.User;

public interface IUserDao {

     @SuppressWarnings("unused")
     User queryUserInfoById(Long id);

}
