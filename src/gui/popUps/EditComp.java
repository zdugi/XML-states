package gui.popUps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.VrstaKomponente;
import enums.VrstaPodkomponente;
import gui.mainWindows.ComponentsWindow;
import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;
import paneli.CheckBoxGroup;
import paneli.Group;
import paneli.Panel;
import paneli.RadioButtonGroup;
import paneli.Spinner;
import paneli.TextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;

public class EditComp extends JFrame{
	public static EditComp single_instance = null;
	Panel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel lblNewLabel;
	JLabel lblGornjaGranica;
	private JList list_1;
	private JButton btnDodaj_1;
	private JButton btnObrisi_1;
	private EditComp(ComponentsWindow window) {
		setResizable(false);
		this.panel = window.getSelekcija();
		
		this.setSize(466, 302);
		this.setLocationRelativeTo(null);
		
		JPanel panelBoxa = new JPanel();
		panelBoxa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		getContentPane().add(panelBoxa, BorderLayout.CENTER);
		GridBagLayout gbl_panelBoxa = new GridBagLayout();
		gbl_panelBoxa.columnWidths = new int[]{70, 70, 70, 70, 0};
		gbl_panelBoxa.rowHeights = new int[]{29, 0, 0, 0};
		gbl_panelBoxa.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBoxa.rowWeights = new double[]{1.0, 1.0, 1.0, 0.0};
		panelBoxa.setLayout(gbl_panelBoxa);
		
		JLabel lblIme = new JLabel("Ime komponente");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.fill = GridBagConstraints.BOTH;
		gbc_lblIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblIme.gridx = 0;
		gbc_lblIme.gridy = 0;
		gbc_lblIme.gridwidth = 2;
		panelBoxa.add(lblIme, gbc_lblIme);
		
		textField = new JTextField(this.panel.getKomponenta().getNaziv());
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		gbc_textField.gridwidth = 2;
		panelBoxa.add(textField, gbc_textField);
		textField.setColumns(10);
		
		lblGornjaGranica = new JLabel("Gornja granica");
		lblGornjaGranica.setVisible(false);
		GridBagConstraints gbc_lblGornjaGranica = new GridBagConstraints();
		gbc_lblGornjaGranica.insets = new Insets(0, 0, 5, 5);
		gbc_lblGornjaGranica.anchor = GridBagConstraints.EAST;
		gbc_lblGornjaGranica.gridx = 0;
		gbc_lblGornjaGranica.gridy = 1;
		panelBoxa.add(lblGornjaGranica, gbc_lblGornjaGranica);
		
		textField_1 = new JTextField();
		textField_1.setVisible(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		panelBoxa.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("Donja granica");
		lblNewLabel.setVisible(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panelBoxa.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setVisible(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 1;
		panelBoxa.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		btnDodaj_1 = new JButton("Dodaj");
		GridBagConstraints gbc_btnDodaj_1 = new GridBagConstraints();
		gbc_btnDodaj_1.gridwidth = 2;
		gbc_btnDodaj_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj_1.gridx = 0;
		gbc_btnDodaj_1.gridy = 2;
		panelBoxa.add(btnDodaj_1, gbc_btnDodaj_1);
		
		list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridwidth = 2;
		gbc_list_1.gridheight = 2;
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 2;
		gbc_list_1.gridy = 2;
		panelBoxa.add(list_1, gbc_list_1);
		
		btnObrisi_1 = new JButton("Obrisi");
		GridBagConstraints gbc_btnObrisi_1 = new GridBagConstraints();
		gbc_btnObrisi_1.gridwidth = 2;
		gbc_btnObrisi_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnObrisi_1.gridx = 0;
		gbc_btnObrisi_1.gridy = 3;
		panelBoxa.add(btnObrisi_1, gbc_btnObrisi_1);
		
		JPanel panelButtona = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtona.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtona, BorderLayout.SOUTH);
		
		JButton btnNext = new JButton("Change");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
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
		
		if (panel instanceof Group)
		{
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			lblGornjaGranica.setVisible(false);
			lblNewLabel.setVisible(false);
		}
		else if (panel instanceof TextField)
		{
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			lblGornjaGranica.setVisible(false);
			lblNewLabel.setVisible(false);
		}
		else if (panel instanceof Spinner)
		{
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			lblGornjaGranica.setVisible(false);
			lblNewLabel.setVisible(false);
		}
		else
		{
			
		}
	}
	
	public static EditComp getInstance(ComponentsWindow window) 
    { 
        if (single_instance == null) 
            single_instance = new EditComp(window); 
  
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
