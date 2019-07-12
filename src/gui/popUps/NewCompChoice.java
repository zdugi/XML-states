package gui.popUps;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import enums.VrstaKomponente;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class NewCompChoice extends JFrame{
	private static NewCompChoice single_instance = null;
	
	private NewCompChoice() {
		
		this.setSize(200, 120);
		this.setLocationRelativeTo(null);
		
		JPanel panelBoxa = new JPanel();
		getContentPane().add(panelBoxa, BorderLayout.CENTER);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(VrstaKomponente.values()));
		panelBoxa.add(comboBox);
		
		JPanel panelButtona = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtona.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtona, BorderLayout.SOUTH);
		
		JButton btnNext = new JButton("Next");
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
	
	public static NewCompChoice getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new NewCompChoice(); 
  
        return single_instance; 
    } 
}
