package xyz.formeky.zcwblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.formeky.zcwblog.mapper.CommentMapper;
import xyz.formeky.zcwblog.pojo.entity.Comment;
import xyz.formeky.zcwblog.pojo.query.CommentQuery;
import xyz.formeky.zcwblog.service.CommentService;

import java.util.List;

/**
 * @author zcw
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper mapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public boolean save(Comment comment) {
        return mapper.insert(comment)==1;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public boolean delete(Integer essayId) {
        return mapper.deleteByPrimaryKey(essayId)==1;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, propagation = Propagation.REQUIRED)
    public boolean update(Comment comment) {
        return mapper.updateByPrimaryKeySelective(comment)==1;
    }

    @Override
    @CacheEvict(allEntries = false)
    public List<Comment> listComment(CommentQuery query) {
        return mapper.listComment(query);
    }
}
