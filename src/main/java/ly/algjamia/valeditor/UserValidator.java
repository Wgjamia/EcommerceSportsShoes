package ly.algjamia.valeditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ly.algjamia.model.Users;
import ly.algjamia.services.UserService;

@Component
public class UserValidator implements Validator {
	@Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return Users.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Users users = (Users) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        if (users.getUsername().length() < 2 || users.getUsername().length() > 32) {
            errors.rejectValue("username", "Size.userForm.username");
        }
        if (userService.findByUsername(users.getUsername()) != null) {
            errors.rejectValue("username", "Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (users.getPassword().length() < 2 || users.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }

       
    }
}