package paneli;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

import model.komponente.GroupKomponenta;

public class CheckBoxGroup extends Group {
	
	public ArrayList<CheckBox> checkBoxs;
	
	public CheckBoxGroup(GroupKomponenta komponenta, ButtonGroup buttonGroup) {
		super(komponenta, buttonGroup);
		checkBoxs = new ArrayList<CheckBox>();
	}
	
	public void DodajCheckBox(CheckBox checkBox) {
		super.getButtonGroup().add(checkBox.getCheckBox());
		checkBoxs.add(checkBox);
		((GroupKomponenta) komponenta).getDugmici().add(checkBox.getKomponenta().getNaziv());
		add(checkBox);
	}
	
	public void ObrisiCheckBox(CheckBox checkBox) {
		super.getButtonGroup().remove(checkBox.getCheckBox());
		checkBoxs.remove(checkBox);
		((GroupKomponenta) komponenta).getDugmici().remove(checkBox.getKomponenta().getNaziv());
		remove(checkBox);
	}
}
