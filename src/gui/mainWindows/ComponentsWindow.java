package gui.mainWindows;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.popUps.NewCompChoice;

public class ComponentsWindow extends JFrame{
	public ComponentsWindow() {
		
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnAddComponent = new JButton("Add component");
		btnAddComponent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewCompChoice ncc = NewCompChoice.getInstance();
				ncc.setVisible(true);
			}
		});
		toolBar.add(btnAddComponent);
		
		JButton btnEditComponent = new JButton("Edit component");
		btnEditComponent.setEnabled(false);
		toolBar.add(btnEditComponent);
		
		JButton btnDeleteComponent = new JButton("Delete component");
		btnDeleteComponent.setEnabled(false);
		toolBar.add(btnDeleteComponent);
		
		JPanel panelKomponenti = new JPanel();
		getContentPane().add(panelKomponenti, BorderLayout.CENTER);
		
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
	
}
