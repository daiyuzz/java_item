package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * daiyu
 * 2021/1/9
 */
@RestController
@Api(tags = "会员登录注册")
@RequestMapping("/sso")
public class UmsMemberController {


    @ApiOperation(value = "获取验证码")
    @GetMapping(value = "/getAuthCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", paramType = "query")
    })
    public CommonResult getAuthCode(
            @RequestParam(value = "telephone") String telephone
    ) {
        return null;
    }
}
