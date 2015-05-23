package javacommunity.airlinetravel.validator.constrains;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javacommunity.airlinetravel.validator.FlightNoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = FlightNoValidator.class)
public @ interface FlightNoConstrains {
	String message() default "Must be matched [A-Z]{3}-[5]. Ex: VNA-13245";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
