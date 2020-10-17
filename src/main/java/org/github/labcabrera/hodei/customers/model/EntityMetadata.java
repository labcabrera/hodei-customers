package org.github.labcabrera.hodei.customers.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntityMetadata {

	@Schema(description = "Entity creation time")
	private LocalDateTime created;

	@Schema(description = "Entity modification time")
	private LocalDateTime updated;

	@Schema(description = "Entity source", example = "cnp-ppi-policies-worker")
	private String source;

	@Schema(description = "Synchronization information with external systems")
	private Map<String, SynchronizationInfo> sync;

	@Schema(description = "Messages associated with the entity")
	private List<MessageEntry> messages;

}
