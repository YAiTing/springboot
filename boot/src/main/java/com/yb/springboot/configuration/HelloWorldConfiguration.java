package com.yb.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: yangb
 * @Description: hello word 配置
 */
@Configuration
public class HelloWorldConfiguration {

	//方法名就是bean的名字
	@Bean
	public String helloWorld() {
		return "Hello, World";
	}
}
