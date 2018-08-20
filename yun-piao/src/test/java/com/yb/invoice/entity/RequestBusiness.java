package com.yb.invoice.entity;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

import java.io.Serializable;

/**
 * @Author: yangb
 * @Description:
 */
@XStreamAlias("business")
public class RequestBusiness<T extends RequestInfo> implements Serializable {

	@XStreamAsAttribute
	private InvoiceBusinessTypeEnum id;

	@XStreamAlias("body")
	private RequestBody<T> body = new RequestBody();

	public InvoiceBusinessTypeEnum getId() {
		return id;
	}

	public void setId(InvoiceBusinessTypeEnum id) {
		this.id = id;
	}

	public RequestBody<T> getBody() {
		return body;
	}

	public void setBody(RequestBody<T> body) {
		this.body = body;
	}

}
