package model;

import enums.VrstaAkcije;

public class Akcija {
	
	private int id;
	private VrstaAkcije vrsta;
	public Akcija()
	{
		
	}
	public Akcija(VrstaAkcije vrsta)
	{
		this.vrsta = vrsta;
		id = 0;
		while(VrstaAkcije.values()[id] != vrsta)
		{
			id++;
		}
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public VrstaAkcije getVrsta() {
		return vrsta;
	}
	public void setVrsta(VrstaAkcije vrsta) {
		this.vrsta = vrsta;
	}
	

}
