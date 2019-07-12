package model.komponente;

import enums.VrstaKomponente;

public class Komponenta {
	private String naziv;
	private String komponentaId;
	
	 public Komponenta(String naziv)
	 {
		 this.naziv = naziv;
		 this.komponentaId = naziv;
	 }
	   
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getKomponentaId() {
		return komponentaId;
	}
	public void setKomponentaId(String komponentaId) {
		this.komponentaId = komponentaId;
	}
}
