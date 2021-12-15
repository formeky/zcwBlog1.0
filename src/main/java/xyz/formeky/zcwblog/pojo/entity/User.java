package xyz.formeky.zcwblog.pojo.entity;

import lombok.Data;

/**
 * @author zcw
 */
@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    /**
    * 昵称
    */
    private String nickname;

    /**
    * 软删除
    */
    private Boolean del;
}