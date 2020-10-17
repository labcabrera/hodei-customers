package org.github.labcabrera.hodei.customers.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;
import org.github.labcabrera.hodei.customers.model.Address;
import org.github.labcabrera.hodei.customers.model.Province;
import org.github.labcabrera.hodei.customers.validation.annotation.ValidAddress;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;

public class AddressValidator implements ConstraintValidator<ValidAddress, Address> {

	private static final String PROVINCE = "province";
	private static final String ZIPCODE = "zipCode";

	@Autowired
	@Qualifier("mongoTemplateCommons")
	private MongoTemplate mongoTemplate;

	@Override
	public boolean isValid(Address address, ConstraintValidatorContext ctx) {
		ctx.disableDefaultConstraintViolation();
		boolean result = true;
		result &= validateProvince(address, ctx);
		return result;
	}

	// Solo exigimos la provincia para ESP. Seria mejor parametrizar la lista de paises
	private boolean validateProvince(Address address, ConstraintValidatorContext ctx) {
		boolean requiredProvince = "ESP".equals(address.getCountryId());
		boolean hasProvince = address.getProvinceId() != null;
		if (requiredProvince && !hasProvince) {
			ctx.buildConstraintViolationWithTemplate("{validation.constraints.address.required-province.message}")
				.addPropertyNode(PROVINCE)
				.addConstraintViolation();
			return false;
		}
		if (!hasProvince) {
			return true;
		}
		boolean valid = true;

		Province province = mongoTemplate.findById(address.getProvinceId(), Province.class);
		if (province == null) {
			ctx.unwrap(HibernateConstraintValidatorContext.class)
				.addExpressionVariable("id", address.getProvinceId())
				.buildConstraintViolationWithTemplate("{validation.constraints.address.unknown-province.message}")
				.addPropertyNode("province.id")
				.addConstraintViolation();
			return false;
		}
		if (requiredProvince && StringUtils.isNotBlank(address.getZipCode()) && address.getZipCode().length() > 1) {
			String prefix = address.getZipCode().substring(0, 2);
			if (!prefix.equals(province.getCode())) {
				ctx.unwrap(HibernateConstraintValidatorContext.class)
					.addExpressionVariable(ZIPCODE, address.getZipCode())
					.addExpressionVariable(PROVINCE, address.getProvinceId())
					.buildConstraintViolationWithTemplate("{validation.constraints.address.zipcode-not-match-province.message}")
					.addPropertyNode(ZIPCODE)
					.addConstraintViolation();
				valid = false;
			}
		}
		return valid;
	}

}