package com.yb.springboot.configuration;

import com.yb.springboot.annotation.EnableHelloWorld;
import com.yb.springboot.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yangb
 * @Description:
 */
@Configuration
@EnableHelloWorld
@ConditionalOnSystemProperty(name="user.name", value="Administrator")
public class HelloWorldAutoConfiguration {
}
