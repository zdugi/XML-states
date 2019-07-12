package paneli;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.komponente.Komponenta;

public class TextField extends Panel {

	private Komponenta komponenta;
	private JTextField textField;
	
	public TextField(Komponenta komponenta, JTextField textField) {
		super(komponenta);
		this.komponenta = komponenta;
		this.textField = textField;
		//this.textField.setSize(200, 20);
		add(new JLabel(komponenta.getNaziv()));
		add(textField);
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
}
