package xyz.formeky.zcwblog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import xyz.formeky.zcwblog.mapper.UserMapper;
import xyz.formeky.zcwblog.pojo.entity.User;
import xyz.formeky.zcwblog.service.AdminService;

/**
 * @author ASUS
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(String username) {
        return userMapper.selectUserByUsername(username);
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean deleteUser(Integer userId) {
        if (userMapper.selectByPrimaryKey(userId)==null) {
            return false;
        }
        userMapper.deleteByPrimaryKey(userId);
        return true;
    }

    @Override
    @CacheEvict(allEntries = true)
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Boolean updateUser(User user) {
        if (userMapper.selectByPrimaryKey(user.getId())==null) {
            return false;
        }
        userMapper.updateByPrimaryKeySelective(user);
        return true;
    }
}
