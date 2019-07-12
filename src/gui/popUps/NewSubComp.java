package gui.popUps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import enums.VrstaKomponente;
import enums.VrstaPodkomponente;
import gui.mainWindows.ComponentsWindow;
import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;
import paneli.CheckBox;
import paneli.CheckBoxGroup;
import paneli.Panel;
import paneli.RadioButton;
import paneli.RadioButtonGroup;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class NewSubComp extends JFrame{
	public static NewSubComp single_instance = null;
	private JTextField textField;
	Panel panel;
	private NewSubComp(EditComp window) {
		setResizable(false);
		
		this.setSize(466, 126);
		this.setLocationRelativeTo(null);
		
		JPanel panelBoxa = new JPanel();
		panelBoxa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		getContentPane().add(panelBoxa, BorderLayout.CENTER);
		GridBagLayout gbl_panelBoxa = new GridBagLayout();
		gbl_panelBoxa.columnWidths = new int[]{70, 70, 70, 70, 0};
		gbl_panelBoxa.rowHeights = new int[]{29};
		gbl_panelBoxa.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBoxa.rowWeights = new double[]{1.0};
		panelBoxa.setLayout(gbl_panelBoxa);
		
		JLabel lblIme = new JLabel("Ime komponente");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.fill = GridBagConstraints.BOTH;
		gbc_lblIme.insets = new Insets(0, 0, 0, 5);
		gbc_lblIme.gridx = 0;
		gbc_lblIme.gridy = 0;
		gbc_lblIme.gridwidth = 2;
		panelBoxa.add(lblIme, gbc_lblIme);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		gbc_textField.gridwidth = 2;
		panelBoxa.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JPanel panelButtona = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtona.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtona, BorderLayout.SOUTH);
		
		JButton btnNext = new JButton("Change");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Panel panel = null;
				
				if (window.panel instanceof RadioButtonGroup)
				{
					panel = new RadioButton(new Komponenta(textField.getText()), new JRadioButton());
				}
				else if (window.panel instanceof CheckBoxGroup)
				{
					panel = new CheckBox(new Komponenta(textField.getText()), new JCheckBox());
				}
				window.DodajPodKomponentu(panel);
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
	
	public static NewSubComp getInstance(EditComp window) 
    { 
        if (single_instance == null) 
            single_instance = new NewSubComp(window); 
  
        return single_instance; 
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
