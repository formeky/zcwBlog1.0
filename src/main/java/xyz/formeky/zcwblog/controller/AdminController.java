package xyz.formeky.zcwblog.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.formeky.zcwblog.pojo.entity.Essay;
import xyz.formeky.zcwblog.pojo.entity.User;
import xyz.formeky.zcwblog.pojo.enums.StatusEnum;
import xyz.formeky.zcwblog.pojo.query.EssayQuery;
import xyz.formeky.zcwblog.pojo.query.PageQuery;
import xyz.formeky.zcwblog.pojo.vo.BaseVo;
import xyz.formeky.zcwblog.service.AdminService;
import xyz.formeky.zcwblog.service.EssayService;

/**
 * @author zcw
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private EssayService essayService;

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

    @GetMapping("essayList")
    public BaseVo essayList(EssayQuery query){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),essayService.listEssay(query),"文章列表" );
    }

    @PostMapping("essay")
    public BaseVo save(@RequestBody Essay essay){
        Boolean re = essayService.saveEssay(essay);
        if (re){
            return new BaseVo(StatusEnum.SUCCESS.getCode(),"添加成功" );
        }else{
            return new BaseVo(StatusEnum.ERROR.getCode() ,"添加失败" );
        }

    }

    @PutMapping("essay")
    public BaseVo update(@RequestBody Essay essay){
        Boolean re = essayService.update(essay);
        if (re){
            return new BaseVo(StatusEnum.SUCCESS.getCode(),"修改成功" );
        }else{
            return new BaseVo(StatusEnum.ERROR.getCode() ,"修改失败" );
        }
    }

    @DeleteMapping("essay")
    public BaseVo delete(Integer essayId){
        Boolean re = essayService.removeEssay(essayId);
        if (re){
            return new BaseVo(StatusEnum.SUCCESS.getCode(),"删除成功" );
        }else{
            return new BaseVo(StatusEnum.ERROR.getCode() ,"删除失败" );
        }
    }

    @GetMapping("essay")
    public BaseVo essay(Integer essayId){
        return new BaseVo(StatusEnum.SUCCESS.getCode(), essayService.getEssay(essayId),"文章详情");
    }
}
