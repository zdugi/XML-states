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
import gui.popUps.NewCompChoice;
import model.Data;
import model.komponente.Komponenta;

public class ComponentsWindow extends JFrame{
	JPanel panelKomponenti;
	private ArrayList<JPanel> paneli;
	private JPanel selekcija;
	JButton btnEditComponent;
	JButton btnDeleteComponent;
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
	
	public void postaviTextField(Komponenta comp)
	{
		JPanel pnl = new JPanel();
		JTextField fild = new JTextField(30);
		fild.setEditable(false);
		fild.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(pnl);
            }
        });
		//data.getDokument().getKomponente().add(comp);
		pnl.add(new JLabel(comp.getNaziv()));
		pnl.add(fild);
		pnl.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
            	ComponentsWindow.this.setSeleckija(pnl);
            }
        });
		panelKomponenti.add(pnl, -1);
		panelKomponenti.revalidate();
	}
	
	public void setSeleckija(JPanel panel) {
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
	
	public void obrisi()
	{
		panelKomponenti.remove(selekcija);
		panelKomponenti.revalidate();
		panelKomponenti.repaint();
		setSeleckija(null);
	}
}
