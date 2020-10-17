package org.github.labcabrera.hodei.customers.model;

import java.util.Map;

import javax.validation.Valid;

import org.github.labcabrera.hodei.customers.validation.annotation.ExistingJobType;
import org.github.labcabrera.hodei.customers.validation.annotation.ExistingProfession;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Additional information for a person")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDetail {

	@Schema(description = "External customer identifier", required = false, example = "false")
	private String clientNumber;

	@Schema(description = "If true then the customer accepts to receive advertisement or commercial notifications", required = false)
	private Map<String, Boolean> productCommercialNotifications;

	@ExistingJobType
	@Schema(description = "Job Type. Available values can be obtained through customers API", required = false)
	private String jobTypeId;

	@ExistingProfession
	@Schema(description = "Profession. Available values can be obtained through customers API", required = false)
	private String professionId;

	@Schema(description = "Economic activity. Available values can be obtained through customers API", required = false)
	private String economicActivityId;

	@Schema(description = "PEP (Politically Exposed Person) information", required = false)
	@Valid
	private PepInformation pep;

	@Schema(description = "High Risk Code", required = false, example = "013")
	private String highRiskCode;
}