package cn.bugstack.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 *
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * {@code @description} 模拟用户DAO类
 * @date 2022/03/09
 *
 *
 */
public class UserDao {

    // 模拟数据库
    private static final Map<String, String> hashMap = new HashMap<>();

    // 模拟数据库存储
    static {
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    /**
     * 根据用户ID查询用户名称
     * @param uId           用户ID
     * @return              用户名称
     */
    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
