package xyz.formeky.zcwblog.service;

import xyz.formeky.zcwblog.pojo.entity.Comment;
import xyz.formeky.zcwblog.pojo.query.CommentQuery;

import java.util.List;

/**
 * @author zcw
 */
public interface CommentService {
    public boolean save(Comment comment);

    public boolean delete(Integer essayId);

    public boolean update(Comment comment);

    public List<Comment> listComment(CommentQuery query);
}
