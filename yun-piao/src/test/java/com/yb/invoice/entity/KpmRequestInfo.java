package com.yb.invoice.entity;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class KpmRequestInfo extends RequestInfo {

	/**纳税人识别号*/
	private String nsrsbh;

	/**纳税人识别号 传空即可*/
	private String sqm;

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
	public InvoiceBusinessTypeEnum getId() {
		return InvoiceBusinessTypeEnum.GETKPM;
	}
}
