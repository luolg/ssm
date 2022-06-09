package com.luolg;

import com.luolg.domain.User;
import com.luolg.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);

    }

    //    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("bing");
        user.setPassword("bing123");
        userMapper.save(user);
    }

    //    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(39);
        user.setUsername("bang");
        user.setPassword("bang123");
        userMapper.update(user);
    }

    //    @Test
    public void testDelete() {
        userMapper.delete(39);
    }

    //    @Test
    public void testFindById() {
        User user = userMapper.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
