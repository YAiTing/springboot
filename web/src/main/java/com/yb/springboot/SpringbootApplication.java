package com.yb.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * https://blog.csdn.net/MyHerux/article/details/80667524
 * Prometheus 会按照配置的时间周期去 pull暴露的端点（/actuator/prometheus）中的指标数据
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.yb.springboot.web.servlet")
public class SpringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootApplication.class, args);
		context.refresh();
		context.close();
	}
}
