package org.github.labcabrera.hodei.customers.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.github.labcabrera.hodei.customers.validation.ExistingCountryValidator;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistingCountryValidator.class)
public @interface ExistingCountry {

	String message() default "invalid.country";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	@Target({ ElementType.FIELD })
	public @interface ExistingCountryList {
		ExistingCountry[] value();
	}
}