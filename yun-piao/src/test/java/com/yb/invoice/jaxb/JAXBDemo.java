package com.yb.invoice.jaxb;

import com.yb.invoice.AbstractDrawBill;
import com.yb.invoice.vo.KpmInfo;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @Author: yangb
 * @Description:
 * @Date: Created in 11:02 2017/12/8
 */
public class JAXBDemo {
	public static void main(String[] args) {
		KpmInfoJAXB k = new KpmInfoJAXB();
		System.out.println(buildJABX(k));
	}

	private static String buildJABX(KpmInfoJAXB info) {
		try {
			JAXBContext context = JAXBContext.newInstance();
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			StringWriter writer = new StringWriter();
			mar.marshal(info, writer);
			return writer.toString();
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return "";
	}
}
