package com.yb.springboot.annotation;

import com.yb.springboot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: yangb
 * @Description: @EnableHelloWorld {@link ImportSelector} 实现
 * 可以增加分支和 条件判断
 */
public class HelloWorldImportSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{HelloWorldConfiguration.class.getName()};
	}
}
