package org.github.labcabrera.hodei.customers.service;

import javax.validation.Valid;

import org.github.labcabrera.hodei.customers.dto.CustomerCreation;
import org.github.labcabrera.hodei.customers.model.Customer;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class CustomerCreationService {

	public Customer customerCreation(@Valid CustomerCreation operation) {
		return null;
	}

}
