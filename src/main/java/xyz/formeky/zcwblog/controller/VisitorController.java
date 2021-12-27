package xyz.formeky.zcwblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.formeky.zcwblog.pojo.enums.StatusEnum;
import xyz.formeky.zcwblog.pojo.query.CommentQuery;
import xyz.formeky.zcwblog.pojo.query.EssayQuery;
import xyz.formeky.zcwblog.pojo.vo.BaseVo;
import xyz.formeky.zcwblog.service.CommentService;
import xyz.formeky.zcwblog.service.EssayService;

/**
 * @author zcw
 */
@RestController
public class VisitorController {

    @Autowired
    private EssayService essayService;
    @Autowired
    private CommentService commentService;

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
        return new BaseVo(StatusEnum.SUCCESS.getCode(),commentService.listComment(query),"文章详情");
    }
}
