package org.github.labcabrera.hodei.customers.model;

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

@Document(collection = "jobTypes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(of = "id")
public class JobType {

	@Id
	@Schema(description = "Job type identifier")
	private String id;

	private String description;

	@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = RoleManagerFilter.class)
	private EntityMetadata metadata;

}