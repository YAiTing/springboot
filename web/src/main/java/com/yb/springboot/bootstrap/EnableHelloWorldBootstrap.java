package com.yb.springboot.bootstrap;

import com.yb.springboot.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: yangb
 * @Description: @enableXXX 自动装配
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);
		String helloWorld = context.getBean("helloWorld", String.class);

		System.out.println("helloWorld Bean : " + helloWorld);

		context.close();
	}
}
