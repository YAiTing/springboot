package com.yb.springboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@Profile("java8")
@Service
public class CalculateJava8Service implements CalculateService {

	@Override
	public Integer sum(Integer... values) {
		System.out.println(" JAVA 8 lambda Calculate");
		int sum = Stream.of(values).reduce(0, Integer::sum);
		return sum;
	}
}
