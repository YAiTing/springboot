package com.yb.pecs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangb
 * @Description:
 */
public class PecsDemo {

	public static void main(String[] args) {
		List<? super F> list = new ArrayList<>();
		list.add(new Person());
		list.add(new P());
		list.add(new A1());
		list.stream().forEach(System.out::println);
	}

	static private void print(List<? extends F> list) {
		list.stream().forEach(System.out::println);
	}

	private static class F {

	}

	private static class Person extends F {

	}

	private static class Animal extends F {

	}

	private static class P extends Person {

	}

	private static class P1 extends Person {

	}

	private static class A extends Animal {

	}

	private static class A1 extends Animal {

	}
}
