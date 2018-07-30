package com.yb.invoice;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yb.invoice.vo.KpmInfo;
import io.netty.handler.codec.base64.Base64Decoder;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

/**
 * @Author: yangb
 * @Description:
 */
public class InvoiceDemo extends AbstractDrawBill {

	//获取token
	@Test
	public void getToken() throws IOException {
		RestTemplate restTemplate = getRestTemplate();
		String url = "http://60.12.220.74:10001/dzfpkp/NByunpiao/token.htm";
		String xml = "<?xml version='1.0' encoding='utf-8' ?><business id=\"GETTOKEN\"><body><input><appId>500102010001448,499000115575</appId><appSecret>01b92641dc5d48e9ba8b003eda027168</appSecret></input></body></business>";
//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<>(request, headers);
		String request = Base64.getEncoder().encodeToString(xml.getBytes("UTF-8"));
		HttpEntity<String> entity = new HttpEntity<>(request);
		String result = restTemplate.postForObject(url, entity, String.class);
//		String result = responseEntity.getBody();
		System.out.println("result:" + new String(Base64.getDecoder().decode(result), "utf-8"));
		//token 放到redis里
	}

	//获取开票码
	@Test
	public void getKpm() throws IOException {
		RestTemplate restTemplate = getRestTemplate();
		String token = "ff97891a5226452296e98229bd210542";
		String url = "http://60.12.220.74:10001/dzfpkp/NByunpiao/" + token + ".htm";
		KpmInfo info = new KpmInfo();
//		String xml = buildXml(info);
		String xml = buildJABX(info);
		System.out.println(xml);
//		String request = Base64.getEncoder().encodeToString(xml.getBytes("UTF-8"));
//		HttpEntity<String> entity = new HttpEntity<>(request);
//		String result = restTemplate.postForObject(url, entity, String.class);
//		System.out.println("result:" + new String(Base64.getDecoder().decode(result), "utf-8"));
	}

}
