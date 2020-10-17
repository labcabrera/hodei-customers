package org.github.labcabrera.hodei.customers.model;

import java.time.LocalDateTime;
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
public class SynchronizationInfo {

	@Schema(description = "External identifier")
	private String key;

	@Schema(description = "Additional values")
	private Map<String, String> values;

	@Schema(description = "Synchronization pull date")
	private LocalDateTime pullDate;

	@Schema(description = "Synchronization push date")
	private LocalDateTime pushDate;

}
