package javacommunity.airlinetravel.validator;

import javacommunity.airlinetravel.form.FlightForm;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FlightFormValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return FlightForm.class.equals(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		FlightForm fligthForm = (FlightForm)obj;
		if(StringUtils.isEmpty(fligthForm.getFlightNo())) {
			errors.reject("flightNo", "Must be not empty");
		}
		
	}

}
