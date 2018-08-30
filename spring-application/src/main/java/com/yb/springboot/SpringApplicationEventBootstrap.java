package com.yb.springboot;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: yangb
 * @Description:
 */
public class SpringApplicationEventBootstrap {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.addApplicationListener(event -> {
			System.out.println("监听到事件：" + event);
		});

		context.refresh();

		context.publishEvent("HelloWorld");

		context.publishEvent(new ApplicationEvent("ApplicationEvent") {

		});

		context.close();
	}
}
