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
public class UserInfo {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String userName;

    private String name;

    private String password;

    private String salt;

    @JsonIgnoreProperties(value = {"userInfos"})
    @ManyToMany(fetch = FetchType.EAGER) // 立即从数据库开始加载数据
    @JoinTable(name = "SysUserRole",joinColumns = @JoinColumn(name = "uid"),inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private List<SysRole> roles;






}
