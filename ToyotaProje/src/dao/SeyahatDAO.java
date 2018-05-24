package dao;

import java.util.Date;
import java.util.List;

import domain.Kullanici;
import domain.Seyahat;

public interface SeyahatDAO {

	public List<Seyahat> getAllSeyahats();
	
	public void addSeyahat(Seyahat seyahat);
	
	public Seyahat getSeyahatById(int id);
	
	public void updateSeyahat(Seyahat seyahat);
	
	public void deleteSeyahat(int id);
	
	public List<Seyahat> getSeyahatSearchedByDateAndByUser(Date startDate, Date endDate,Kullanici user); 
	
	public List<Seyahat> getSeyahatSearchedByDate(Date startDate, Date endDate); 
	
}
