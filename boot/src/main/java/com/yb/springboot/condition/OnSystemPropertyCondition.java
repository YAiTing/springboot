package com.yb.springboot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class OnSystemPropertyCondition implements Condition {

	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
		String name = String.valueOf(attributes.get("name"));
		String value = String.valueOf(attributes.get("value"));
		String systemValue = System.getProperty(name);
		System.out.println(value);
		System.out.println(systemValue);
		return value.equals(systemValue);
	}

}
