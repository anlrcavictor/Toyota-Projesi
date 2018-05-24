package service;

import java.util.List;

import domain.Seyahat;
import formModel.SearchSeyahat;

public interface SeyahatService {
	
	
	
	public List<Seyahat> getAllSeyahats();
	
	public void addSeyahat(Seyahat seyahat);
	
	public Seyahat getSeyahatById(int id);
	
	public Seyahat getSeyahatByIdForUpdate(int id);
	
	public void updateSeyahat(Seyahat seyahat);
	
	public void deleteSeyahat(int id);
	
	public List<Seyahat> formatToSeyahatList(List<Seyahat> seyahatList);
	
	public List<Seyahat> searchSeyahat(SearchSeyahat searchSeyahat);
	
	public List<Seyahat> getAllSeyahatLastXMonth(int month);
	
	//-----------------Only for User Controller ---------------------------
	
	public List<Seyahat> getMySeyahatList(int month, int id);
	
	
}
