package com.yb.springboot.annotation;

import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

/**
 * @Author: yangb
 * @Description: 模式注解（“派生性”，层次性）,底层都是 @Component 元注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Repository
public @interface FirstLevelRepository {
}
