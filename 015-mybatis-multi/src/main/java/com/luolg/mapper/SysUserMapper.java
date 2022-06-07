package com.luolg.mapper;

import com.luolg.domain.SysUser;

import java.util.List;

public interface SysUserMapper {
    public List<SysUser> findUserAndRole();
}
