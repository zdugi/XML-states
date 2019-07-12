package paneli;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.komponente.Komponenta;

public class Panel extends JPanel {

	protected Komponenta komponenta;
	protected JLabel nazivLbl;
	
	public Panel(Komponenta komponenta) {
		this.komponenta = komponenta;
		this.setMaximumSize(new Dimension(200,100));
		//naziv.setText(komponenta.getNaziv());
		nazivLbl = new JLabel(komponenta.getNaziv());
		add(nazivLbl);
	}

	public Komponenta getKomponenta() {
		return komponenta;
	}

	public void setKomponenta(Komponenta komponenta) {
		this.komponenta = komponenta;
	}

	public void rerepaint()
	{
		revalidate();
		repaint();
	}
	
	public void setNazivLbl()
	{
		this.nazivLbl.setText(komponenta.getNaziv());
	}
}
