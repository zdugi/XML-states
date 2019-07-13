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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import gui.popUps.EditComp;
import gui.popUps.NewCompChoice;
import main.CreateXML;
import main.MainTest;
import model.Data;
import model.komponente.GroupKomponenta;
import model.komponente.Komponenta;
import model.komponente.SpinnerKomponenta;
import paneli.CheckBoxGroup;
import paneli.Panel;
import paneli.RadioButtonGroup;
import paneli.Spinner;
import paneli.TextField;

public class ComponentsWindow extends JFrame{
	JPanel panelKomponenti;
	private ArrayList<JPanel> paneli;
	private Panel selekcija;
	public JButton btnEditComponent;
	public JButton btnDeleteComponent;
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
		panelKomponenti.setLayout(new GridLayout(10, 0, 0, 0));
		panelKomponenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(null);
            }
        });
		
		JPanel panelNastavka = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelNastavka.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panelNastavka.setBorder(BorderFactory.createLineBorder(Color.black));
		getContentPane().add(panelNastavka, BorderLayout.SOUTH);
		
		JButton btnSaveAndNext = new JButton("Save and continue");

		btnSaveAndNext.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(MainTest.data.getDokument().getKomponente().size() != 0)
						nextProzor();
					else
						JOptionPane.showMessageDialog(new JDialog(),
							    "Mora se dodati bar jenda komponenta",
							    "Add failure",
							    JOptionPane.ERROR_MESSAGE);
				}
		});
		panelNastavka.add(btnSaveAndNext);
	}
	
	public void nextProzor()
	{
		super.dispose();
		StateTransitonWindow stw = new StateTransitonWindow();
		stw.setVisible(true);
	}
	public TextField postaviTextField(Komponenta comp)
	{
		JTextField jTextField = new JTextField(30);
		jTextField.setEditable(false);
		TextField textField = new TextField(comp, jTextField);
		jTextField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(textField);
            }
        });
		MainTest.data.getDokument().getKomponente().add(comp);
		textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(textField);
            }
        });
		panelKomponenti.add(textField, -1);
		setSeleckija(textField);
		panelKomponenti.revalidate();
		return textField;
	}
	
	public Spinner postaviSpinner(SpinnerKomponenta comp)
	{
		JSpinner jSpinner = new JSpinner();
		jSpinner.setEnabled(false);
		Spinner spinner = new Spinner(comp, jSpinner);
		spinner.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(spinner);
            }
        });
		MainTest.data.getDokument().getKomponente().add(comp);
		spinner.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(spinner);
            }
        });
		panelKomponenti.add(spinner, -1);
		setSeleckija(spinner);
		panelKomponenti.revalidate();
		
		return spinner;
	}
	
	public CheckBoxGroup postaviCheckboxGroup(GroupKomponenta comp)
	{
		ButtonGroup group = new ButtonGroup();
		CheckBoxGroup checkBox = new CheckBoxGroup(comp, group);
		MainTest.data.getDokument().getKomponente().add(comp);
		checkBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(checkBox);
            }
        });
		panelKomponenti.add(checkBox, -1);
		setSeleckija(checkBox);
		panelKomponenti.revalidate();
		
		return checkBox;
	}
	
	public RadioButtonGroup postaviRadioButtonGroup(GroupKomponenta comp)
	{
		ButtonGroup group = new ButtonGroup();
		RadioButtonGroup radioGroup = new RadioButtonGroup(comp, group);
		MainTest.data.getDokument().getKomponente().add(comp);
		radioGroup.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(radioGroup);
            }
        });
		panelKomponenti.add(radioGroup, -1);
		setSeleckija(radioGroup);
		panelKomponenti.revalidate();
		
		return radioGroup;
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
		Komponenta pom = null;
		for(Komponenta k : MainTest.data.getDokument().getKomponente())
		{
			if(k.getKomponentaId().equals(selekcija.getKomponenta().getKomponentaId()))
			{
				pom = k;
				break;
			}		
		}
		MainTest.data.getDokument().getKomponente().remove(pom);
		setSeleckija(null);
		panelKomponenti.revalidate();
		panelKomponenti.repaint();
	}
}
