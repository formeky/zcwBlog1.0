package xyz.formeky.zcwblog.controller;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zcw
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @PostMapping("login")
    public void testToken(){
        StpUtil.login("123");
        System.out.println(StpUtil.getTokenInfo());
        StpUtil.checkLogin();
        System.out.println(StpUtil.getTokenInfo());
    }

    @GetMapping("test")
    public void test(){
        System.out.println(StpUtil.isLogin());
    }
}
