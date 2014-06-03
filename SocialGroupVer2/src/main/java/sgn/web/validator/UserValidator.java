package sgn.web.validator;

//import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import sgn.model.User;

@Component
public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		User user = (User) target;
		if(!StringUtils.hasText(user.getEmail())){
			errors.rejectValue("email", "error.user.email.empty");
		}
		
		if(!StringUtils.hasText(user.getPassword()))
			errors.rejectValue("password", "error.user.password.empty");
		
		if(!StringUtils.hasText(user.getFirstName()))
			errors.rejectValue("firstName", "error.user.firstName.empty");
		
		if(!StringUtils.hasText(user.getLastName()))
			errors.rejectValue("lastName", "error.user.lastName.empty");
	}

}
