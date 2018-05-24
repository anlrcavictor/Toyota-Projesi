package dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.Kullanici;
import domain.Seyahat;

@Repository
public class SeyahatDAOImpl implements SeyahatDAO{

	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	
	@Override
	public List<Seyahat> getAllSeyahats() {

		TypedQuery<Seyahat> query = entityManager.createQuery("Select e from Seyahat e", Seyahat.class);
		return query.getResultList();
	}

	@Override
	public void addSeyahat(Seyahat seyahat) {
		//Hata veriyor..biderctional iliþkiden olabilir
		entityManager.getTransaction().begin();
		entityManager.persist(seyahat);
		entityManager.getTransaction().commit();
	}


	@Override
	public void updateSeyahat(Seyahat seyahat) {
		Seyahat foundSeyahat =getSeyahatById(seyahat.getId());
		System.out.println("DAO foundSeyahat = "+foundSeyahat );
		if(foundSeyahat!=null) {
			entityManager.getTransaction().begin();
			foundSeyahat.setSeyahatYeri(seyahat.getSeyahatYeri());
			foundSeyahat.setGidisAmaci(seyahat.getGidisAmaci());
			foundSeyahat.setBaslangic(seyahat.getBaslangic());
			foundSeyahat.setBitis(seyahat.getBitis());
			foundSeyahat.setMaliyet(seyahat.getMaliyet());
			foundSeyahat.setProjeKodu(seyahat.getProjeKodu());			
			entityManager.getTransaction().commit();
			
		}
	}


	@Override
	public void deleteSeyahat(int id) {
		Seyahat seyahat=getSeyahatById(id);
		if(seyahat!=null) {
			entityManager.getTransaction().begin();
			entityManager.remove(seyahat);
			entityManager.getTransaction().commit();
		}
		
	}


	@Override
	public Seyahat getSeyahatById(int id) {
		return entityManager.find(Seyahat.class, id);
	}


	@Override
	public List<Seyahat> getSeyahatSearchedByDateAndByUser(Date startDate, Date endDate, Kullanici user) {
		List<Seyahat> allSeyahats = entityManager.createQuery(
				"SELECT s FROM Seyahat s WHERE s.kullanici=:kul AND s.baslangic BETWEEN :startDate AND :endDate")
				.setParameter("kul", user).setParameter("startDate", startDate, TemporalType.DATE)
				.setParameter("endDate", endDate, TemporalType.DATE).getResultList();
		return allSeyahats;
	}


	@Override
	public List<Seyahat> getSeyahatSearchedByDate(Date startDate, Date endDate) {
		
		List<Seyahat> allSeyahats = entityManager.createQuery(
			    "SELECT s FROM Seyahat s WHERE s.baslangic BETWEEN :startDate AND :endDate")  
			  .setParameter("startDate", startDate, TemporalType.DATE)  
			  .setParameter("endDate", endDate, TemporalType.DATE)  
			  .getResultList();
			  return allSeyahats;
	}
	
	

}
