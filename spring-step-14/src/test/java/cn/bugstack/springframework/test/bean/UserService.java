package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.beans.factory.annotation.Autowired;
import cn.bugstack.springframework.beans.factory.annotation.Value;
import cn.bugstack.springframework.stereotype.Component;

import java.util.Random;

@Component("userService")
public class UserService implements IUserService {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userDao.queryUserName("10001") + "，" + token;
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @SuppressWarnings("unused")
    public void setToken(String token) {
        this.token = token;
    }

    @SuppressWarnings("unused")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

}
