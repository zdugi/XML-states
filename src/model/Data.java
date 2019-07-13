package model;

import java.util.ArrayList;

public class Data {
	private ArrayList<Tranzicija> tranzicija;
	private ArrayList<State> stanje;
	private Dokument dokument;
	
	public Data()
	{
		dokument = new Dokument();
		stanje = new ArrayList<State>();
		tranzicija = new ArrayList<Tranzicija>();
	}

	public Dokument getDokument() {
		return dokument;
	}

	public void setDokument(Dokument dokument) {
		this.dokument = dokument;
	}

	public ArrayList<Tranzicija> getTranzicija() {
		return tranzicija;
	}

	public void setTranzicija(ArrayList<Tranzicija> tranzicija) {
		this.tranzicija = tranzicija;
	}

	public ArrayList<State> getStanje() {
		return stanje;
	}

	public void setStanje(ArrayList<State> stanje) {
		this.stanje = stanje;
	}
	
	
	
}
