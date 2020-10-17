package org.github.labcabrera.hodei.customers.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.github.labcabrera.hodei.customers.validation.annotation.ExistingCountry;
import org.github.labcabrera.hodei.customers.validation.annotation.ExistingProvince;
import org.github.labcabrera.hodei.customers.validation.annotation.ExistingRoadType;
import org.github.labcabrera.hodei.customers.validation.annotation.ValidAddress;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Address data")
@ValidAddress
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

	@ExistingCountry
	@NotNull(message = "{validation.constraints.address.required-country")
	@Schema(description = "Country", required = true, example = "ESP")
	private String countryId;

	@ExistingProvince
	@Schema(description = "Province", required = false, example = "ESP-28")
	private String provinceId;

	@NotBlank(message = "{validation.constraints.address.required-locality")
	@Schema(description = "Locality", required = true, example = "MADRID")
	private String locality;

	@NotBlank(message = "{validation.constraints.address.required-zipcode")
	@Schema(description = "Zip code", required = true, example = "28001")
	private String zipCode;

	@ExistingRoadType
	@Schema(description = "Road type. This value must match one of the existing values in the system. You can obtain them from commons API", example = "street")
	private String roadType;

	@NotBlank(message = "{validation.constraints.address.required-road")
	@Schema(description = "Street, number and floor", required = true, example = "SERRANO 3, 2B")
	private String road;

}