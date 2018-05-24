package validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import formModel.SearchSeyahat;
import utility.Utility;

@Component
public class SearchDateValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		SearchSeyahat searchSeyahat=(SearchSeyahat)target;
		
		if(searchSeyahat.getStartDate().length()<=0 ) {
			errors.rejectValue("startDate", "required.transBaslangic");
		}
		
		if(searchSeyahat.getFinishDate().length()<=0 ) {
			errors.rejectValue("finishDate", "required.transBitis");
		}
		
		if(searchSeyahat.getStartDate().length()>0 && searchSeyahat.getFinishDate().length()>0) {
		
			Date baslangic=Utility.convertFromStringToDate(searchSeyahat.getStartDate());
			Date bitis=Utility.convertFromStringToDate(searchSeyahat.getFinishDate());
		
		if(bitis.getTime() <= baslangic.getTime()) {
			errors.rejectValue("finishDate", "incorrect.transBitis");
			}
		
		}
		
	}

	
	
}
