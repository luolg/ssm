package com.luolg;

import com.luolg.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {
    //    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("userMapper.findAll");

        System.out.println(userList);

        sqlSession.close();
    }


    //    @Test
    public void test2() throws IOException {

        User user = new User();
        user.setId(22);
        user.setUsername("pog");
        user.setPassword("pog123");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int insert = sqlSession.insert("userMapper.save", user);
        System.out.println(insert);

        sqlSession.commit();
        sqlSession.close();
    }


    //    @Test
    public void test3() throws IOException {

        User user = new User();
        user.setId(22);
        user.setUsername("tim");
        user.setPassword("tim123");

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int insert = sqlSession.update("userMapper.update", user);
        System.out.println(insert);
        sqlSession.commit();
        sqlSession.close();
    }

    //    @Test
    public void test4() throws IOException {

        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        int insert = sqlSession.delete("userMapper.delete", 22);
        System.out.println(insert);
        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("userMapper.findById", 1);

        System.out.println(user);

        sqlSession.close();
    }

}
