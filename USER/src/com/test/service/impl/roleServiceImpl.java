package com.test.service.impl;

import com.test.dao.impl.roleDaoImpl;
import com.test.dao.roleDao;
import com.test.dao.userDao;
import com.test.entity.role;
import com.test.service.roleService;

import java.util.List;

public class roleServiceImpl implements roleService {
    roleDaoImpl roleDao = new roleDaoImpl();
    @Override
    public int getType(String type) {

        return roleDao.getType(type);
    }

    @Override
    public List<role> AllPost() {
        return roleDao.AllPost();
    }
}
