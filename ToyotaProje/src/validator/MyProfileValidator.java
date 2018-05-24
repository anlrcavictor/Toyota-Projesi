package validator;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import domain.Kullanici;


@Component
public class MyProfileValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Kullanici user=(Kullanici) target;
		
		
		
		if(user.getKullaniciAdi().length()<=0 || user.getKullaniciAdi().length()>50) {
			errors.rejectValue("kullaniciAdi", "required.notNull");
		}
		
		if(user.getSicilNo().length()<=0 || user.getSicilNo().length()>50) {
			errors.rejectValue("sicilNo", "required.notNull");
		}
		
		if(user.getSifre()!=null) {
			if(user.getSifre().length()<=0 || user.getSifre().length()>50) {
				errors.rejectValue("sifre", "required.sifre");
			}
		}
		
		if(user.getBolum().length()<=0 || user.getBolum().length()>50) {
			errors.rejectValue("bolum", "required.notNull");
		}
		
		if(user.getMudurAdi().length()<=0 || user.getMudurAdi().length()>50) {
			errors.rejectValue("mudurAdi", "required.notNull");
		}
		
		
		
		
	}

}
