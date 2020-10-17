package org.github.labcabrera.hodei.customers.model;

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

@Document(collection = "provinces")
@Schema(description = "Represents a province")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = "id")
public class Province {

	@Id
	@Schema(description = "Internal identifier", example = "28")
	private String id;

	@Schema(description = "Code for this province. This code could be not unique because depends on the country", example = "28")
	private String code;

	@Schema(description = "Name description for this province", example = "MADRID")
	private String name;

	@Schema(description = "Country associated to this province")
	private String countryId;

	@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = RoleManagerFilter.class)
	private EntityMetadata metadata;

}
