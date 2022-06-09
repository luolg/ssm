package com.luolg.mapper;

import com.luolg.domain.SysUser;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysUserMapper {

    @Select("select * from sys_user")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(id = true, column = "username", property = "username"),
            @Result(id = true, column = "password", property = "password"),

            @Result(
                    property = "sysRoleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.luolg.mapper.SysRoleMapper.findSysRoleByUid")
            )
    })
    public List<SysUser> findUserAndRoleAll();
}
