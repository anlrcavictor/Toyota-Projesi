package service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.KullaniciDAOImpl;
import domain.Kullanici;
import domain.Role;
import formModel.LoginModel;


@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private KullaniciDAOImpl kullaniciDao; 
	
	
	public int loginUsernameControl(LoginModel loginModel,HttpServletRequest request) {
		
		//T�m kullan�c�lar� de�ilde t�m kullan�c�lar�n username ve password lar�n� getirirsen daha h�zl� �al���r sonra yapmay� dene
		for(Kullanici user:kullaniciDao.getKullanicis()) {
			if(loginModel.getUsername().equals(user.getKullaniciAdi())) {
				if(loginModel.getPassword().equals(user.getSifre())) {
					request.getSession().setAttribute("name", user.getKullaniciAdi());
					request.getSession().setAttribute("userId", user.getId());
					if(user.getRol()==Role.ADMIN) {
						request.getSession().setAttribute("authority", "admin");
						return 1;
					}
					else {
						request.getSession().setAttribute("authority", "user");
						return 0;
					}
				}
					
			}
		}
		request.setAttribute("errorMessage", "Yanl�� Kullan�c� Ad� veya �ifre");
		return 2;
	}


	@Override
	public void logOut(HttpServletRequest request) {
		
		HttpSession session=request.getSession();
		session.removeAttribute("name");
		session.removeAttribute("userId");
		session.removeAttribute("authority");
		session.invalidate();
		System.out.println("Session U�tu!!!");
	}
	
	
}
