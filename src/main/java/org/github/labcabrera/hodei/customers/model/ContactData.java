package org.github.labcabrera.hodei.customers.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "Contact data")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactData {

	@Schema(description = "Email for this person or company", example = "johndoesmith@cnppartners.eu")
	private String email;

	@Schema(description = "Alternate email for this person or company", example = "johndoe@cnppartners.eu")
	private String alternateEmail;

	@Schema(description = "Cell phone for this person or company", example = "600700800")
	private String phoneNumber;

	@Schema(description = "Landline phone for this person or company", example = "+34 910001122")
	private String alternatePhoneNumber;

	@Schema(description = "Fax for this person or company", example = "910002233")
	private String fax;

	@Schema(description = "Contact web page for this person or company", example = "https://www.cnppartners.es/")
	private String website;

}