package org.github.labcabrera.hodei.customers.validation.idcard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NifValidator extends AbstractIdCardValidator {

	private static final String REG_EX = "^(\\d{7,8})([A-Z])$";
	private static final String CHARS = "TRWAGMYFPDXBNJZSQVHLCKE";

	@Override
	protected boolean internalValidation(String value) {
		Matcher matcher = Pattern.compile(REG_EX).matcher(value);
		if (!matcher.matches()) {
			return false;
		}
		else {
			int intValue = Integer.parseInt(matcher.group(1));
			if (intValue == 0) {
				return false;
			}
			String codeValue = matcher.group(2);
			int index = intValue % 23;
			String check = CHARS.substring(index, index + 1);
			return check.equals(codeValue);
		}
	}

}