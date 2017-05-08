package converter;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("nameConverter")
public class NameConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		FullName fullName;
		FacesMessage msg;
		String[] parts = value.split(" ");
			if(parts.length != 2){
				msg = new FacesMessage("Name conversion error.", "Please input first name and last name.");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ConverterException(msg);}
			fullName = new FullName();
			fullName.setFirstName(parts[0]);
			fullName.setLastName(parts[1]);
		return fullName;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent c, Object value) {
		return value.toString();
	}
	

}
