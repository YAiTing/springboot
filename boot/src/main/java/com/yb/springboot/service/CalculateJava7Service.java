package com.yb.springboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@Profile("java7")
@Service
public class CalculateJava7Service implements CalculateService {

	@Override
	public Integer sum(Integer... values) {
		System.out.println(" JAVA 7 foreach Calculate");
		int sum = 0;
		for (int i = 0; i < values.length; i++) {
			sum += values[i];
		}
		return sum;
	}
}
