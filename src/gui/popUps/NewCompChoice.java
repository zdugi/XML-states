package gui.popUps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.VrstaKomponente;
import gui.mainWindows.ComponentsWindow;
import model.komponente.Komponenta;

public class NewCompChoice extends JFrame{
	public static NewCompChoice single_instance = null;
	private JTextField textField;
	Komponenta comp;
	private NewCompChoice(ComponentsWindow window) {
		
		this.setSize(300, 140);
		this.setLocationRelativeTo(null);
		
		JPanel panelBoxa = new JPanel();
		getContentPane().add(panelBoxa, BorderLayout.CENTER);
		panelBoxa.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblIme = new JLabel("Ime komponente");
		panelBoxa.add(lblIme);
		
		textField = new JTextField();
		panelBoxa.add(textField);
		textField.setColumns(10);
		
		JLabel lblTip = new JLabel("Tip");
		panelBoxa.add(lblTip);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(VrstaKomponente.values()));
		panelBoxa.add(comboBox);
		
		JPanel panelButtona = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtona.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtona, BorderLayout.SOUTH);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comp = new Komponenta(textField.getText(), (VrstaKomponente)comboBox.getSelectedItem());
				switch((VrstaKomponente)comboBox.getSelectedItem())
				{
				case TEXTFIELD:
					window.postaviTextField(comp);
				}
				
				single_instance = null;
				dispose();
			}
		});
		panelButtona.add(btnNext);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				single_instance = null;
				dispose();
			}
		});
		panelButtona.add(btnCancel);
	}
	
	public static NewCompChoice getInstance(ComponentsWindow window) 
    { 
        if (single_instance == null) 
            single_instance = new NewCompChoice(window); 
  
        return single_instance; 
    }
	
	public Komponenta getKomponentu()
	{
		return comp;
	}
	
	/*public void postaviTextField(JPanel panel)
	{
		JPanel pnl = new JPanel();
		JTextField fild = new JTextField(30);
		fild.setEditable(false);
		//Komponenta comp = new Komponenta(ime, VrstaKomponente.TEXTFIELD);
		//data.getDokument().getKomponente().add(comp);
		pnl.add(new JLabel(comp.getNaziv()));
		pnl.add(fild);
		panel.add(pnl, -1);
		panel.revalidate();
	}*/
}
