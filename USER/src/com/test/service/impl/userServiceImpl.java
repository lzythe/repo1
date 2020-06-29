package com.test.service.impl;

import com.test.dao.impl.userDaoImpl;
import com.test.entity.role;
import com.test.entity.user;
import com.test.service.userService;

import java.util.List;

public class userServiceImpl implements userService {
    userDaoImpl userDao = new userDaoImpl();
    @Override
    public user findAlluser(String phone, String password) {

        return userDao.findAlluser(phone,password);
    }

    @Override
    public List<user> Alluser() {
        return userDao.Alluser();
    }

    @Override
    public int adduser(user user) {
        return userDao.adduser(user);
    }

    @Override
    public int delectUser(int uid) {
        return userDao.delectUser(uid);
    }

    @Override
    public int upUser(int uid, String upname, String upmail, String upphone, int uptype) {

        return userDao.upUser(uid,upname,upmail,upphone,uptype);
    }


}
