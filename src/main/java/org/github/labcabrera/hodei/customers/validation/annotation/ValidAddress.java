package org.github.labcabrera.hodei.customers.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.github.labcabrera.hodei.customers.validation.AddressValidator;

@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AddressValidator.class)
public @interface ValidAddress {

	String message() default "invalid.address";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
