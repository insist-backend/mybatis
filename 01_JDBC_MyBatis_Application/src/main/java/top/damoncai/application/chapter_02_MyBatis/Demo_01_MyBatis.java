package top.damoncai.application.chapter_02_MyBatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.damoncai.application.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;

/**
 * MyBatis 基本操作
 */
public class Demo_01_MyBatis {

    public static void main(String[] args) throws IOException {
        // 1.获取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        // 2.加载配置文件。获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        // 3.根据SqlSessionFactory对象获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        // 4.通过SqlSession中提供的 API方法来操作数据库
        List<User> users = sqlSession.selectList("top.damoncai.application.mapper.UserMapper.selectList");
        System.out.println(users);
    }
}

