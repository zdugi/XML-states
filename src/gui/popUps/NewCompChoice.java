package gui.popUps;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import enums.VrstaKomponente;
import gui.mainWindows.ComponentsWindow;
import main.MainTest;
import model.komponente.GroupKomponenta;
import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;

public class NewCompChoice extends JFrame{
	public static NewCompChoice single_instance = null;
	private JTextField textField;
	Komponenta comp;
	private JTextField textField_1;
	private JTextField textField_2;
	JLabel lblNewLabel;
	JLabel lblGornjaGranica;
	private NewCompChoice(ComponentsWindow window) {
		setResizable(false);
		
		this.setSize(466, 167);
		this.setLocationRelativeTo(null);
		
		JPanel panelBoxa = new JPanel();
		panelBoxa.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		getContentPane().add(panelBoxa, BorderLayout.CENTER);
		GridBagLayout gbl_panelBoxa = new GridBagLayout();
		gbl_panelBoxa.columnWidths = new int[]{70, 70, 70, 70, 0};
		gbl_panelBoxa.rowHeights = new int[]{29, 26, 0};
		gbl_panelBoxa.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panelBoxa.rowWeights = new double[]{1.0, 1.0, 1.0};
		panelBoxa.setLayout(gbl_panelBoxa);
		
		JLabel lblIme = new JLabel("Ime komponente");
		GridBagConstraints gbc_lblIme = new GridBagConstraints();
		gbc_lblIme.fill = GridBagConstraints.BOTH;
		gbc_lblIme.insets = new Insets(0, 0, 5, 5);
		gbc_lblIme.gridx = 0;
		gbc_lblIme.gridy = 0;
		gbc_lblIme.gridwidth = 2;
		panelBoxa.add(lblIme, gbc_lblIme);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		gbc_textField.gridwidth = 2;
		panelBoxa.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTip = new JLabel("Tip");
		GridBagConstraints gbc_lblTip = new GridBagConstraints();
		gbc_lblTip.fill = GridBagConstraints.BOTH;
		gbc_lblTip.insets = new Insets(0, 0, 5, 5);
		gbc_lblTip.gridx = 0;
		gbc_lblTip.gridy = 1;
		gbc_lblTip.gridwidth = 2;
		panelBoxa.add(lblTip, gbc_lblTip);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				switch((VrstaKomponente)comboBox.getSelectedItem())
				{
				case SPINNER:
					lblGornjaGranica.setVisible(true);
					textField_1.setVisible(true);
					lblNewLabel.setVisible(true);
					textField_2.setVisible(true);
					break;
				default:
					lblGornjaGranica.setVisible(false);
					textField_1.setVisible(false);
					lblNewLabel.setVisible(false);
					textField_2.setVisible(false);
					break;
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(VrstaKomponente.values()));
		comboBox.removeItemAt(4);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.BOTH;
		gbc_comboBox.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		gbc_comboBox.gridwidth = 2;
		panelBoxa.add(comboBox, gbc_comboBox);
		
		lblGornjaGranica = new JLabel("Gornja granica");
		lblGornjaGranica.setVisible(false);
		GridBagConstraints gbc_lblGornjaGranica = new GridBagConstraints();
		gbc_lblGornjaGranica.insets = new Insets(0, 0, 0, 5);
		gbc_lblGornjaGranica.anchor = GridBagConstraints.EAST;
		gbc_lblGornjaGranica.gridx = 0;
		gbc_lblGornjaGranica.gridy = 2;
		panelBoxa.add(lblGornjaGranica, gbc_lblGornjaGranica);
		
		textField_1 = new JTextField();
		textField_1.setVisible(false);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.insets = new Insets(0, 0, 0, 5);
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panelBoxa.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel = new JLabel("Donja granica");
		lblNewLabel.setVisible(false);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 2;
		panelBoxa.add(lblNewLabel, gbc_lblNewLabel);
		
		textField_2 = new JTextField();
		textField_2.setVisible(false);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 2;
		panelBoxa.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JPanel panelButtona = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtona.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtona, BorderLayout.SOUTH);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comp = new Komponenta(textField.getText(), (VrstaKomponente)comboBox.getSelectedItem());
				for(Komponenta k : MainTest.data.getDokument().getKomponente())
				{
					if(k.getKomponentaId().equals(comp.getKomponentaId()))
					{
						JOptionPane.showMessageDialog(new JDialog(),
							    "Ime komponente svakog tipa mora biti jedinstveno",
							    "Add failure",
							    JOptionPane.ERROR_MESSAGE);
						return;
					}		
				}
				switch((VrstaKomponente)comboBox.getSelectedItem())
				{
				case TEXTFIELD:
					if(!textField.getText().equals(""))
					{
						window.postaviTextField(comp);
						single_instance = null;
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(new JDialog(),
							    "Ime komponente se mora uneti",
							    "Add failure",
							    JOptionPane.ERROR_MESSAGE);
					}
					break;
				case SPINNER:
					if(!textField.getText().equals(""))
					{
						try
						{
							if (Integer.parseInt(textField_1.getText()) < Integer.parseInt(textField_2.getText()))
							{
								JOptionPane.showMessageDialog(new JDialog(),
									    "Gornja granica mora bitiveca od donje",
									    "Add failure",
									    JOptionPane.ERROR_MESSAGE);
								return;
							}
							else
							{
								comp = new SpinnerKomponenta(textField.getText(), (VrstaKomponente)comboBox.getSelectedItem(), Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()));
								window.postaviSpinner((SpinnerKomponenta)comp);
								single_instance = null;
								dispose();
							}
						}catch (NumberFormatException ex)
						{
							JOptionPane.showMessageDialog(new JDialog(),
								    "Lose vrednosti, moraju se uneti brojevi",
								    "Add failure",
								    JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					else
					{
						JOptionPane.showMessageDialog(new JDialog(),
							    "Ime komponente se mora uneti",
							    "Add failure",
							    JOptionPane.ERROR_MESSAGE);
					}
					break;
				case RADIOGROUP:
					if(!textField.getText().equals(""))
					{
						comp = new GroupKomponenta(textField.getText(), (VrstaKomponente)comboBox.getSelectedItem());
						window.postaviRadioButtonGroup((GroupKomponenta) comp);
						single_instance = null;
						dispose();
						EditComp ncc = EditComp.getInstance(window);
						ncc.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(new JDialog(),
							    "Ime komponente se mora uneti",
							    "Add failure",
							    JOptionPane.ERROR_MESSAGE);
					}
					break;
					
				case CHECKGROUP:
					if(!textField.getText().equals(""))
					{
						comp = new GroupKomponenta(textField.getText(), (VrstaKomponente)comboBox.getSelectedItem());
						window.postaviCheckboxGroup((GroupKomponenta) comp);
						single_instance = null;
						dispose();
						EditComp ncc = EditComp.getInstance(window);
						ncc.setVisible(true);
					}
					else
					{
						JOptionPane.showMessageDialog(new JDialog(),
							    "Ime komponente se mora uneti",
							    "Add failure",
							    JOptionPane.ERROR_MESSAGE);
					}
					break;
				}
				
				//single_instance = null;
				//dispose();
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
