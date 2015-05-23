package javacommunity.airlinetravel.validator;

import javacommunity.airlinetravel.validator.constrains.FlightNoConstrains;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class FlightNoValidator implements
		ConstraintValidator<FlightNoConstrains, String> {

	private boolean isValid(String data) {
		return data.matches("[A-Z]{3}-[0-9]{5}");
	}

	@Override
	public void initialize(FlightNoConstrains arg0) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext arg1) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}
		return isValid(value);

	}

}
