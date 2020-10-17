package org.github.labcabrera.hodei.customers.validation.idcard;

import java.util.function.Predicate;

import org.apache.commons.lang3.StringUtils;

public abstract class AbstractIdCardValidator implements Predicate<String> {

	@Override
	public boolean test(String value) {
		if (value == null || StringUtils.isEmpty(value)) {
			return false;
		}
		return internalValidation(value);
	}

	protected abstract boolean internalValidation(String value);

}
