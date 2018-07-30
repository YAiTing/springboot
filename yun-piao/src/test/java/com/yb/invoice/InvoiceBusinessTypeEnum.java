package com.yb.invoice;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */

public enum InvoiceBusinessTypeEnum {
	//获取开票码
	GETKPM;

	public String getBusinessTypeCode() {
		return name();
	}
}
