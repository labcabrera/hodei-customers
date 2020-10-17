package org.github.labcabrera.hodei.customers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.github.labcabrera.hodei.customers.model.RoadType;
import org.github.labcabrera.hodei.customers.validation.annotation.ExistingRoadType;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class ExistingRoadTypeValidator implements ConstraintValidator<ExistingRoadType, String> {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext ctx) {
		ctx.disableDefaultConstraintViolation();
		if (value == null) {
			return true;
		}
		if (!mongoTemplate.exists(new Query(Criteria.where("id").is(value)), RoadType.class)) {
			ctx.unwrap(HibernateConstraintValidatorContext.class)
				.addExpressionVariable("id", value)
				.buildConstraintViolationWithTemplate("{validation.constraints.road-type.unknown.message}")
				.addConstraintViolation();
			return false;
		}
		return true;
	}

}