package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * daiyu
 * 2021/1/9
 */
@RestController
@Api(tags = "会员登录注册")
@RequestMapping("/sso")
public class UmsMemberController {

    @Autowired
    private UmsMemberService memberService;


    @ApiOperation(value = "获取验证码")
    @GetMapping(value = "/getAuthCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", paramType = "query")
    })
    public CommonResult getAuthCode(
            @RequestParam(value = "telephone") String telephone
    ) {
        return memberService.generateAuthCode(telephone);
    }

    @ApiOperation(value = "判断验证码是否正确")
    @PostMapping(value = "/verifyAuthCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "telephone", value = "手机号", paramType = "query"),
            @ApiImplicitParam(name = "authCode", value = "验证码", paramType = "query")
    })
    public CommonResult updatePassword(
            @RequestParam(value = "telephone") String telephone,
            @RequestParam String authCode
    ) {
        return memberService.verifyAuthCode(telephone, authCode);
    }
}
