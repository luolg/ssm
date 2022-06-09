package com.luolg;

import com.luolg.domain.SysUser;
import com.luolg.mapper.SysUserMapper;
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

public class MybatisTest4 {

    private SysUserMapper sysUserMapper;

    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        sysUserMapper = sqlSession.getMapper(SysUserMapper.class);
    }

    @Test
    public void test() {
        List<SysUser> sysUsers = sysUserMapper.findUserAndRoleAll();
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser);
        }
    }

}
