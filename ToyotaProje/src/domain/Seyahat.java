package domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Seyahat {

	@Id
	@TableGenerator(name="SEY_GEN")
	@GeneratedValue(generator="SEY_GEN")
	private int id;
	private String seyahatYeri;
	private String gidisAmaci;
	private String projeKodu;
	private String  maliyet;
	
	@Transient
	private String transBaslangic;
	@Temporal(TemporalType.DATE)
	private Date baslangic;
	
	@Transient
	private  String transBitis;
	@Temporal(TemporalType.DATE)
	private Date bitis;
	
	@Transient
	private String kullaniciAdi;
	
	@ManyToOne
	@JoinColumn(name="KUL_ID")
	private Kullanici kullanici;
	
	

	public Seyahat() {
		super();
	}

	public Seyahat(String seyahatYeri, String gidisAmaci, String projeKodu, String maliyet, Date baslangic, Date bitis,
			Kullanici kullanici,String kullaniciAdi) {
		super();
		this.seyahatYeri = seyahatYeri;
		this.gidisAmaci = gidisAmaci;
		this.projeKodu = projeKodu;
		this.maliyet = maliyet;
		this.baslangic = baslangic;
		this.bitis = bitis;
		this.kullanici = kullanici;
		this.kullaniciAdi=kullaniciAdi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSeyahatYeri() {
		return seyahatYeri;
	}

	public void setSeyahatYeri(String seyahatYeri) {
		this.seyahatYeri = seyahatYeri;
	}

	public String getGidisAmaci() {
		return gidisAmaci;
	}

	public void setGidisAmaci(String gidisAmaci) {
		this.gidisAmaci = gidisAmaci;
	}

	public String getProjeKodu() {
		return projeKodu;
	}

	public void setProjeKodu(String projeKodu) {
		this.projeKodu = projeKodu;
	}

	public String getMaliyet() {
		return maliyet;
	}

	public void setMaliyet(String maliyet) {
		this.maliyet = maliyet;
	}

	public Date getBaslangic() {
		return baslangic;
	}

	public void setBaslangic(Date baslangic) {
		this.baslangic = baslangic;
	}

	public Date getBitis() {
		return bitis;
	}

	public void setBitis(Date bitis) {
		this.bitis = bitis;
	}
	
	public String getTransBaslangic() {
		return transBaslangic;
	}

	public void setTransBaslangic(String transBaslangic) {
		this.transBaslangic = transBaslangic;
	}

	public String getTransBitis() {
		return transBitis;
	}

	public void setTransBitis(String transBitis) {
		this.transBitis = transBitis;
	}

	public Kullanici getKullanici() {
		return kullanici;
	}

	public void setKullanici(Kullanici kullanici) {
		this.kullanici = kullanici;
	}
	
	public String getKullaniciAdi() {
		return kullaniciAdi;
	}

	public void setKullaniciAdi(String kullaniciAdi) {
		this.kullaniciAdi = kullaniciAdi;
	}

	@Override
	public String toString() {
		return "Seyahat [id=" + id + ", seyahatYeri=" + seyahatYeri + ", gidisAmaci=" + gidisAmaci + ", projeKodu="
				+ projeKodu + ", maliyet=" + maliyet + ", transBaslangic=" + transBaslangic + ", baslangic=" + baslangic
				+ ", transBitis=" + transBitis + ", bitis=" + bitis + ", kullaniciAdi=" + kullaniciAdi + ", kullanici="
				+ kullanici + "]";
	}

	
	
	
	
	
}
