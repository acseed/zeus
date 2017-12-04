package cn.acseed.dao.test;

import cn.acseed.zeus.common.domain.UserType;
import cn.acseed.zeus.dao.UserDao;
import cn.acseed.zeus.dao.po.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by caohongchen on 16-12-17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:zeus-dao.xml"})
public class UserDaoTest {
    @Resource
    private UserDao userDao;

    @Test
    public void testAddUser() {
        User user = new User();
        user.setUserName("test");
        user.setPassword("test");
        user.setUserType(UserType.NOMAL);
        user.setLocked(false);
        user.setCreateTime(new Date());
        user.setCredit(0);
        userDao.addUser(user);
//        user = userDao.selectByUserId(1);
//        System.out.println(user);
    }
}
