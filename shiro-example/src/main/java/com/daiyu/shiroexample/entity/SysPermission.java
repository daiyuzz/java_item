package com.daiyu.shiroexample.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * created by dyx on 2021/7/20.
 */
@Entity
@Data
public class SysPermission {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String description;

    private String url;

    @JsonIgnoreProperties(value = {"permission"}) //指定忽略类中的permission字段
    @ManyToMany
    @JoinTable(name = "SysRolePermission",joinColumns = {@JoinColumn(name = "permissionId")},inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roles;
}
