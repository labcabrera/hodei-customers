package org.github.labcabrera.hodei.customers.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.github.labcabrera.hodei.customers.validation.ExistingProfessionValidator;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistingProfessionValidator.class)
public @interface ExistingProfession {

	String message() default "invalid.profession";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
