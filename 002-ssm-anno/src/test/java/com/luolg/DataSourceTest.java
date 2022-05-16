package com.luolg;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.luolg.config.SpringConfiguration;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.ResourceBundle;

public class DataSourceTest {
    // test create the c3p0 data source
//    @Test
    public void test1() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass("com.mysql.jdbc.Driver");
        comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        comboPooledDataSource.setUser("root");
        comboPooledDataSource.setPassword("ops123");
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //    @Test
    public void test2() throws Exception {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("ops123");
        DruidPooledConnection connection = druidDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //    @Test
    // test the c3p0 database source with properties
    public void test3() throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        String driver = resourceBundle.getString("jdbc.driver");
        String url = resourceBundle.getString("jdbc.url");
        String username = resourceBundle.getString("jdbc.username");
        String password = resourceBundle.getString("jdbc.password");

        // create datasource with parameter
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);

        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    //    @Test
    // test container generate the datasource
    public void test4() throws Exception {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = app.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test5() throws Exception {
        ApplicationContext app = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        DataSource datasource = app.getBean(DataSource.class);
        Connection connection = datasource.getConnection();
        System.out.println(connection);
        connection.close();

    }
}
