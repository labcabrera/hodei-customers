package org.github.labcabrera.hodei.customers.binding;

import java.util.function.Consumer;

import org.github.labcabrera.hodei.customers.dto.CustomerCreation;
import org.github.labcabrera.hodei.customers.dto.CustomerModification;
import org.github.labcabrera.hodei.customers.service.CustomerCreationService;
import org.github.labcabrera.hodei.customers.service.CustomerModificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BindingConfig {

	@Bean
	public Consumer<CustomerCreation> customerCreation(CustomerCreationService service) {
		return service::customerCreation;
	}

	@Bean
	public Consumer<CustomerModification> customerModification(CustomerModificationService service) {
		return service::customerModification;
	}

}
