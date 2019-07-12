package paneli;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JSpinner;

import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;

public class Spinner extends Panel {

	//private Komponenta komponenta;
	private JSpinner spinner;
	JLabel dg;
	JLabel gg;

	public Spinner(SpinnerKomponenta komponenta, JSpinner spinner) {
		super(komponenta);
		this.setLayout(new GridLayout(3, 2, 150, 0));
		//this.komponenta = komponenta;
		this.spinner = spinner;
		nazivLbl.setText(komponenta.getNaziv() + ": ");
		add(spinner);
		add(new JLabel("Gornja granica:"));
		dg = new JLabel(String.valueOf(komponenta.getDonjaGranica()));
		gg = new JLabel(String.valueOf(komponenta.getGornjaGranica()));
		add(gg);
		add(new JLabel("Donja granica:"));
		add(dg);
		spinner.setValue(komponenta.getDonjaGranica());
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}
	
	public void setDg()
	{
		dg.setText(((SpinnerKomponenta) komponenta).getDonjaGranica()+"");
	}
	
	public void setGg()
	{
		gg.setText(((SpinnerKomponenta) komponenta).getGornjaGranica()+"");
	}
}
