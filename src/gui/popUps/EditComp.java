package gui.popUps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import enums.VrstaKomponente;
import enums.VrstaPodkomponente;
import gui.mainWindows.ComponentsWindow;
import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;
import paneli.CheckBox;
import paneli.CheckBoxGroup;
import paneli.Group;
import paneli.Panel;
import paneli.RadioButton;
import paneli.RadioButtonGroup;
import paneli.Spinner;
import paneli.TextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JList;
import javax.swing.JScrollPane;

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
	DefaultListModel listModel;
	Panel selektovan;
	private JScrollPane scrollPane;
	
	private EditComp(ComponentsWindow window) {
		setResizable(false);
		this.panel = window.getSelekcija();
		
		this.setSize(466, 302);
		this.setLocationRelativeTo(null);
		
		listModel = new DefaultListModel();
		
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
		btnDodaj_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				NewSubComp ncc = NewSubComp.getInstance(EditComp.this);
				ncc.setVisible(true);
			}
		});
		GridBagConstraints gbc_btnDodaj_1 = new GridBagConstraints();
		gbc_btnDodaj_1.gridwidth = 2;
		gbc_btnDodaj_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodaj_1.gridx = 0;
		gbc_btnDodaj_1.gridy = 2;
		panelBoxa.add(btnDodaj_1, gbc_btnDodaj_1);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 2;
		panelBoxa.add(scrollPane, gbc_scrollPane);
		
		list_1 = new JList(listModel);
		scrollPane.setViewportView(list_1);
		list_1.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                  if (list_1.getSelectedIndex() == -1)
                  {
                	  EditComp.this.setSelektovan(null);
                  }
                  else
                  {
                	  EditComp.this.setSelektovan((Panel)list_1.getSelectedValue());
                  }
                }
            }
        });
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnObrisi_1 = new JButton("Obrisi");
		btnObrisi_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if (panel instanceof RadioButtonGroup)
				{
					((RadioButtonGroup)panel).ObrisiRadioButton((RadioButton)EditComp.this.selektovan);
					listModel.removeElement(EditComp.this.selektovan);
				}
				else if (panel instanceof CheckBoxGroup)
				{
					((CheckBoxGroup)panel).ObrisiCheckBox((CheckBox)EditComp.this.selektovan);
					listModel.removeElement(EditComp.this.selektovan);
				}
				EditComp.this.setSelektovan(null);
			}
		});
		btnObrisi_1.setEnabled(false);
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
				
				panel.getKomponenta().setNaziv(textField.getText());
				
				
				if (panel instanceof Spinner)
				{
					try
					{
						((SpinnerKomponenta)panel.getKomponenta()).setDonjaGranica(Integer.parseInt(textField_2.getText()));
						((SpinnerKomponenta)panel.getKomponenta()).setGornjaGranica(Integer.parseInt(textField_1.getText()));
						((Spinner) panel).setDg();
						((Spinner) panel).setGg();
					}catch(NumberFormatException ex)
					{
						System.out.println("Losi brojevi");
					}
				}
				panel.setNazivLbl();
				//window.refreshPanelOnEdit(panel);
				panel.rerepaint();
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
			btnDodaj_1.setVisible(true);
			btnObrisi_1.setVisible(true);
			list_1.setVisible(true);
			
			if (panel instanceof CheckBoxGroup)
			{
				for (CheckBox checkBox : ((CheckBoxGroup)panel).checkBoxs) {
					listModel.addElement(checkBox);
				
				}
			}
			else if (panel instanceof RadioButtonGroup)
			{
				for (RadioButton radioButton : ((RadioButtonGroup)panel).radioButtons) {
					listModel.addElement(radioButton);
				}
			}
		}
		else if (panel instanceof TextField)
		{
			textField_1.setVisible(false);
			textField_2.setVisible(false);
			lblGornjaGranica.setVisible(false);
			lblNewLabel.setVisible(false);
			btnDodaj_1.setVisible(false);
			btnObrisi_1.setVisible(false);
			list_1.setVisible(false);
		}
		else if (panel instanceof Spinner)
		{
			textField_1.setVisible(true);
			textField_2.setVisible(true);
			lblGornjaGranica.setVisible(true);
			lblNewLabel.setVisible(true);
			btnDodaj_1.setVisible(false);
			btnObrisi_1.setVisible(false);
			list_1.setVisible(false);
			
			textField_1.setText(String.valueOf(((SpinnerKomponenta)panel.getKomponenta()).getGornjaGranica()));
			textField_2.setText(String.valueOf(((SpinnerKomponenta)panel.getKomponenta()).getDonjaGranica()));
		}
		else
		{
			
		}
	}
	
	public void setSelektovan(Panel panel) {
		this.selektovan = panel;
		
		if (panel == null)
		{
			btnObrisi_1.setEnabled(false);
		}
		else
		{
			btnObrisi_1.setEnabled(true);
		}
	}
	
	public void DodajPodKomponentu(Panel panel) {
		
		if (panel instanceof RadioButton)
		{
			((RadioButtonGroup)this.panel).DodajRadioButton((RadioButton)panel);
			listModel.addElement((RadioButton)panel);
		}
		else if (panel instanceof CheckBox)
		{
			((CheckBoxGroup)this.panel).DodajCheckBox((CheckBox)panel);
			listModel.addElement((CheckBox)panel);
		}
		else
		{
			System.out.println("Nema instance");
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
