package com.yb.invoice;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.core.util.Base64Encoder;
import com.thoughtworks.xstream.io.xml.CompactWriter;
import com.yb.invoice.converter.GroupCountConverter;
import com.yb.invoice.converter.InvoiceDateConverter;
import com.yb.invoice.converter.ResponseBodyConverter;
import com.yb.invoice.entity.KpmRequestInfo;
import com.yb.invoice.entity.RequestBusiness;
import com.yb.invoice.entity.RequestInfo;
import com.yb.invoice.vo.BusinessReturnInvoice;
import com.yb.invoice.vo.PrintDataResponseInfo;
import com.yb.invoice.vo.ResponseInfo;
import com.yb.invoice.vo.TokenResponseInfo;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Author: yangb
 * @Description:
 */
public class InvoiceDemo extends AbstractDrawBill {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String result = "NTAwMTAyMDEwMDAxNDQ4MjAxODA4MjAxNzEzMjE2NjQxNjUyMQ==";
		System.out.println("result:" + new String(Base64.getDecoder().decode(result), "utf-8"));
	}

	//获取token
	@Test
	public void getToken() throws IOException {
		RestTemplate restTemplate = getRestTemplate();
		String url = "http://www.366tax.cn:10001/dzfpkp/NByunpiao/token.htm";
//		String url = "http://60.12.220.74:10001/dzfpkp/NByunpiao/token.htm";
		String xml = "<business id=\"GETTOKEN\"><body><input><appId>500102010001448,499000115575</appId><appSecret>01b92641dc5d48e9ba8b003eda027168</appSecret></input></body></business>";
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<>(request, headers);
		String request = new Base64Encoder().encode(xml.getBytes("UTF-8"));
		HttpEntity<String> entity = new HttpEntity<>(request);
		String result = restTemplate.postForObject(url, entity, String.class);
//		String result = responseEntity.getBody();
		String fromXml = new String(new Base64Encoder().decode(result), "utf-8");
		System.out.println("result:" + fromXml);
		BusinessReturnInvoice<TokenResponseInfo> businessReturnInvoice = fromXml(fromXml, TokenResponseInfo.class);
		System.out.println(businessReturnInvoice.getBody().getToken());
		//token 放到redis里
	}

	//获取开票码
	@Test
	public void getKpm() throws IOException {
		RestTemplate restTemplate = getRestTemplate();
		String token = "195a7448b6d24eec9518f6295f4f9352";
		String url = "http://www.366tax.cn:10001/dzfpkp/NByunpiao/" + token + ".htm";
		KpmRequestInfo kpmRequestInfo = new KpmRequestInfo();
		kpmRequestInfo.setNsrsbh("500102010001448");
		kpmRequestInfo.setSqm("ZciG+4KYN9b3tnuuhy4OtDlksYeK8C7cLq44je7UUzGlnO/d8PUPyQ==");
		String xml = toXml(kpmRequestInfo);
		String request = Base64.getEncoder().encodeToString(xml.getBytes("UTF-8"));
		HttpEntity<String> entity = new HttpEntity<>(request);
		String result = restTemplate.postForObject(url, entity, String.class);
		String fromXml = new String(Base64.getDecoder().decode(result), "utf-8");
		System.out.println("result:" + fromXml);
	}



	@Test
	public void xmlxmlxml() {
		String fromXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
				"<business id=\"GETTOKEN\">\n" +
				"    <body>\n" +
				"        <returndata/>\n" +
				"        <returncode>0</returncode>\n" +
				"        <returnmsg>获取token成功！</returnmsg>\n" +
				"        <token>455c7e2a97444ac3b8620f3b4ec6b232</token>\n" +
				"        <timestamp>20180817123415</timestamp>\n" +
				"    </body>\n" +
				"</business>";
		BusinessReturnInvoice<TokenResponseInfo> result = fromXml(fromXml, TokenResponseInfo.class);
		TokenResponseInfo body = result.getBody();
		System.out.println(result);
	}

	@Test
	public void printData() {
		String fromXml = "<business id=\"PRINTDATA\">\n" +
				"    <body>\n" +
				"        <returncode>返回代码</returncode>\n" +
				"        <returnmsg>返回信息</returnmsg>\n" +
				"        <jsondata>json格式的打印数据</jsondata>\n" +
				" \t</body>\n" +
				"</business>";
		BusinessReturnInvoice<PrintDataResponseInfo> result = fromXml(fromXml, PrintDataResponseInfo.class);
		PrintDataResponseInfo body = result.getBody();
		System.out.println(result);
	}

	public static <T extends ResponseInfo> BusinessReturnInvoice<T> fromXml(String xml, Class<T> clazz) {
		XStream xStream = new XStream();
		xStream.processAnnotations(new Class[] {BusinessReturnInvoice.class});
		xStream.autodetectAnnotations(true);
		Converter converter = new ResponseBodyConverter(xStream, clazz);
		xStream.registerConverter(converter, 1);
		return (BusinessReturnInvoice) xStream.fromXML(xml);
	}

	private static String toXml(RequestInfo requestInfo) {
		RequestBusiness requestBusiness = new RequestBusiness();
		requestBusiness.setId(requestInfo.getId());
		requestBusiness.getBody().setInput(requestInfo);
		XStream xStream = new XStream();
		xStream.processAnnotations(RequestBusiness.class);
		xStream.autodetectAnnotations(true);
		xStream.registerConverter(new InvoiceDateConverter("yyyyMMdd"));
		xStream.registerConverter(new GroupCountConverter(xStream.getMapper()));
		//去掉class属性
		xStream.aliasSystemAttribute(null, "class");
		StringWriter writer = new StringWriter();
		writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
//		formatToXml(requestBusiness, xStream, writer);
		return formatToXml(requestBusiness, xStream, writer);
	}

	private static String formatToXml(RequestBusiness requestBusiness, XStream x, StringWriter writer) {
		x.toXML(requestBusiness, writer);
		String xml = writer.toString();
		System.out.println(xml);
		return xml;
	}

	public static String unformatToXml(RequestBusiness requestBusiness, XStream xStream, StringWriter writer) {
		xStream.marshal(requestBusiness,new CompactWriter(writer));
		String xml = writer.toString();
		System.out.println(xml);
		return xml;
	}
}
