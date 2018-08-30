package com.yb.invoice.converter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.converters.reflection.AbstractReflectionConverter;
import com.thoughtworks.xstream.converters.reflection.ReflectionProvider;
import com.thoughtworks.xstream.core.ReferenceByXPathUnmarshaller;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.mapper.Mapper;
import com.yb.invoice.vo.ResponseInfo;

/**
 * @Author: yangb
 * @Description:
 */
public class ResponseBodyConverter<T extends ResponseInfo> extends AbstractReflectionConverter {

	private Class<T> type;

	public ResponseBodyConverter(XStream xstream, Class type) {
		this(xstream.getMapper(), xstream.getReflectionProvider(), type);
	}

	public ResponseBodyConverter(Mapper mapper, ReflectionProvider reflectionProvider, Class type) {
		super(mapper, reflectionProvider);
		this.type = type;
	}

	@Override
	protected Object instantiateNewInstance(HierarchicalStreamReader reader, UnmarshallingContext context) {
		String attributeName = mapper.aliasForSystemAttribute("resolves-to");
		String readResolveValue = attributeName == null ? null : reader
				.getAttribute(attributeName);
		Object currentObject = context.currentObject();
		if (currentObject != null) {
			return currentObject;
		} else if (readResolveValue != null) {
			return reflectionProvider.newInstance(mapper.realClass(readResolveValue));
		} else {
			return reflectionProvider.newInstance(this.type);
		}
	}

	@Override
	public boolean canConvert(Class type) {
		return ResponseInfo.class.isAssignableFrom(type) && canAccess(type);
	}
}
