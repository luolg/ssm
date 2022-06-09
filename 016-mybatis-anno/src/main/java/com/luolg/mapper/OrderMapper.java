package com.luolg.mapper;

import com.luolg.domain.Order;
import com.luolg.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    @Select("select * from orders where uid=#{id}")
    public List<Order> findByUid(int id);

    @Select("select *,o.id oid from orders o, user u where o.uid=u.id")
    @Results({
            @Result(column = "oid", property = "id"),
            @Result(column = "ordertime", property = "ordertime"),
            @Result(column = "total", property = "total"),
            @Result(
                    property = "user",
                    column = "uid",
                    javaType = User.class,
                    one = @One(select = "com.luolg.mapper.UserMapper.findById")
            )
    })
    public List<Order> findALl();


//    @Select("select *,o.id oid from orders o, user u where o.uid=u.id")
//    @Results({
//            @Result(column = "oid", property = "id"),
//            @Result(column = "ordertime", property = "ordertime"),
//            @Result(column = "total", property = "total"),
//            @Result(column = "uid", property = "user.id"),
//            @Result(column = "username", property = "user.username"),
//            @Result(column = "password", property = "user.password"),
//    })
//    public List<Order> findALl();
}
