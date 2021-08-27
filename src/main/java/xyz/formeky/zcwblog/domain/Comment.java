package xyz.formeky.zcwblog.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author zcw
 */
@Data
public class Comment {
    private Integer id;

    private String content;

    private Date createTime;

    /**
    * 文章id
    */
    private Integer essayId;

    /**
    * 软删除
    */
    private Boolean del;
}