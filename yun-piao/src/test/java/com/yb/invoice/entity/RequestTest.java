package com.yb.invoice.entity;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.yb.invoice.converter.GroupCountConverter;
import com.yb.invoice.converter.InvoiceDateConverter;

import java.io.StringWriter;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class RequestTest {

	public static void main(String[] args) {
//		toXml(new RequestToken());
//		toXml(new RequestPrintData());
		toXml(new RequestTech());
	}

	private static void toXml(RequestInfo requestInfo) {
		RequestBusiness requestBusiness = new RequestBusiness();
		requestBusiness.setId(requestInfo.getId());
		requestBusiness.getBody().setInput(requestInfo);
		XStream x = new XStream();
		x.processAnnotations(RequestBusiness.class);
		x.autodetectAnnotations(true);
		x.registerConverter(new InvoiceDateConverter("yyyyMMdd"));
		x.registerConverter(new GroupCountConverter(x.getMapper()));
		//去掉class属性
		x.aliasSystemAttribute(null, "class");
		StringWriter writer = new StringWriter();
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		formatToXml(requestBusiness, x, writer);
//		unformatToXml(requestBusiness, x, writer);
	}

	private static void formatToXml(RequestBusiness requestBusiness, XStream x, StringWriter writer) {
		x.toXML(requestBusiness, writer);
		String xml = writer.toString();
		System.out.println(xml);
	}

	public static String unformatToXml(RequestBusiness requestBusiness, XStream xStream, StringWriter writer) {
		xStream.marshal(requestBusiness,new CompactWriter(writer));
		String xml = writer.toString();
		System.out.println(xml);
		return xml;
	}

}
