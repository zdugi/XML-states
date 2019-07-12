package model.komponente;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JRadioButton;

import enums.VrstaKomponente;

public class GroupKomponenta extends Komponenta{
	private ArrayList<String> dugmici;
	
	public GroupKomponenta(String naziv, VrstaKomponente tip)
	{
		super(naziv, tip);
		dugmici = new ArrayList<String>();
	}

	public ArrayList<String> getDugmici() {
		return dugmici;
	}

	public void setDugmici(ArrayList<String> dugmici) {
		this.dugmici = dugmici;
	}
	
	public String toString()
	{
		return dugmici.get(0);
	}
}
