package org.github.labcabrera.hodei.customers.validation.idcard;

public class CifValidator extends AbstractIdCardValidator {

	/**
	 * Caracteres de los tipos de organismo validos (primera letra del cif).
	 */
	private static final String VALID_FIRST_CHAR = "ABCDEFGHJNPQRSUVW";

	/**
	 * Caracteres de control (ultima letra del cif)
	 */
	private static final String CONTROL_CHARS = "JABCDEFGHI";

	/**
	 * Tipos donde el caracter de control debe ser una letra
	 */
	private static final String LETTER_TYPE = "PQS";

	/**
	 * Tipos donde el caracter de control debe ser un nombre
	 */
	private static final String NAME_TYPE = "ABEH";

	@Override
	protected boolean internalValidation(String value) {
		if (value.length() != 9) {
			return false;
		}
		int controlDigit;
		// Comprobamos que el primer digito sea valido
		String firstChar = value.substring(0, 1);
		if (!VALID_FIRST_CHAR.contains(firstChar)) {
			return false;
		}
		// Comprobamos que las posiciones 1 al 7 son digitos
		for (int i = 1; i < 8; i++) {
			if (!Character.isDigit(value.charAt(i))) {
				return false;
			}
		}

		if (Character.isDigit(value.charAt(8))) {
			controlDigit = Character.getNumericValue(value.charAt(8));
			if (LETTER_TYPE.indexOf(firstChar) >= 0) {
				controlDigit = 100;
			}
		}
		else {
			controlDigit = CONTROL_CHARS.indexOf(value.charAt(8));
			if (NAME_TYPE.indexOf(firstChar) >= 0) {
				controlDigit = 100;
			}
		}
		int a = 0;
		int b = 0;
		int c = 0;
		byte[] evens = { 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 };
		for (int t = 1; t <= 6; t = t + 2) {
			a = a + Character.getNumericValue(value.charAt(t + 1));
			b = b + evens[Character.getNumericValue(value.charAt(t))];
		}
		b = b + evens[Character.getNumericValue(value.charAt(7))];
		c = 10 - ((a + b) % 10);
		return c == controlDigit;
	}

}
