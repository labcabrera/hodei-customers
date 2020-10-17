package org.github.labcabrera.hodei.customers.validation;

import java.util.function.Predicate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.github.labcabrera.hodei.customers.model.IdCard;
import org.github.labcabrera.hodei.customers.validation.annotation.ValidIdCard;
import org.github.labcabrera.hodei.customers.validation.idcard.CifValidator;
import org.github.labcabrera.hodei.customers.validation.idcard.NieValidator;
import org.github.labcabrera.hodei.customers.validation.idcard.NifValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

public class IdCardValidator implements ConstraintValidator<ValidIdCard, IdCard> {

	@Override
	public boolean isValid(IdCard value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		if (value.getNumber() == null) {
			return true;
		}
		if (value.getType() != null) {
			Predicate<String> predicate = resolveIdCardNumberPredicate(value);
			if (predicate != null && !predicate.test(value.getNumber())) {
				context.unwrap(HibernateConstraintValidatorContext.class)
					.addExpressionVariable("idCard", value.getNumber())
					.buildConstraintViolationWithTemplate("{validation.constraints.idcard-invalid.message}")
					.addPropertyNode("idCard.number")
					.addConstraintViolation();
				return false;
			}
		}
		return true;
	}

	private Predicate<String> resolveIdCardNumberPredicate(IdCard idCard) {
		switch (idCard.getType()) {
		case NIF:
			return new NifValidator();
		case CIF:
			return new CifValidator();
		case NIE:
			return new NieValidator();
		default:
			return null;
		}
	}

}