package com.test.dao.impl;

import com.test.dao.BaseDao;
import com.test.dao.user_roleDao;

public class user_roleDaoImpl extends BaseDao implements user_roleDao {
    @Override
    public int addUR(int uid, int rid) {
        String sql = "insert into user_role(uid,rid) value (?,?)";
        int i = executeUpdate(sql, uid, rid);

        return i;
    }

    @Override
    public int dtUR(int uid) {
        String sql ="delete from user_role where uid=?";
        int i = executeUpdate(sql, uid);
        return i;
    }

    @Override
    public int upUR(int uid, int rid) {
        String sql = "update user_role set rid=? where uid=?";
        int i = executeUpdate(sql,rid, uid);

        return i;
    }
}
