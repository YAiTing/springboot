package com.yb.invoice.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@XStreamAlias("body")
public class TokenResponseInfo extends ResponseInfo {

	@XStreamAlias("returndata")
	private String returndata;

	@XStreamAlias("token")
	private String token;

	@XStreamAlias("timestamp")
	private String timestamp;

	public String getReturndata() {
		return returndata;
	}

	public void setReturndata(String returndata) {
		this.returndata = returndata;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "TokenResponseInfo{" +
				"returndata='" + returndata + '\'' +
				", token='" + token + '\'' +
				", timestamp='" + timestamp + '\'' +
				'}';
	}
}
