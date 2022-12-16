package cn.bugstack.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: UserDao
 * 1)注解方式 : 加载 init-method(initDataMethod) 和 destroy-method(destroyDataMethod)
 */
public class UserDao {

    private static final Map<String, String> hashMap = new HashMap<>();

    @SuppressWarnings("unused")
    public void initDataMethod(){
        System.out.println("执行UserDao.initDataMethod ：init-method");
        hashMap.put("10001", "小傅哥");
        hashMap.put("10002", "八杯水");
        hashMap.put("10003", "阿毛");
    }

    @SuppressWarnings("unused")
    public void destroyDataMethod(){
        System.out.println("执行UserDao.destroyDataMethod ：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}
