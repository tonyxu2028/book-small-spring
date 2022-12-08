package cn.bugstack.springframework.test.bean;

public interface IUserService {

    String queryUserInfo();

    /**
     * 注册用户
     * @param userName          用户名
     * @return                  返回注册成功的用户信息
     */
    @SuppressWarnings("unused")
    String register(String userName);
}
