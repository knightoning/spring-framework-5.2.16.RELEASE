package com.kt.cn.v2.day01;

import org.junit.Test;
import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hujie
 */
public class MyCircleTest {

    /**
     * spring 循环依赖=========org.springframework.beans.factory.BeanCreationException:
     * Error creating bean with name 'testA' defined in class path resource [v2/circle/test.xml]:
     * Cannot resolve reference to bean 'testB' while setting constructor argument; nested exception
     * is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'testB'
     * defined in class path resource [v2/circle/test.xml]: Cannot resolve reference to bean 'testC'
     * while setting constructor argument; nested exception is org.springframework.beans.factory.
     * BeanCreationException: Error creating bean with name 'testC' defined in class path resource
     * [v2/circle/test.xml]: Cannot resolve reference to bean 'testA' while setting constructor argument;
     * nested exception is org.springframework.beans.factory.BeanCurrentlyInCreationException:
     * Error creating bean with name 'testA': Requested bean is currently in creation: Is there an unresolvable
     * circular reference?
     * @throws Throwable
     */
    @Test(expected = BeanCurrentlyInCreationException.class)
    public void testCircleByConstructor() throws Throwable {

        try {
            new ClassPathXmlApplicationContext("v2/circle/test.xml");
        }catch (Exception e){
            Throwable throwable = e.getCause().getCause().getCause();
            System.out.println("spring 循环依赖========="+throwable);
            throw throwable;
        }
    }
}
