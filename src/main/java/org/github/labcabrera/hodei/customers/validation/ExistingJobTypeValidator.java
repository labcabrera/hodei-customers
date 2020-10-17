package org.github.labcabrera.hodei.customers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.github.labcabrera.hodei.customers.model.JobType;
import org.github.labcabrera.hodei.customers.validation.annotation.ExistingJobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class ExistingJobTypeValidator implements ConstraintValidator<ExistingJobType, String> {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		context.disableDefaultConstraintViolation();
		if (value == null) {
			return true;
		}
		else if (StringUtils.isBlank(value)) {
			context.buildConstraintViolationWithTemplate("missingJobTypeId").addConstraintViolation();
			return false;
		}
		else if (!mongoTemplate.exists(new Query(Criteria.where("id").is(value)), JobType.class)) {
			context.buildConstraintViolationWithTemplate("unknownJobType").addConstraintViolation();
			return false;
		}
		return true;
	}

}
