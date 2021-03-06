package com.yb.springboot.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: yangb
 * @Description:
 * {@link EnableAutoConfiguration} 引导类
 * {@link EnableHelloWorldBootstrap}
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);
		String helloWorld = context.getBean("helloWorld", String.class);

		System.out.println("helloWorld Bean : " + helloWorld);

		context.close();
	}
}
