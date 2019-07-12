package gui.mainWindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import enums.VrstaKomponente;
import gui.popUps.EditComp;
import gui.popUps.NewCompChoice;
import gui.popUps.NewSubComp;
import model.Data;
import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;
import paneli.CheckBox;
import paneli.CheckBoxGroup;
import paneli.Panel;
import paneli.RadioButton;
import paneli.RadioButtonGroup;
import paneli.Spinner;
import paneli.TextField;

import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;

public class ComponentsWindow extends JFrame{
	JPanel panelKomponenti;
	private ArrayList<JPanel> paneli;
	private Panel selekcija;
	JButton btnEditComponent;
	JButton btnDeleteComponent;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	public ComponentsWindow(Data data) {
		paneli = new ArrayList<JPanel>();
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnAddComponent = new JButton("Add component");
		btnAddComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Komponenta comp = null;
				NewCompChoice ncc = NewCompChoice.getInstance(ComponentsWindow.this);
				ncc.setVisible(true);
			}
		});
		toolBar.add(btnAddComponent);
		
		btnEditComponent = new JButton("Edit component");
		btnEditComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditComp ncc = EditComp.getInstance(ComponentsWindow.this);
				ncc.setVisible(true);
			}
		});
		btnEditComponent.setEnabled(false);
		toolBar.add(btnEditComponent);
		
		btnDeleteComponent = new JButton("Delete component");
		btnDeleteComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				obrisi();
			}
		});
		btnDeleteComponent.setEnabled(false);
		toolBar.add(btnDeleteComponent);
		
		panelKomponenti = new JPanel();
		panelKomponenti.setAlignmentX(LEFT_ALIGNMENT);
		getContentPane().add(panelKomponenti, BorderLayout.CENTER);
		panelKomponenti.setLayout(new GridLayout(4, 0, 0, 0));
		panelKomponenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(null);
            }
        });
		
		JPanel panelNastavka = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNastavka.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelNastavka, BorderLayout.SOUTH);
		
		JButton btnSaveAndNext = new JButton("Save and continue");
		btnSaveAndNext.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					nextProzor();
				}
		
		});
		panelNastavka.add(btnSaveAndNext);
		
		JPanel panelAkcija = new JPanel();
		getContentPane().add(panelAkcija, BorderLayout.EAST);
		panelAkcija.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnNewButton_1 = new JButton("Save");
		panelAkcija.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Submit");
		panelAkcija.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Reject");
		panelAkcija.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Archive");
		panelAkcija.add(btnNewButton_4);
	}
	
	public void nextProzor()
	{
		super.dispose();
		StateTransitonWindow stw = new StateTransitonWindow();
		stw.setVisible(true);
	}
	public void postaviTextField(Komponenta comp)
	{
		JTextField jTextField = new JTextField();
		TextField textField = new TextField(comp, jTextField);
		jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(textField);
            }
        });
		//data.getDokument().getKomponente().add(comp);
		textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(textField);
            }
        });
		panelKomponenti.add(textField, -1);
		panelKomponenti.revalidate();
	}
	
	public void postaviSpinner(SpinnerKomponenta comp)
	{
		JSpinner jSpinner = new JSpinner();
		Spinner spinner = new Spinner(comp, jSpinner);
		spinner.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(spinner);
            }
        });
		//data.getDokument().getKomponente().add(comp);
		spinner.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(spinner);
            }
        });
		panelKomponenti.add(spinner, -1);
		panelKomponenti.revalidate();
	}
	
	public void postaviCheckboxGroup(Komponenta comp)
	{
		ButtonGroup group = new ButtonGroup();
		CheckBoxGroup checkBox = new CheckBoxGroup(comp, group);
		//data.getDokument().getKomponente().add(comp);
		checkBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(checkBox);
            }
        });
		panelKomponenti.add(checkBox, -1);
		panelKomponenti.revalidate();
	}
	
	public void postaviRadioButtonGroup(Komponenta comp)
	{
		ButtonGroup group = new ButtonGroup();
		RadioButtonGroup radioGroup = new RadioButtonGroup(comp, group);
		//data.getDokument().getKomponente().add(comp);
		radioGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(radioGroup);
            }
        });
		panelKomponenti.add(radioGroup, -1);
		panelKomponenti.revalidate();
	}

	public void setSeleckija(Panel panel) {
		if (this.selekcija != null)
			this.selekcija.setBorder(null);
		
		this.selekcija = panel;
		
		if (this.selekcija != null)
		{
			btnEditComponent.setEnabled(true);
			btnDeleteComponent.setEnabled(true);
			this.selekcija.setBorder(BorderFactory.createLineBorder(Color.red));
		}
		else
		{
			btnEditComponent.setEnabled(false);
			btnDeleteComponent.setEnabled(false);
		}
	}
	
	public Panel getSelekcija() {
		return this.selekcija;
	}
	
	public void obrisi()
	{
		panelKomponenti.remove(selekcija);
		panelKomponenti.revalidate();
		panelKomponenti.repaint();
		setSeleckija(null);
	}
}
