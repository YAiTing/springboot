package com.yb.invoice.vo;

import java.io.Serializable;

/**
 * @Author: yangb
 * @Description:
 */
public class ResponseInfo implements Serializable {

	/**返回代码 0成功，其它失败*/
	private String returncode;

	/**返回信息*/
	private String returnmsg;

	public String getReturncode() {
		return returncode;
	}

	public void setReturncode(String returncode) {
		this.returncode = returncode;
	}

	public String getReturnmsg() {
		return returnmsg;
	}

	public void setReturnmsg(String returnmsg) {
		this.returnmsg = returnmsg;
	}
}
