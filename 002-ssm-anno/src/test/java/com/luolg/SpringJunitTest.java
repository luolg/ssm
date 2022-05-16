package com.luolg;

import com.luolg.config.SpringConfiguration;
import com.luolg.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    // not working
//    @Test
    public void test1() {
        userService.save();
    }

    // not working
    //    @Test
    public void test2() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();

    }
}
