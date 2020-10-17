package org.github.labcabrera.hodei.customers.serialization;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class RoleManagerFilter {

	private static final String REQUIRED_ROLE = "role-extended-model";

	@Override
	public boolean equals(Object obj) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}
		return authentication.getAuthorities().stream().map(e -> e.getAuthority()).filter(e -> REQUIRED_ROLE.equals(e)).count() == 0L;
	}

	@Override
	public int hashCode() {
		return SecurityContextHolder.getContext() != null && SecurityContextHolder.getContext().getAuthentication() != null
			? SecurityContextHolder.getContext().getAuthentication().hashCode()
			: 0;
	}
}