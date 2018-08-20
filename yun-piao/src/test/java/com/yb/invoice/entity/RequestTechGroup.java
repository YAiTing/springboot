package com.yb.invoice.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@XStreamAlias("group")
public class RequestTechGroup extends BaseGroup {

	private String nsrsbh;

	public RequestTechGroup(String nsrsbh, int xh) {
		super(xh);
		this.nsrsbh = nsrsbh;
	}

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

}
