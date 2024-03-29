package xyz.formeky.zcwblog.mapper;

import org.springframework.stereotype.Repository;
import xyz.formeky.zcwblog.pojo.entity.Tag;

import java.util.List;

/**
 * @author zcw
 */
@Repository
public interface TagMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Tag record);

    int insertSelective(Tag record);

    Tag selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Tag record);

    int updateByPrimaryKey(Tag record);

    List<Tag> listTag();
}