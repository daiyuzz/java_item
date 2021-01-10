package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.UmsAdmin;
import com.macro.mall.tiny.mbg.model.UmsPermission;
import com.macro.mall.tiny.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.invoke.ConstantCallSite;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * daiyu
 * 2021/1/10
 */

@RestController
@Api(tags = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(
            @RequestBody UmsAdmin umsAdminParam, BindingResult result
    ) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return CommonResult.failed();
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation(value = "登录以后返回token")
    @PostMapping("/login")
    public CommonResult login(
            @RequestBody UmsAdmin umsAdminParam, BindingResult result
    ) {
        String token = adminService.login(umsAdminParam.getUsername(), umsAdminParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation("获取用户所有权限（包括+-权限）")
    @GetMapping("/permission/{adminId}")
    public CommonResult<List<UmsPermission>> getPermissionList(
            @PathVariable Long adminId
    ){
        List<UmsPermission> permissionList = adminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }


}
