package org.github.labcabrera.hodei.customers.model;

import javax.validation.constraints.NotBlank;

import org.github.labcabrera.hodei.customers.serialization.RoleManagerFilter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document(collection = "professions")
@Schema(description = "Represents a profession. Includes the ine code")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = "id")
public class Profession {

	@Id
	@NotBlank
	@Schema(description = "Profession identifier", required = true, example = "1")
	private String id;

	@Schema(description = "Description for this profession", example = "ENFERMEROS")
	private String name;

	@Schema(description = "CNO code for this profession", example = "272")
	private String cnoCode;

	@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = RoleManagerFilter.class)
	private EntityMetadata metadata;

}