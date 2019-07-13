package model;

import java.util.ArrayList;
import java.util.HashMap;

import enums.TipStanja;
import model.komponente.Komponenta;

public class State {
	private String stanjeId;
	private TipStanja tipStanja;
	private String nazivStanja;
	   
	private ArrayList<Komponenta> delete_list;
	private ArrayList<Komponenta> hide_list;
	private ArrayList<Komponenta> mandatory_list;
	private HashMap<Akcija, Tranzicija> tranzicija;
	private ArrayList<Akcija> akcije;
	
	public State()
	{
		
	}
	public State(TipStanja tipStanja, String naziv)
	{
		this.stanjeId = naziv + tipStanja;
		this.tipStanja = tipStanja;
		this.nazivStanja = naziv;
		
		delete_list = new ArrayList<Komponenta>();
		hide_list = new ArrayList<Komponenta>();
		mandatory_list = new ArrayList<Komponenta>();
		tranzicija = new HashMap<Akcija, Tranzicija>();
		akcije = new ArrayList<Akcija>();
	}
	public String getStanjeId() {
		return stanjeId;
	}
	public void setStanjeId(String stanjeId) {
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
	public ArrayList<Komponenta> getDelete_list() {
		return delete_list;
	}
	public void setDelete_list(ArrayList<Komponenta> delete_list) {
		this.delete_list = delete_list;
	}
	public ArrayList<Komponenta> getHide_list() {
		return hide_list;
	}
	public void setHide_list(ArrayList<Komponenta> hide_list) {
		this.hide_list = hide_list;
	}
	public ArrayList<Komponenta> getMandatory_list() {
		return mandatory_list;
	}
	public void setMandatory_list(ArrayList<Komponenta> mandatory_list) {
		this.mandatory_list = mandatory_list;
	}
	/*public ArrayList<Tranzicija> getTranzicija() {
		return tranzicija;
	}
	public void setTranzicija(ArrayList<Tranzicija> tranzicija) {
		this.tranzicija = tranzicija;
	}*/
	public HashMap<Akcija, Tranzicija> getTranzicija() {
		return tranzicija;
	}
	public void setTranzicija(HashMap<Akcija, Tranzicija> tranzicija) {
		this.tranzicija = tranzicija;
	}
	public ArrayList<Akcija> getAkcije() {
		return akcije;
	}
	
	public void setAkcije(ArrayList<Akcija> akcije) {
		this.akcije = akcije;
	}
	@Override
	public String toString() {
		return nazivStanja;
	}
	
	
	
	
}
