package com.yb.invoice;

import com.yb.invoice.entity.InvoiceBusinessTypeEnum;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
//@XStreamAlias("input")
public interface IInvoice {

	InvoiceBusinessTypeEnum getBusinessType();
}
