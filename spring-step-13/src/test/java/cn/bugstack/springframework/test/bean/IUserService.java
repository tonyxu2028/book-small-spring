package cn.bugstack.springframework.test.bean;

public interface IUserService {

    String queryUserInfo();

    @SuppressWarnings("unused")
    String register(String userName);
}
