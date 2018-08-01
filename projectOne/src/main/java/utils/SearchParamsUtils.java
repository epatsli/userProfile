package utils;

import org.springframework.lang.NonNull;

import project.to.FilterUserTO;

public class SearchParamsUtils {

	public static int countFilterUserParamsSum(@NonNull final FilterUserTO filterUser) {
		int sum = 0;

		if (filterUser.getFirstName() != null && !filterUser.getFirstName().isEmpty()) {
			sum += 1;
		}
		if (filterUser.getLastName() != null && !filterUser.getLastName().isEmpty()) {
			sum += 2;
		}
		if (filterUser.getPlayability() != null && !filterUser.getPlayability().isEmpty()) {
			sum += 4;
		}

		return sum;
	}
}
