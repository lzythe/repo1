package com.test.dao.impl;

import com.test.dao.BaseDao;
import com.test.dao.roleDao;
import com.test.entity.role;
import com.test.entity.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class roleDaoImpl extends BaseDao implements roleDao {
    @Override
    public int getType(String type) {

        String sql = "select * from role where rolename=?";
        ResultSet rs = executeQuery(sql, type);
        int i = 0;
        try {
            if (rs.next()){
                role role = new role();
                role.setRid(rs.getInt("rid"));
                role.setRolename(rs.getString("rolename"));
                i = role.getRid();


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return i;
    }

    @Override
    public List<role> AllPost() {
        String sql = "select * from role";
        ResultSet rs = executeQuery(sql);
        ArrayList<role> roleList = new ArrayList<>();

        try {
            while(rs.next()){
                role role = new role();
                role.setRid(rs.getInt("rid"));
                role.setRolename(rs.getString("rolename"));
                roleList.add(role);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return roleList;
    }

    public static void main(String[] args) {
        roleDaoImpl roleDao = new roleDaoImpl();
        List<role> roles = roleDao.AllPost();

        for(role role : roles){
            System.out.println(role.getRolename());
        }
    }

}
