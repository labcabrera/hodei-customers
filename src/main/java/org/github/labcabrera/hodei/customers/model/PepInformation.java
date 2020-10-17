package org.github.labcabrera.hodei.customers.model;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PepInformation {

	@Schema(description = "PEP type", required = true, example = "person")
	@NotNull
	private PepType type;

	@Schema(description = "PEP code", required = false)
	private String code;
}
