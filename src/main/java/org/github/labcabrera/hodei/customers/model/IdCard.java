package org.github.labcabrera.hodei.customers.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.github.labcabrera.hodei.customers.validation.annotation.ExistingCountry;
import org.github.labcabrera.hodei.customers.validation.annotation.ValidIdCard;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Schema(description = "Identification document")
@ValidIdCard
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = "number")
public class IdCard {

	@NotBlank(message = "{validation.constraints.person.expected-id-card-number}")
	@Schema(description = "Document number", required = true, example = "11111111H")
	private String number;

	@NotNull(message = "{validation.constraints.person.expected-id-card-type}")
	@Schema(description = "Document type", required = true, example = "NIF")
	private IdCardType type;

	@Schema(description = "When the document was emmited", required = false, example = "2013-06-01")
	private LocalDate issued;

	@Schema(description = "When the document expires", required = false, example = "2023-12-31")
	private LocalDate expires;

	@Schema(description = "Organization that has emmited the document", required = false)
	private String issuer;

	@Schema(description = "Country that has emmited the document", required = false, example = "ESP")
	@ExistingCountry
	private String countryId;

}