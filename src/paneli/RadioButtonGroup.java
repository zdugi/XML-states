package paneli;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

import model.komponente.Komponenta;

public class RadioButtonGroup extends Group {

	public ArrayList<RadioButton> radioButtons;
	
	public RadioButtonGroup(Komponenta komponenta, ButtonGroup buttonGroup) {
		super(komponenta, buttonGroup);
		radioButtons = new ArrayList<RadioButton>();
	}
	
	public void DodajRadioButton(RadioButton radioButton) {
		super.getButtonGroup().add(radioButton.getRadioButton());
		radioButtons.add(radioButton);
		add(radioButton);
	}
	
	public void ObrisiRadioButton(RadioButton radioButton) {
		super.getButtonGroup().remove(radioButton.getRadioButton());
		radioButtons.remove(radioButton);
		remove(radioButton);
	}
}
