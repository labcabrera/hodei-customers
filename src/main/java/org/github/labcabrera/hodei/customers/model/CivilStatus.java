package org.github.labcabrera.hodei.customers.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CivilStatus {

	SINGLE("single"),

	MARRIED("married"),

	DIVORCED("divorced"),

	WIDOW("widow"),

	OTHER("other");

	private String value;

	private CivilStatus(String value) {
		this.value = value;
	}

	@JsonValue
	public String getValue() {
		return value;
	}
}
