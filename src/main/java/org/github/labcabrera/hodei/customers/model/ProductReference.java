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
public class ProductReference {

	@NotNull
	@Schema(description = "Module name", required = true, example = "ppi")
	private String module;

	@NotNull
	@Schema(description = "Agreement identifier", required = true, example = "10001")
	private String agreementId;

	@NotNull
	@Schema(description = "Policy identifier", required = true, example = "5e330136d601800001f4ed58")
	private String policyId;

	@Schema(description = "Optional policy state", required = false, example = "active")
	private String policyState;
}
