package validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.Seyahat;
import utility.Utility;

@Component
public class SeyahatValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Seyahat seyahat=(Seyahat) target;
		
		
		
		if(seyahat.getTransBaslangic().length()<=0 ) {
			errors.rejectValue("transBaslangic", "required.transBaslangic");
		}
		
		if(seyahat.getTransBitis().length()<=0 ) {
			errors.rejectValue("transBitis", "required.transBitis");
		}
		
		if(seyahat.getTransBaslangic().length()>0 && seyahat.getTransBitis().length()>0) {
		
			Date baslangic=Utility.convertFromStringToDate(seyahat.getTransBaslangic());
			Date bitis=Utility.convertFromStringToDate(seyahat.getTransBitis());
		
		if(bitis.getTime() <= baslangic.getTime()) {
			errors.rejectValue("transBitis", "incorrect.transBitis");
			}
		
		}
		
		if(seyahat.getSeyahatYeri().length()<=0 || seyahat.getSeyahatYeri().length()>50) {
			errors.rejectValue("seyahatYeri", "required.seyahatYeri");
		}
		
		if(seyahat.getGidisAmaci().length()<=0 || seyahat.getGidisAmaci().length()>50) {
			errors.rejectValue("gidisAmaci", "required.gidisAmaci");
		}
		
		
		
		
		
		
	}

}
