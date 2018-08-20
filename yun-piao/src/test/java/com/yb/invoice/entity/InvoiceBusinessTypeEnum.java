package com.yb.invoice.entity;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */

public enum InvoiceBusinessTypeEnum {
	//获取开票码
	GETKPM,
	//获取发票打印数据
	PRINTDATA,
	//设备绑定
	SBBD;

	public String getBusinessTypeCode() {
		return name();
	}
}
