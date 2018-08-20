package com.yb.invoice.entity;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class BaseGroup {

	public BaseGroup(int xh) {
		this.xh = xh;
	}

	@XStreamAsAttribute
	private int xh;

	public int getXh() {
		return xh;
	}

	public void setXh(int xh) {
		this.xh = xh;
	}
}
