package com.yb.invoice;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import com.yb.invoice.vo.KpmInfo;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @Author: yangb
 * @Description:
 */
public abstract class AbstractDrawBill {

	//这块需要改进传 version 和 encoding进来
	private String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";

	protected String buildXml(KpmInfo info) {
		XStream xStream = new XStream(new Dom4JDriver());
		xStream.autodetectAnnotations(true);
		StringWriter writer = new StringWriter();
		writer.write(xmlHeader);
		XmlTemplate obj = new XmlTemplate(info.getBusinessType().getBusinessTypeCode(), info);
		xStream.marshal(obj, new CompactWriter(writer));
		return writer.toString();
	}

	protected String buildJABX(KpmInfo info) {
		try {
			String body = buildJAXBXml(KpmInfo.class, info);
			XmlTemplate obj = new XmlTemplate(info.getBusinessType().getBusinessTypeCode(), info);
			return buildJAXBXml(XmlTemplate.class, obj);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return "";
	}

	private String buildJAXBXml(Class clazz, Object info) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(clazz);
		Marshaller marshaller = context.createMarshaller();
		//格式化
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
		StringWriter writer = new StringWriter();
		marshaller.marshal(info, writer);
		return writer.toString();
	}

	@XStreamAlias("business")
	@XmlRootElement(name="business")
	@XmlAccessorType(XmlAccessType.FIELD)
	private static class XmlTemplate {

		@XStreamAsAttribute
		@XmlAttribute
		private String id;

		@XStreamAlias("body")
		@XmlElements({@XmlElement(name="body")})
		private KpmInfo body;

		public XmlTemplate(){}

		public XmlTemplate(String id, KpmInfo body) {
			this.id = id;
			this.body = body;
		}
	}

	protected RestTemplate getRestTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(10000);
		requestFactory.setReadTimeout(10000);
		//可以替换httpclient
		return new RestTemplate(requestFactory);
	}

}
