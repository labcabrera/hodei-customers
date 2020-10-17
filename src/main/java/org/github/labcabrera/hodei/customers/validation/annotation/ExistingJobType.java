package org.github.labcabrera.hodei.customers.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.github.labcabrera.hodei.customers.validation.ExistingJobTypeValidator;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistingJobTypeValidator.class)
public @interface ExistingJobType {

	String message() default "invalid.jobType";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
