package com.luolg.test;

import com.luolg.App;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class JdbcTemplateTest {
    //    @Test
    // test the jdbc template usage
    public void test1() throws PropertyVetoException {
        // create the data source object
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("ops123");

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // set the data source object
        jdbcTemplate.setDataSource(dataSource);
        int row = jdbcTemplate.update("insert into account values(?,?)", "tom", 5000);
        System.out.println(row);
    }

    @Test
    public void test2() {
        ApplicationContext app = new ClassPathXmlApplicationContext("spring-mvc.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);
        int row = jdbcTemplate.update("insert into account values(?,?)", "rose", 223);
        System.out.println(row);
    }


}
