package com.yb.invoice.converter;

import com.thoughtworks.xstream.converters.basic.DateConverter;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class InvoiceDateConverter extends DateConverter {

	public InvoiceDateConverter(String defaultFormat) {
		super(defaultFormat, new String[]{defaultFormat});
	}
}
