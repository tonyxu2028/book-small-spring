package cn.bugstack.springframework.test.bean;

/**
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * {@code @description} 模拟含有入参构造函数的用户 Bean 对象
 * @date 2022/03/07
 *
 *
 */
public class UserService {

    private final String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        return "" + name;
    }

}
