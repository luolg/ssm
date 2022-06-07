package com.luolg;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luolg.domain.User;
import com.luolg.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.apache.ibatis.io.Resources;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    //    @Test
    public void test1() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

//        User user = new User();
//        user.setId(34);
//        user.setUsername("julia");
//        user.setPassword("8989");
//        user.setBirthday(new Date());
//        userMapper.save(user);

        System.out.println(userMapper.findById(33));

        sqlSession.commit();
        sqlSession.close();

    }

    @Test
    public void test2() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //set the page split
        PageHelper.startPage(2, 3);

        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        // the page info
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("page num: " + pageInfo.getPageNum());
        System.out.println("page size: " + pageInfo.getPageSize());
        System.out.println("total records : " + pageInfo.getTotal());
        System.out.println("total pages " + pageInfo.getPages());
        System.out.println("pre page: " + pageInfo.getPrePage());
        System.out.println("next page: " + pageInfo.getNextPage());
        System.out.println("if is first page: " + pageInfo.isIsFirstPage());
        System.out.println("if is last page: " + pageInfo.isIsLastPage());

        sqlSession.commit();
        sqlSession.close();

    }
}

