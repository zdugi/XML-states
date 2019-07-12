package model;

import java.util.ArrayList;

import model.komponente.Komponenta;

public class Dokument {
	
	private String title;   
	public ArrayList<Komponenta> komponente;
	
	public Dokument()
	{
		komponente = new ArrayList<Komponenta>();
		this.title = "Default name";
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Komponenta> getKomponente() {
		return komponente;
	}
	public void setKomponente(ArrayList<Komponenta> komponente) {
		this.komponente = komponente;
	}
	
	
}
