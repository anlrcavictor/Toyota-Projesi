package service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.KullaniciDAOImpl;
import dao.SeyahatDAOImpl;
import domain.Kullanici;
import domain.Seyahat;
import formModel.SearchSeyahat;
import utility.Utility;

@Service
public class SeyahatServiceImpl implements SeyahatService {

	@Autowired
	private SeyahatDAOImpl seyahatDao;
	
	@Autowired
	private KullaniciDAOImpl kullaniciDao;
	
	
	@Override
	public List<Seyahat> getAllSeyahats() {
		return seyahatDao.getAllSeyahats();
	}

	@Override
	public void addSeyahat(Seyahat seyahat) {
		Kullanici user= kullaniciDao.getKullaniciByName(seyahat.getKullaniciAdi());
		// bidiaractional
		seyahat.setKullanici(user);
		user.getSeyahats().add(seyahat);
		
		seyahat.setBaslangic(Utility.convertFromStringToDate(seyahat.getTransBaslangic()));
		seyahat.setBitis(Utility.convertFromStringToDate(seyahat.getTransBitis()));
		seyahatDao.addSeyahat(seyahat);
	}

	@Override
	public Seyahat getSeyahatById(int id) {
		
		return seyahatDao.getSeyahatById(id);
	}

	@Override
	public void updateSeyahat(Seyahat seyahat) {
		seyahat.setBaslangic(Utility.convertFromStringToDate(seyahat.getTransBaslangic()));
		seyahat.setBitis(Utility.convertFromStringToDate(seyahat.getTransBitis()));
		seyahatDao.updateSeyahat(seyahat);
		
	}

	@Override
	public void deleteSeyahat(int id) {
		seyahatDao.deleteSeyahat(id);
		
	}

	@Override
	public List<Seyahat> formatToSeyahatList(List<Seyahat> seyahatList) {
		List<Seyahat> formattedSeyahats=seyahatList;
		for(Seyahat s : formattedSeyahats) {
			s.setTransBaslangic(Utility.convertFromDateToString(s.getBaslangic()));
			s.setTransBitis(Utility.convertFromDateToString(s.getBitis()));
		}
		return formattedSeyahats;
	}

	@Override
	public Seyahat getSeyahatByIdForUpdate(int id) {

		Seyahat seyahat =getSeyahatById(id);
		seyahat.setTransBaslangic(Utility.convertFromDateToStringForUpdate(seyahat.getBaslangic()));
		seyahat.setTransBitis(Utility.convertFromDateToStringForUpdate(seyahat.getBitis()));
		return seyahat;
	}

	@Override
	public List<Seyahat> searchSeyahat(SearchSeyahat searchSeyahat) {
		
		Date startDate=Utility.convertFromStringToDate(searchSeyahat.getStartDate());
		Date finishDate=Utility.convertFromStringToDate(searchSeyahat.getFinishDate());
		Kullanici user= kullaniciDao.getKullaniciByName(searchSeyahat.getUsername());

		return formatToSeyahatList(seyahatDao.getSeyahatSearchedByDateAndByUser(startDate, finishDate, user));
		}

	@Override
	public List<Seyahat> getAllSeyahatLastXMonth(int month) {
		int year=4; //listelenecek seyahatlerin gelecekteki 4 yýl içinde olanlar ve geçmiþ parametre olarak alýnan ay sayýsý aralýðýnda olanlar listelenir  
		return formatToSeyahatList(seyahatDao.getSeyahatSearchedByDate(Utility.SubMonthNow(month), Utility.AddYearNow(year)));
	}
	
	// ------------------------- Only For User Controller ---------------------------------

	@Override
	public List<Seyahat> getMySeyahatList(int month, int id) {
		Kullanici user= kullaniciDao.getKullaniciById(id);
		int year=4;
		return formatToSeyahatList(seyahatDao.getSeyahatSearchedByDateAndByUser(Utility.SubMonthNow(month), Utility.AddYearNow(year), user));
	}
	

	
	
	
}
