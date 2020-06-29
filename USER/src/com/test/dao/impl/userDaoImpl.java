package com.test.dao.impl;

import com.test.dao.BaseDao;
import com.test.dao.userDao;
import com.test.entity.role;
import com.test.entity.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class userDaoImpl extends BaseDao implements userDao {
    @Override
    public user findAlluser(String phone, String password) {
        String sql = "select * from user where phone=? and password=?";
        ResultSet rs = executeQuery(sql,phone,password);
        user user = null;
        try {
            while(rs.next()){
                user = new user();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMail(rs.getString("mail"));
                user.setPhone(rs.getString("phone"));
                user.setType(rs.getInt("type"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<user> Alluser() {
        String sql = "select * from user";
        ResultSet rs = executeQuery(sql);
        ArrayList<user> userList = new ArrayList<>();
        try {
            while(rs.next()){
                user user = new user();
                user.setUid(rs.getInt("uid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMail(rs.getString("mail"));
                user.setPhone(rs.getString("phone"));
                user.setType(rs.getInt("type"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public int adduser(user user) {
        String sql = "insert into user (username,password,mail,phone,type) values (?,?,?,?,?)";
        Object[] params ={user.getUsername(),user.getPassword(),user.getMail(),user.getPhone(),user.getType()};
        int a = executeUpdate(sql,params);

        return a;
    }

    @Override
    public int delectUser(int uid) {
        String sql = "delete from user where uid=?";
        int i = executeUpdate(sql, uid);
        return i;
    }

    @Override
    public int upUser(int uid, String upname, String upmail, String upphone, int uptype) {
        String sql = "update user set username=?,mail=?,phone=?,type=? where uid=?";
        Object[] params = {upname,upmail,upphone,uptype,uid};
        int i = executeUpdate(sql, params);
        return i;
    }


}
