package xyz.formeky.zcwblog.domain;

import java.util.Date;
import lombok.Data;

/**
 * @author zcw
 */
@Data
public class Essay {
    private Integer id;

    private String title;

    /**
    * 摘要
    */
    private String briefIntroduction;

    /**
    * 内容
    */
    private String content;

    /**
    * 作者
    */
    private String author;

    private String tagIds;

    private String classifyIds;

    /**
    * 最近一次编辑的日期
    */
    private Date date;

    private Boolean del;
}