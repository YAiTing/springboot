package com.yb.invoice.converter;

import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.collections.CollectionConverter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.mapper.Mapper;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: yangb
 * @Description:
 */
public class GroupCountConverter extends CollectionConverter {

	public GroupCountConverter(Mapper mapper) {
		super(mapper);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		Collection collection = (Collection) source;
		writer.addAttribute("count", String.valueOf(collection.size()));
		for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
			Object item = iterator.next();
			writeItem(item, context, writer);
		}
	}

	@Override
	public boolean canConvert(Class type) {
		return List.class.isAssignableFrom(type);
	}
}
