package domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.TableGenerator;

@Entity
public class Kullanici {

	@Id
	@TableGenerator(name="KUL_GEN")
	@GeneratedValue(generator="KUL_GEN")
	private int id;
	
	private String kullaniciAdi;
	private String sicilNo;
	private String sifre;
	private String bolum;
	private String mudurAdi;
	
	private Role rol;
	
	private Servis bilgilendirmeServisi;
	
	private SeyahatSistemi seyahatSistemi;
	
	private Gunler bilgilendirmeGunu;
	
	@OneToMany(mappedBy="kullanici")
	private Collection<Seyahat> seyahats;

	public Kullanici() {
		super();
	}

	

	public Kullanici(String kullaniciAdi, String sicilNo, String sifre, String bolum, String mudurAdi, Role rol,
			Servis bilgilendirmeServisi, SeyahatSistemi seyahatSistemi, Gunler bilgilendirmeGunu,
			Collection<Seyahat> seyahats) {
		super();
		this.kullaniciAdi = kullaniciAdi;
		this.sicilNo = sicilNo;
		this.sifre = sifre;
		this.bolum = bolum;
		this.mudurAdi = mudurAdi;
		this.rol = rol;
		this.bilgilendirmeServisi = bilgilendirmeServisi;
		this.seyahatSistemi = seyahatSistemi;
		this.bilgilendirmeGunu = bilgilendirmeGunu;
		this.seyahats = seyahats;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	public String getSicilNo() {
		return sicilNo;
	}

	public void setSicilNo(String sicilNo) {
		this.sicilNo = sicilNo;
	}

	public String getSifre() {
		return sifre;
	}

	public void setSifre(String sifre) {
		this.sifre = sifre;
	}

	public String getBolum() {
		return bolum;
	}

	public void setBolum(String bolum) {
		this.bolum = bolum;
	}

	public String getMudurAdi() {
		return mudurAdi;
	}

	public void setMudurAdi(String mudurAdi) {
		this.mudurAdi = mudurAdi;
	}

	public Role getRol() {
		return rol;
	}

	public void setRol(Role rol) {
		this.rol = rol;
	}

	public Servis getBilgilendirmeServisi() {
		return bilgilendirmeServisi;
	}

	public void setBilgilendirmeServisi(Servis bilgilendirmeServisi) {
		this.bilgilendirmeServisi = bilgilendirmeServisi;
	}

	public SeyahatSistemi getSeyahatSistemi() {
		return seyahatSistemi;
	}

	public void setSeyahatSistemi(SeyahatSistemi seyahatSistemi) {
		this.seyahatSistemi = seyahatSistemi;
	}

	public Gunler getBilgilendirmeGunu() {
		return bilgilendirmeGunu;
	}

	public void setBilgilendirmeGunu(Gunler bilgilendirmeGunu) {
		this.bilgilendirmeGunu = bilgilendirmeGunu;
	}
	

	public Collection<Seyahat> getSeyahats() {
		return seyahats;
	}



	public void setSeyahats(Collection<Seyahat> seyahats) {
		this.seyahats = seyahats;
	}



	@Override
	public String toString() {
		return "Kullanici [id=" + id + ", kullaniciAdi=" + kullaniciAdi + ", sicilNo=" + sicilNo + ", sifre=" + sifre
				+ ", bolum=" + bolum + ", mudurAdi=" + mudurAdi + ", rol=" + rol + ", bilgilendirmeServisi="
				+ bilgilendirmeServisi + ", seyahatSistemi=" + seyahatSistemi + ", bilgilendirmeGunu="
				+ bilgilendirmeGunu + "]";
	} 
	
	
	
	
	
}
