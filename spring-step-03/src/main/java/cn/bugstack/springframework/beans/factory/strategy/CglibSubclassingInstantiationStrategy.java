package cn.bugstack.springframework.beans.factory.strategy;

import cn.bugstack.springframework.beans.BeansException;
import cn.bugstack.springframework.beans.factory.InstantiationStrategy;
import cn.bugstack.springframework.beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @description  Cglib 子类实例化策略接口
 * 作者：DerekYRC <a href="https://github.com/DerekYRC/mini-spring">...</a>
 * @author naixixu
 * @date 2022/03/08
 *
 *
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args)
            throws BeansException {
        // 1. 创建 Enhancer 对象
        Enhancer enhancer = new Enhancer();

        // 2. 设置增强类型
        enhancer.setSuperclass(beanDefinition.getBeanClass());

        // 3. 设置回调
        enhancer.setCallback(new NoOp() {
            // 注意这里hashCode和equals必须成对出现，否则会报错
            @Override
            public int hashCode() {
                return super.hashCode();
            }
            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        });

        // 4. 如果构造函数无参，进行无参构造增强
        if (null == ctor) {
            return enhancer.create();
        }
        
        // 5. 如果构造函数有参，进行有参构造增强
        return enhancer.create(ctor.getParameterTypes(), args);
    }

}
