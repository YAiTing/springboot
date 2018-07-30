package com.yb.invoice;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.io.PrintWriter;
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
		XStream x = new XStream();
		x.registerConverter(new DateConverter());
		x.autodetectAnnotations(true);
		StringWriter writer = new StringWriter();
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		x.toXML(a, writer);
		String xml = writer.toString();
		System.out.println(xml);
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

	private static class ListAttrConverter implements Converter {

		@Override
		public boolean canConvert(Class type) {
			return type.equals(List.class);
		}

		@Override
		public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {

		}

		@Override
		public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
			return null;
		}
	}
}
