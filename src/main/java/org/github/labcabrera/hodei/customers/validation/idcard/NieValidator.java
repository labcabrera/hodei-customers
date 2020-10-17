package org.github.labcabrera.hodei.customers.validation.idcard;

public class NieValidator extends NifValidator {

	@Override
	protected boolean internalValidation(String nie) {
		String tmp = nie;
		if (nie.startsWith("X")) {
			tmp = nie.replaceFirst("X", "0");
		}
		else if (nie.startsWith("Y")) {
			tmp = nie.replaceFirst("Y", "1");
		}
		else if (nie.startsWith("Z")) {
			tmp = nie.replaceFirst("Z", "2");
		}
		return super.internalValidation(tmp);
	}

}
