package cn.jtruan.mallssm.controller;

import cn.jtruan.mallssm.common.api.CommonResult;
import cn.jtruan.mallssm.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/sso")
@Api(tags = "UmsMemeberController", description = "会员登陆注册管理")
public class UmsMemberController {
    @Autowired
    private UmsMemberService umsMemberService;

    @RequestMapping(value = "/getAuthCode", method = RequestMethod.GET)
    @ApiOperation(value = "获取验证码")
    @ResponseBody
    public CommonResult getAuthCode(@RequestParam String telephone){
        return umsMemberService.generateAuthCode(telephone);
    }

    @RequestMapping(value = "/verifyAuthCode", method = RequestMethod.GET)
    @ApiOperation(value = "验证验证码")
    @ResponseBody
    public CommonResult verifyAuthCode(@RequestParam String telephone, @RequestParam String authCode){
        return umsMemberService.verifyAuthCode(telephone, authCode);
    }
}
