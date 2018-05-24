package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import domain.Kullanici;

@Repository
public class KullaniciDAOImpl implements KullaniciDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public void addKullanici(Kullanici user) {

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		
	}

	@Override
	public List<Kullanici> getKullanicis() {

		TypedQuery<Kullanici> query = entityManager.createQuery("Select e from Kullanici e", Kullanici.class);
		return query.getResultList();
	}

	@Override
	public Kullanici getKullaniciById(int id) {
		return entityManager.find(Kullanici.class, id);
	}

	@Override
	public void updateKullanici(Kullanici user) {
		Kullanici foundKullanici=getKullaniciById(user.getId());
		if(foundKullanici != null) {
			entityManager.getTransaction().begin();
			foundKullanici.setKullaniciAdi(user.getKullaniciAdi());
			foundKullanici.setSicilNo(user.getSicilNo());
			foundKullanici.setBolum(user.getBolum());
			foundKullanici.setMudurAdi(user.getMudurAdi());
			foundKullanici.setRol(user.getRol());
			foundKullanici.setBilgilendirmeServisi(user.getBilgilendirmeServisi());
			foundKullanici.setSeyahatSistemi(user.getSeyahatSistemi());
			foundKullanici.setBilgilendirmeGunu(user.getBilgilendirmeGunu());
			entityManager.getTransaction().commit();
			
			
		}
		
	}

	@Override
	public void deleteKullanici(int id) {
		Kullanici kullanici = getKullaniciById(id);
		if(kullanici != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(kullanici);
			entityManager.getTransaction().commit();
		}
		
	}
	
	@Override
	public Kullanici getKullaniciByName(String name) {
		TypedQuery<Kullanici> query = entityManager.createQuery("Select k from Kullanici k where k.kullaniciAdi= ?1",
				 Kullanici.class).setParameter(1, name);
		return query.getSingleResult();
		
	}

	@Override
	public void updateMyProfile(Kullanici user) {
		
		Kullanici foundKullanici=getKullaniciById(user.getId());
		if(foundKullanici != null) {
			entityManager.getTransaction().begin();
			foundKullanici.setKullaniciAdi(user.getKullaniciAdi());
			foundKullanici.setSicilNo(user.getSicilNo());
			foundKullanici.setSifre(user.getSifre());
			foundKullanici.setBolum(user.getBolum());
			foundKullanici.setMudurAdi(user.getMudurAdi());
			foundKullanici.setBilgilendirmeServisi(user.getBilgilendirmeServisi());
			foundKullanici.setSeyahatSistemi(user.getSeyahatSistemi());
			foundKullanici.setBilgilendirmeGunu(user.getBilgilendirmeGunu());
			entityManager.getTransaction().commit();
		}
	}

}
