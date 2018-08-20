package com.yb.invoice.entity;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class PrintDataRequestInfo extends RequestInfo {

	/**机身编号
	 * 纳税人识别号+开票终端标识(使用英文~~符合分隔)
	 */
	@NotEmpty(message = "机身编号不能为空")
	@Length(max = 100, message = "机身编号长度不能超过100")
	private String jsbh;

	/**发票类型代码*/
	@NotEmpty
	private String fplxdm;

	/**查询方式
	 * 0：按发票号码查询
	 * 1：按请求流水号查询
	 */
	@NotEmpty
	private String cxfs;

	/**查询条件
	 * cxfs为0时：发票代码+发票号码(使用英文~符号分隔)
	 * cxfs为1时：发票交易流水号
	 */
	@NotEmpty
	private String cxtj;

	/**左边距 代表打印起点的x坐标*/
	@NotEmpty
	private String left;

	/**上边距 代表打印起点的y坐标*/
	@NotEmpty
	private String top;

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
		return InvoiceBusinessTypeEnum.PRINTDATA;
	}
}
