package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;

import java.util.List;

/**
 * daiyu
 * 2021/1/10
 */
public interface UmsAdminService {
    /**
     * 注册功能
     *
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 登录返回token
     *
     * @param username
     * @param password
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限列表
     *
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
