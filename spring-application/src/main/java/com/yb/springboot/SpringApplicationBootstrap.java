package com.yb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: yangb
 * 推断引导类 SpringApplication 里的 deduceMainApplicationClass
 */

public class SpringApplicationBootstrap {

	public static void main(String[] args) {
//		SpringApplication.run(SpringApplicationConfiguration.class, args);

		SpringApplication springApplication = new SpringApplication();
		Set<String> sources = new HashSet<>();
		sources.add(SpringApplicationConfiguration.class.getName());
		springApplication.setSources(sources);
		springApplication.setWebApplicationType(WebApplicationType.NONE);
		ConfigurableApplicationContext context = springApplication.run(args);
//		System.out.println("Bean: " + context.getBean(SpringApplicationConfiguration.class));
	}

	@SpringBootApplication
	public static class SpringApplicationConfiguration {

	}
}
