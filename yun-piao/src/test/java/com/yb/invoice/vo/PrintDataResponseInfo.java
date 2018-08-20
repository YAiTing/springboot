package com.yb.invoice.vo;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class PrintDataResponseInfo extends ResponseInfo {

	/**打印数据*/
	private String jsondata;

	public String getJsondata() {
		return jsondata;
	}

	public void setJsondata(String jsondata) {
		this.jsondata = jsondata;
	}
}
