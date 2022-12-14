package cn.bugstack.springframework.beans;

/**
 * @Description: BeansException
 * @author naixixu
 * @date 2022/3/7
 */
public class BeansException extends RuntimeException{

    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
