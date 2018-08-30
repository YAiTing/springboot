package com.yb.springboot.context;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class AfterHelloWorldApplicationContextInitializer<C extends ConfigurableApplicationContext>
		implements ApplicationContextInitializer<C>, Ordered {

	@Override
	public void initialize(C applicationContext) {
		System.out.println("AfterHelloWorldApplicationContextInitializer.id =" + applicationContext.getId());
	}

	@Override
	public int getOrder() {
		return Ordered.LOWEST_PRECEDENCE;
	}
}
