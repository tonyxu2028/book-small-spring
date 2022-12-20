package cn.bugstack.springframework.test.bean;

/**
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class UserService {

    private String uId;
    private String company;
    private String location;
    private IUserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }
    @SuppressWarnings("unused")
    public String getuId() {
        return uId;
    }
    @SuppressWarnings("unused")
    public void setuId(String uId) {
        this.uId = uId;
    }
    @SuppressWarnings("unused")
    public String getCompany() {
        return company;
    }
    @SuppressWarnings("unused")
    public void setCompany(String company) {
        this.company = company;
    }
    @SuppressWarnings("unused")
    public String getLocation() {
        return location;
    }
    @SuppressWarnings("unused")
    public void setLocation(String location) {
        this.location = location;
    }
    @SuppressWarnings("unused")
    public IUserDao getUserDao() {
        return userDao;
    }
    @SuppressWarnings("unused")
    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
