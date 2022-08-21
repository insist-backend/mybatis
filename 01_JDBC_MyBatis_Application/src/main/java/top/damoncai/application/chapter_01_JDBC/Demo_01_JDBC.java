package top.damoncai.application.chapter_01_JDBC;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * JDBC 基本操作
 */
public class Demo_01_JDBC {

    private static String url = "jdbc:mysql://47.100.22.236:3306/mybatis?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=GMT%2b8";
    private static String username = "root";
    private static String pwd = "zhishun.cai";


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 打开连接
        Connection connection = DriverManager.getConnection(url, username, pwd);

        // 执行SQL
        Statement statement = connection.createStatement();
        String sql = "select * from user";
        ResultSet resultSet = statement.executeQuery(sql);

        // 遍历输出
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String age = resultSet.getString("age");

            System.out.println("id:" + id);
            System.out.println("username:" + username);
            System.out.println("age:" + age);
        }
    }
}
