package paneli;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

import model.komponente.GroupKomponenta;

public class RadioButtonGroup extends Group {

	public ArrayList<RadioButton> radioButtons;
	
	public RadioButtonGroup(GroupKomponenta komponenta, ButtonGroup buttonGroup) {
		super(komponenta, buttonGroup);
		radioButtons = new ArrayList<RadioButton>();
	}
	
	public void DodajRadioButton(RadioButton radioButton) {
		super.getButtonGroup().add(radioButton.getRadioButton());
		radioButtons.add(radioButton);
		((GroupKomponenta) komponenta).getDugmici().add(radioButton.getKomponenta().getNaziv());
		add(radioButton);
	}
	
	public void ObrisiRadioButton(RadioButton radioButton) {
		super.getButtonGroup().remove(radioButton.getRadioButton());
		radioButtons.remove(radioButton);
		((GroupKomponenta) komponenta).getDugmici().remove(radioButton.getKomponenta().getNaziv());
		remove(radioButton);
	}
}
