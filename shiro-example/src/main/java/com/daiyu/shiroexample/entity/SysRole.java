package com.daiyu.shiroexample.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.DataAmount;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * created by dyx on 2021/7/20.
 */
@Entity
@Data
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;

    private String name; //角色名，如admin，user

    private String description;

    // 角色-权限关系； 多对多
    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SysRolePermission",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "permissionId")})
    private List<SysPermission> permissions;

    // 用户-角色关系； 多对多
    @JsonIgnoreProperties(value = {"roles"})
    @ManyToMany
    @JoinTable(name = "SysUserRole",joinColumns = {@JoinColumn(name = "roleId")},inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<UserInfo> userInfos;

}
