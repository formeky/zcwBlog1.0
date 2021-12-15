package xyz.formeky.zcwblog.service;

import xyz.formeky.zcwblog.pojo.entity.User;

/**
 * @author zcw
 */
public interface AdminService {

    public User getUser(String username);

    public Boolean deleteUser(Integer userId);

    public Boolean updateUser(User user);

}
