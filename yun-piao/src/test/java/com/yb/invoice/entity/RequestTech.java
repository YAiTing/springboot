package com.yb.invoice.entity;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import java.util.List;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class RequestTech extends RequestInfo {

	private String sqm = "授权码";

	private String czlx = "操作类型";

	@XStreamAlias("shsh")
	private List<RequestTechGroup> list = Lists.newArrayList(new RequestTechGroup("a", 1), new RequestTechGroup("b" ,2));

	public String getSqm() {
		return sqm;
	}

	public void setSqm(String sqm) {
		this.sqm = sqm;
	}

	public String getCzlx() {
		return czlx;
	}

	public void setCzlx(String czlx) {
		this.czlx = czlx;
	}

	public List<RequestTechGroup> getList() {
		return list;
	}

	public void setList(List<RequestTechGroup> list) {
		this.list = list;
	}

	@Override
	public InvoiceBusinessTypeEnum getId() {
		return InvoiceBusinessTypeEnum.SBBD;
	}
}
