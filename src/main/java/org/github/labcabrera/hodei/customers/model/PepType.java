package org.github.labcabrera.hodei.customers.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PepType {

	PERSON("person"),

	RELATIVE("relative"),

	NONE("none");

	private String value;

	private PepType(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}

}
