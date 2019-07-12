package model;

import enums.TipStanja;
import model.komponente.Komponenta;

public class State {
	private int stanjeId;
	private TipStanja tipStanja;
	private String nazivStanja;
	   
	public java.util.Collection<Komponenta> delete_list;
	public java.util.Collection<Komponenta> hide_list;
	public java.util.Collection<Komponenta> mandatory_list;
	public java.util.List<Tranzicija> tranzicija;
	public int getStanjeId() {
		return stanjeId;
	}
	public void setStanjeId(int stanjeId) {
		this.stanjeId = stanjeId;
	}
	public TipStanja getTipStanja() {
		return tipStanja;
	}
	public void setTipStanja(TipStanja tipStanja) {
		this.tipStanja = tipStanja;
	}
	public String getNazivStanja() {
		return nazivStanja;
	}
	public void setNazivStanja(String nazivStanja) {
		this.nazivStanja = nazivStanja;
	}
	public java.util.Collection<Komponenta> getDelete_list() {
		return delete_list;
	}
	public void setDelete_list(java.util.Collection<Komponenta> delete_list) {
		this.delete_list = delete_list;
	}
	public java.util.Collection<Komponenta> getHide_list() {
		return hide_list;
	}
	public void setHide_list(java.util.Collection<Komponenta> hide_list) {
		this.hide_list = hide_list;
	}
	public java.util.Collection<Komponenta> getMandatory_list() {
		return mandatory_list;
	}
	public void setMandatory_list(java.util.Collection<Komponenta> mandatory_list) {
		this.mandatory_list = mandatory_list;
	}
	public java.util.List<Tranzicija> getTranzicija() {
		return tranzicija;
	}
	public void setTranzicija(java.util.List<Tranzicija> tranzicija) {
		this.tranzicija = tranzicija;
	}
	
	
}
