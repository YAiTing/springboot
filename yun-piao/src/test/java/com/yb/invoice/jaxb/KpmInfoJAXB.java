package com.yb.invoice.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
@XmlRootElement(name="input")
@XmlAccessorType(XmlAccessType.FIELD)
public class KpmInfoJAXB {

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

}
