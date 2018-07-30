package com.yb.invoice.vo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.yb.invoice.IInvoice;
import com.yb.invoice.InvoiceBusinessTypeEnum;
import org.springframework.context.annotation.ComponentScan;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.NavigableMap;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@XStreamAlias("input")
@XmlRootElement(name="input")
@XmlAccessorType(XmlAccessType.FIELD)
public class KpmInfo implements IInvoice {

	//纳税人识别号
	@XmlElement
	private String nsrsbh = "500102010001448";

	//授权码
	@XmlElement
	private String sqm = "ZciG+4KYN9b3tnuuhy4OtDlksYeK8C7cLq44je7UUzGlnO/d8PUPyQ==";

	public String getNsrsbh() {
		return nsrsbh;
	}

	public void setNsrsbh(String nsrsbh) {
		this.nsrsbh = nsrsbh;
	}

	public String getSqm() {
		return sqm;
	}

	public void setSqm(String sqm) {
		this.sqm = sqm;
	}

	@Override
	public InvoiceBusinessTypeEnum getBusinessType() {
		return InvoiceBusinessTypeEnum.GETKPM;
	}
}
