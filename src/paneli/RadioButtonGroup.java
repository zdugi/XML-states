package paneli;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

import model.komponente.Komponenta;

public class RadioButtonGroup extends Group {

	ArrayList<RadioButton> radioButtons;
	
	public RadioButtonGroup(Komponenta komponenta, ButtonGroup buttonGroup) {
		super(komponenta, buttonGroup);
		radioButtons = new ArrayList<RadioButton>();
	}
	
	public void DodajCheckBox(RadioButton radioButton) {
		
		radioButtons.add(radioButton);
		add(radioButton);
	}
	
	public void ObrisiCheckBox(RadioButton radioButton) {
		
		radioButtons.remove(radioButton);
		remove(radioButton);
	}
}
