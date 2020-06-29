package com.test.dao;

import java.sql.*;


public class BaseDao {
    static final String driver = "com.mysql.jdbc.Driver";
    static final String url = "jdbc:mysql://127.0.0.1:3306/myschool";
    static final String user = "root";
    static final String password = "123";
    //创建数据库连接基本参数

    /**
     * 获取数据库连接
     *
     * @return con:数据库连接对象
     */
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driver);//获取驱动
            con = DriverManager.getConnection(url, user, password);//获取连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 关闭数据库连接
     *
     * @param con 数据库连接对象
     * @param st  Statement对象
     * @param rs  结果集
     */
    public void closeAll(Connection con, Statement st, ResultSet rs) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (st != null && !st.isClosed()) {
                st.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (rs != null && !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用增，删，改方法
     *
     * @param sql    sql语句
     * @param params 注入参数集合
     * @return
     */
    public int executeUpdate(String sql, Object... params) {
        PreparedStatement ps = null;
        int result = -1;
        if (params != null) {
            try {
                ps = this.getConnection().prepareStatement(sql);
                for (int i = 0; i < params.length; i++) {
                    ps.setObject((i + 1), params[i]);
                }
                //执行更改并返回结果集
                result = ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }


        }
        return result;
    }

    /**
     * 通用查询方法
     *
     * @param sql    sql语句
     * @param params 注入参数集合
     * @return rs 结果集
     */
    public ResultSet executeQuery(String sql, Object... params) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = this.getConnection();
        try {
            ps = con.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                }
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static void main(String[] args) {
        BaseDao baseDao = new BaseDao();
        Connection connection = baseDao.getConnection();
        System.out.println(connection);
    }
}
