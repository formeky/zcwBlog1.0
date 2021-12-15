package xyz.formeky.zcwblog.mapper;

import org.springframework.stereotype.Repository;
import xyz.formeky.zcwblog.pojo.entity.Comment;

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
}