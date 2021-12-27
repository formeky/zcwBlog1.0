package xyz.formeky.zcwblog.mapper;

import org.springframework.stereotype.Repository;
import xyz.formeky.zcwblog.pojo.entity.Comment;
import xyz.formeky.zcwblog.pojo.query.CommentQuery;
import xyz.formeky.zcwblog.pojo.query.PageQuery;

import java.util.List;

/**
 * @author zcw
 */
@Repository
public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    List<Comment> listComment(CommentQuery query);
}