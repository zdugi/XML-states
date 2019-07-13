package model.komponente;

import enums.VrstaKomponente;

public class SpinnerKomponenta extends Komponenta {
	
	private int gornjaGranica;
	private int donjaGranica;
	
	 public SpinnerKomponenta(String naziv, VrstaKomponente tip, int gornjaGranica, int donjaGranica)
	 {
		 super(naziv, tip);
		 this.gornjaGranica = gornjaGranica;
		 this.donjaGranica = donjaGranica;
	 }

	public int getGornjaGranica() {
		return gornjaGranica;
	}

	public void setGornjaGranica(int gornjaGranica) {
		this.gornjaGranica = gornjaGranica;
	}

	public int getDonjaGranica() {
		return donjaGranica;
	}

	public void setDonjaGranica(int donjaGranica) {
		this.donjaGranica = donjaGranica;
	}
}
