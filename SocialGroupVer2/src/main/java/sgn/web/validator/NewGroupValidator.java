package sgn.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sgn.model.Group;



@Component
public class NewGroupValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Group.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		Group group = (Group)target;
		
		if(!StringUtils.hasText(group.getCategory())){
			errors.rejectValue("category","error.group.category.empty");
		}
		
		if(!StringUtils.hasText(group.getGroupName())){
			errors.rejectValue("groupName","error.group.groupName.empty");
		}
		
		
		
	}

	
	
	
	
}
