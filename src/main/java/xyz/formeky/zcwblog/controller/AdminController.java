package xyz.formeky.zcwblog.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.formeky.zcwblog.pojo.entity.User;
import xyz.formeky.zcwblog.pojo.enums.StatusEnum;
import xyz.formeky.zcwblog.pojo.vo.BaseVo;
import xyz.formeky.zcwblog.service.AdminService;

/**
 * @author zcw
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public BaseVo login(@RequestBody User user){
        User admin = adminService.getUser(user.getUsername());
        if (admin!=null&&admin.getPassword().equals(SaSecureUtil.md5(user.getPassword()))) {
            StpUtil.login(admin.getId());
            return new BaseVo(StatusEnum.SUCCESS.getCode(),admin.getId(),"登陆成功" );
        }
        return new BaseVo(StatusEnum.PASSWORD_WRONG.getCode(), "用户名或者密码错误" );
    }

    @GetMapping("logout")
    public BaseVo logout(){
        StpUtil.logout();
        return new BaseVo(StatusEnum.SUCCESS.getCode(), "用户已下线" );
    }
}
