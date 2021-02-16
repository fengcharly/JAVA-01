package com.test.bsecond.xunlianying.week05.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 使用JDBC进行CRUD的操作
 */
public class JDBCMain {

    public static void main(String[] args) throws Exception {
        // 1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 2.建立连接
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useSSL=false", "root", "root");
        System.out.println(con);

        // 3.预处理sql语句
        // 需求：查询出id、名字，展示到控制台
        PreparedStatement pst = con.prepareStatement("select * from student limit 5");

        // 4.执行sql语句
        ResultSet rs = pst.executeQuery();

        // 5.处理sql语句执行的结果
        while (rs.next()) {
            System.out.println(rs.getInt("id") + "==" + rs.getString("name"));
        }
        // 6.释放资源(链接、结果、预定义对象)
        rs.close();
        pst.close();
        con.close();
    }
}
