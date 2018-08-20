package com.yb.invoice.entity;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class RequestPrintData extends RequestInfo {

	private String jsbh = "机身编号";

	private String fplxdm = "发票类型代码";

	private String cxfs = "查询方式";

	private String cxtj = "查询条件";

	private String left = "左边距";

	private String top = "上边距";

	public String getJsbh() {
		return jsbh;
	}

	public void setJsbh(String jsbh) {
		this.jsbh = jsbh;
	}

	public String getFplxdm() {
		return fplxdm;
	}

	public void setFplxdm(String fplxdm) {
		this.fplxdm = fplxdm;
	}

	public String getCxfs() {
		return cxfs;
	}

	public void setCxfs(String cxfs) {
		this.cxfs = cxfs;
	}

	public String getCxtj() {
		return cxtj;
	}

	public void setCxtj(String cxtj) {
		this.cxtj = cxtj;
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getTop() {
		return top;
	}

	public void setTop(String top) {
		this.top = top;
	}

	@Override
	public InvoiceBusinessTypeEnum getId() {
		return InvoiceBusinessTypeEnum.GETKPM;
	}
}
