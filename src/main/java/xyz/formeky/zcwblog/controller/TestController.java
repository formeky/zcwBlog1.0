package xyz.formeky.zcwblog.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ASUS
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping("login")
    public void login(){
        StpUtil.login("123");
        System.out.println(StpUtil.getTokenInfo());
        StpUtil.checkLogin();
        System.out.println(StpUtil.getTokenInfo());
    }

    @GetMapping("test")
    public void test(){
        StpUtil.checkLogin();
        System.out.println(StpUtil.isLogin());
    }
}
