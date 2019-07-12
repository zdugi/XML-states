package paneli;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

import model.komponente.Komponenta;

public class CheckBoxGroup extends Group {
	
	ArrayList<CheckBox> checkBoxs;
	
	public CheckBoxGroup(Komponenta komponenta, ButtonGroup buttonGroup) {
		super(komponenta, buttonGroup);
		checkBoxs = new ArrayList<CheckBox>();
	}
	
	public void DodajCheckBox(CheckBox checkBox) {
		
		checkBoxs.add(checkBox);
		add(checkBox);
	}
	
	public void ObrisiCheckBox(CheckBox checkBox) {
		
		checkBoxs.remove(checkBox);
		remove(checkBox);
	}
}
