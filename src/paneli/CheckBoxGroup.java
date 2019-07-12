package paneli;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

import model.komponente.Komponenta;

public class CheckBoxGroup extends Group {
	
	public ArrayList<CheckBox> checkBoxs;
	
	public CheckBoxGroup(Komponenta komponenta, ButtonGroup buttonGroup) {
		super(komponenta, buttonGroup);
		checkBoxs = new ArrayList<CheckBox>();
	}
	
	public void DodajCheckBox(CheckBox checkBox) {
		super.getButtonGroup().add(checkBox.getCheckBox());
		checkBoxs.add(checkBox);
		add(checkBox);
	}
	
	public void ObrisiCheckBox(CheckBox checkBox) {
		super.getButtonGroup().remove(checkBox.getCheckBox());
		checkBoxs.remove(checkBox);
		remove(checkBox);
	}
}
