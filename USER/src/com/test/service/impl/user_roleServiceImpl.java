package com.test.service.impl;

import com.test.dao.impl.user_roleDaoImpl;
import com.test.service.user_roleService;

public class user_roleServiceImpl implements user_roleService {
    user_roleDaoImpl user_roleDao = new user_roleDaoImpl();

    @Override
    public int addUR(int uid, int rid) {
        return user_roleDao.addUR(uid,rid);
    }

    @Override
    public int dtUR(int uid) {
        return user_roleDao.dtUR(uid);
    }

    @Override
    public int upUR(int uid, int rid) {
        return user_roleDao.upUR(uid,rid);
    }
}
