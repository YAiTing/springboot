package com.yb.springboot.bootstrap;

import com.yb.springboot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author: yangb
 * @Description: 基于profile 配置方式实现自动装配
 */
@SpringBootApplication(scanBasePackages = "com.yb.springboot.service")
public class CalculateServiceBootstrap {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootstrap.class)
				.web(WebApplicationType.NONE)
				// java7 or java8
				.profiles("java8")
				.run(args);
		CalculateService calculateService = context.getBean(CalculateService.class);

		System.out.println("calculateService sum : " + calculateService.sum(0,1,2,3,4,5,6,7,8,9,10));

		context.close();
	}
}
