package cn.bugstack.springframework.test.bean;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.BeanClassLoaderAware;
import cn.bugstack.springframework.beans.factory.BeanFactory;
import cn.bugstack.springframework.beans.factory.BeanFactoryAware;
import cn.bugstack.springframework.beans.factory.BeanNameAware;
import cn.bugstack.springframework.context.ApplicationContext;
import cn.bugstack.springframework.context.ApplicationContextAware;

/**
 * 博客：<a href="https://bugstack.cn">...</a> - 沉淀、分享、成长，让自己和他人都能有所收获！
 * 公众号：bugstack虫洞栈
 * Create by 小傅哥(fustack)
 */
public class UserService implements BeanNameAware, BeanFactoryAware,
        BeanClassLoaderAware, ApplicationContextAware{

    private String uId;
    private String company;
    private String location;

    private UserDao userDao;

    // *************************** Aware ***************************

    private BeanFactory beanFactory;

    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }
    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
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
    public UserDao getUserDao() {
        return userDao;
    }

    @SuppressWarnings("unused")
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
