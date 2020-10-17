package org.github.labcabrera.hodei.customers.model;

import org.github.labcabrera.hodei.customers.serialization.RoleManagerFilter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document("roadTypes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = "id")
public class RoadType {

	@Id
	private String id;

	private String name;

	@JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = RoleManagerFilter.class)
	private EntityMetadata metadata;

}