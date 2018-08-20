package com.yb.invoice.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.io.Serializable;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class RequestBody<T> implements Serializable{

	@XStreamAlias("input")
	private T input;

	public T getInput() {
		return input;
	}

	public void setInput(T input) {
		this.input = input;
	}
}
