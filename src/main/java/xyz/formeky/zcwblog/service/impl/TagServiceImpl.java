package xyz.formeky.zcwblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.formeky.zcwblog.mapper.TagMapper;
import xyz.formeky.zcwblog.pojo.entity.Tag;
import xyz.formeky.zcwblog.service.TagService;

import java.util.List;

/**
 * @author zcw
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> listTag() {
        return tagMapper.listTag();
    }
}
