package org.github.labcabrera.hodei.customers.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SuppressWarnings("serial")
public class MessageEntry implements Serializable {

	@Schema(description = "Message text", example = "general.error.cause")
	private String text;

	@Schema(description = "Message params for text", example = "'cause', 'cause text'")
	private Map<String, String> params;

	public MessageEntry(ConstraintViolation<?> violation) {
		this.text = violation.getMessage();
		params = new LinkedHashMap<>();
		params.put("path", violation.getPropertyPath().toString());
		params.put("template", violation.getMessageTemplate());
	}

}
