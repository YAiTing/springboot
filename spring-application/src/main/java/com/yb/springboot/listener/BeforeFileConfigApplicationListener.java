package com.yb.springboot.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @Author: yangb
 * @Description: before {@link ConfigFileApplicationListener}
 */
public class BeforeFileConfigApplicationListener implements SmartApplicationListener, Ordered {

	@Override
	public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
		return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
				|| ApplicationPreparedEvent.class.isAssignableFrom(eventType);
	}

	@Override
	public boolean supportsSourceType(Class<?> aClass) {
		return true;
	}

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof ApplicationEnvironmentPreparedEvent) {
			ApplicationEnvironmentPreparedEvent aep = (ApplicationEnvironmentPreparedEvent) event;
			ConfigurableEnvironment environment = aep.getEnvironment();
			System.out.println("environment.getProperty:" + environment.getProperty("spring.application.name"));
		}
		if (event instanceof ApplicationPreparedEvent) {

		}
	}

	@Override
	public int getOrder() {
		return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
	}
}
