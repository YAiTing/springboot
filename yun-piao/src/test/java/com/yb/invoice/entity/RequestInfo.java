package com.yb.invoice.entity;

import java.io.Serializable;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public abstract class RequestInfo implements Serializable {

	public abstract InvoiceBusinessTypeEnum getId();
}
