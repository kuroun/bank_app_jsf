package validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import converter.FullName;

@FacesValidator("fullNameValidator")
public class NameValidator implements Validator{

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		FullName fullName = (FullName) value;
		FacesMessage msg;
		if(fullName == null){
			msg = new FacesMessage("Error validation.", "Name object is null");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		if(fullName.getFirstName().isEmpty() || fullName.getLastName().isEmpty()){
			msg = new FacesMessage("Error validation.", "First name or last name is empty.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
		if(fullName.getFirstName().matches(".*\\d+.*") || fullName.getLastName().matches(".*\\d+.*")){
			msg = new FacesMessage("Error validation.", "First name or last name must contain only letters.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}

}
