package model.komponente;

import javax.swing.JTextField;

import enums.VrstaKomponente;

public class TextFieldComp extends Komponenta{
	JTextField textField;
	
	public TextFieldComp(String naziv, VrstaKomponente tip) {
		super(naziv, tip);
	}
	
	public JTextField getTextField()
	{
		return textField;
	}
	
	
}
