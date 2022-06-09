package com.luolg.mapper;

import com.luolg.domain.SysRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysRoleMapper {

    @Select("select * from sys_user_role s, sys_role r where s.roleId=r.id and s.userId=#{uid}")
    public List<SysRole> findSysRoleByUid(int uid);
}
