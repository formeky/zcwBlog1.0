package xyz.formeky.zcwblog.mapper;

import org.springframework.stereotype.Repository;
import xyz.formeky.zcwblog.pojo.entity.Essay;
import xyz.formeky.zcwblog.pojo.query.EssayQuery;

import java.util.List;

/**
 * @author zcw
 */
@Repository
public interface EssayMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Essay record);

    int insertSelective(Essay record);

    Essay selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Essay record);

    int updateByPrimaryKey(Essay record);

    List<Essay> listEssay(EssayQuery query);

    List<Essay> archive();
}