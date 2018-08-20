package com.yb.springboot.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Import(HelloWorldConfiguration.class) //基于注解驱动实现
@Import(HelloWorldImportSelector.class) //基于接口驱动实现(编程方式),比较有弹性，可以自定义返回多个 config 类
public @interface EnableHelloWorld {
}
