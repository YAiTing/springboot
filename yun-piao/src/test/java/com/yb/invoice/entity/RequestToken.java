package com.yb.invoice.entity;

/**
 * @Author: yangb
 * @Description:
 */
public class RequestToken extends RequestInfo {

	private String appId = "500102010001448,499000115575";

	private String appSecret = "01b92641dc5d48e9ba8b003eda027168";

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	@Override
	public InvoiceBusinessTypeEnum getId() {
		return InvoiceBusinessTypeEnum.GETKPM;
	}
}
