package cn.bugstack.springframework.beans.factory;

import cn.bugstack.springframework.beans.BeansException;

/**
 *
 * @author naixixu
 * @description Defines a factory which can return an Object instance (possibly shared or independent) when invoked.
 * @date 2022/3/16
 *  /CodeDesignTutorials
 *
 */
public interface ObjectFactory<T> {

    /**
     * Return an instance (possibly shared or independent) of the object managed by this factory.
     * @return                      the resulting instance
     * @throws BeansException       in case of creation errors
     */
    T getObject() throws BeansException;

}
