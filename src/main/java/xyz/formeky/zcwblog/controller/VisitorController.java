package xyz.formeky.zcwblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.formeky.zcwblog.pojo.enums.StatusEnum;
import xyz.formeky.zcwblog.pojo.query.CommentQuery;
import xyz.formeky.zcwblog.pojo.query.EssayQuery;
import xyz.formeky.zcwblog.pojo.vo.BaseVo;
import xyz.formeky.zcwblog.service.CommentService;
import xyz.formeky.zcwblog.service.EssayService;
import xyz.formeky.zcwblog.service.TagService;

/**
 * @author zcw
 */
@RestController
public class VisitorController {

    @Autowired
    private EssayService essayService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private TagService tagService;
    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("essayList")
    public BaseVo essayList(EssayQuery query){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),essayService.listEssay(query),"文章列表" );
    }

    @GetMapping("essay")
    public BaseVo essay(Integer essayId){
        return new BaseVo(StatusEnum.SUCCESS.getCode(), essayService.getEssay(essayId),"文章详情");
    }

    @GetMapping("comment")
    public BaseVo comment(CommentQuery query){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),commentService.listComment(query),"评论详情");
    }

    @GetMapping("tag")
    public BaseVo tag(){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),tagService.listTag(),"tag");
    }

    @GetMapping("archive")
    public BaseVo archive(){
        return new BaseVo(StatusEnum.SUCCESS.getCode(),essayService.archive(),"归档" );
    }

}
