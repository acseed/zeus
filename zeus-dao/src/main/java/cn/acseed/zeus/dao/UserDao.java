package cn.acseed.zeus.dao;

import cn.acseed.zeus.dao.po.User;
import org.springframework.stereotype.Repository;

/**
 * Created by caohongchen on 16-12-17.
 */
@Repository
public interface UserDao {
    int addUser(User user);
    User selectByUserId(int userId);
}
