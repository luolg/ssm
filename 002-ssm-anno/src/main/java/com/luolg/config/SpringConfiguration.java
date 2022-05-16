package com.luolg.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

// mark this class as spring core config class
@Configuration

//<context:component-scan base-package="com.luolg"/>
@ComponentScan("com.luolg")
//<context:property-placeholder location="classpath:jdbc.properties"/>

//<import resource=""/>
@Import({DataSourceConfiguration.class,})
public class SpringConfiguration {

}
