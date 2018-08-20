package com.yb.invoice.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@XStreamAlias("business")
public class BusinessReturnInvoice<T extends ResponseInfo> implements Serializable{

	@XStreamAsAttribute
	private String id;

	@XStreamAlias("body")
	private T body;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}
}
