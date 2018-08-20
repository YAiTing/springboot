package com.yb.springboot.bootstrap;

import com.yb.springboot.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @Author: yangb
 * @Description:  自定义condition
 * @Date: Created in 11:02 2017/12/8
 */
public class ConditionalOnSystemPropertyBootstrap {

	@Bean
	@ConditionalOnSystemProperty(name="user.name", value="Administrator")
	public String helloWorld() {
		return "Hello world yb";
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
				.web(WebApplicationType.NONE)
				.run(args);
		String helloWorld = context.getBean("helloWorld", String.class);

		System.out.println("helloWorld Bean : " + helloWorld);

		context.close();
	}
}
