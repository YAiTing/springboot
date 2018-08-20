package com.yb.invoice;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.CompactWriter;

import java.io.StringWriter;
import java.util.Date;
import java.util.List;

/**
 * @Author: yangb
 * @Description: 云票
 */
public class XstreamDemo {

	public static void main(String[] args) {
		A a = new A();
		a.setSqm("1");
		a.setCzlx("操作类型");
		a.setCreateDate(new Date());
//		XStream x = new XStream(new StaxDriver());
		XStream x = new XStream();
		x.registerConverter(new DateConverter("YYYYMMDD", new String[]{"YYYYMMDD"}));
		x.autodetectAnnotations(true);
		StringWriter writer = new StringWriter();
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		x.toXML(a, writer);
		String xml = writer.toString();
		System.out.println(xml);
	}

	public static String obj2xmlByXStream(Object obj) {
		XStream xst = new XStream();
		xst.processAnnotations(obj.getClass());
		StringWriter writer = new StringWriter();
		xst.marshal(obj,new CompactWriter(writer));
		return writer.toString();
	}

	@XStreamAlias("input")
	private static class A {

		private String sqm;

		private String czlx;

		@XStreamConverter(DateConverter.class)
		private Date createDate;

		@XStreamAlias("shsh")
		private List<B> list = Lists.newArrayList(new B("a", 1), new B("b" ,2));

		public String getSqm() {
			return sqm;
		}

		public void setSqm(String sqm) {
			this.sqm = sqm;
		}

		public List<B> getList() {
			return list;
		}

		public void setList(List<B> list) {
			this.list = list;
		}

		public String getCzlx() {
			return czlx;
		}

		public void setCzlx(String czlx) {
			this.czlx = czlx;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}
	}

	@XStreamAlias("group")
	private static class B {

		private String nsrsbh;

		@XStreamAsAttribute
		private int xh;

		public B(String nsrsbh, int xh) {
			this.nsrsbh = nsrsbh;
			this.xh = xh;
		}
	}

}
