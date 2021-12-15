package xyz.formeky.zcwblog.mapper;

import org.springframework.stereotype.Repository;
import xyz.formeky.zcwblog.pojo.entity.User;

/**
 * @author zcw
 */
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectUserByUsername(String username);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}