package model.komponente;

import enums.VrstaKomponente;

public class Komponenta {
	private String naziv;
	private String komponentaId;
	private VrstaKomponente tip;
	
	 public Komponenta(String naziv, VrstaKomponente vrsta)
	 {
		 this.naziv = naziv;
		 this.tip = vrsta;
		 this.komponentaId = naziv + tip;
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

	public VrstaKomponente getTip() {
		return tip;
	}

	public void setTip(VrstaKomponente tip) {
		this.tip = tip;
	}
}
