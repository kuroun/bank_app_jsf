package validator;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import model.Account;
import service.AccountService;

//@Inject
//@FacesValidator("accountNumberValidator")
@ManagedBean
public class AccountNumberValidator implements Validator {
	
//	@Inject
//	AccountService accountService;
//	CDI injection is not compatible with this project, so using managed bean injection instead
	
	@ManagedProperty(value="#{accountService}")
	AccountService accountService;
	
	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		
//		accountDAO = AccountService.getInstance();
		Account found = accountService.searchAccount((Long) value);
//		if(accountDAO !=null){ found = accountDAO.loadAccount((Long) value);}
		if(found != null){
			FacesMessage msg = new FacesMessage("Validation error.", "Account number already exists.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}
	}
	
	// This setter method is needed in order to make managed bean work
	public void setAccountService(AccountService as){
		this.accountService = as;
	}

}
