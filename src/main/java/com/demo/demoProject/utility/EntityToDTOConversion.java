package com.demo.demoProject.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

public class EntityToDTOConversion<T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T dto, T entity) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.convertValue(entity, dto.getClass());
	}

}
