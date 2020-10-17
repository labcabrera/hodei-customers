package org.github.labcabrera.hodei.customers.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gender {

	MALE("male"),

	FEMALE("female");

	private String value;

	private Gender(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}