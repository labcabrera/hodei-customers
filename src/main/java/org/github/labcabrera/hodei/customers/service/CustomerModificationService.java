package org.github.labcabrera.hodei.customers.service;

import javax.validation.Valid;

import org.github.labcabrera.hodei.customers.dto.CustomerModification;
import org.github.labcabrera.hodei.customers.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerModificationService {

	public Customer customerModification(@Valid CustomerModification operation) {
		return null;
	}

}
