package org.github.labcabrera.hodei.customers.model;

import javax.validation.constraints.NotBlank;

import org.github.labcabrera.hodei.serialization.RoleManagerFilter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "countries")
@Schema(description = "Represents a country")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = "id")
public class Country {

	@Id
	@NotBlank
	@Schema(description = "ISO 3 code (ISO 3166-1 alpha-3 spec)", required = true, example = "ESP")
	private String id;

	@Schema(description = "ISO 2 code (ISO 3166-1 alpha-2 spec)", required = true, example = "ES")
	private String iso2;

	@Schema(description = "Spanish description for this country", example = "FRANCIA")
	private String name;

	@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = RoleManagerFilter.class)
	@Schema(description = "Entity metadata")
	private EntityMetadata metadata;

}