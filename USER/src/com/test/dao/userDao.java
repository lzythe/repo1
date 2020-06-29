package com.test.dao;

import com.test.entity.role;
import com.test.entity.user;

import java.util.List;

public interface userDao {
    //登录 判断用户是否存在
    public user findAlluser(String phone, String password);
    //查询所有用户
    public List<user> Alluser();
    //添加用户
    public int adduser(user user);
    //删除
    public int delectUser(int uid);
    //修改
    public int upUser(int uid,String upname,String upmail,String upphone,int uptype);


}
