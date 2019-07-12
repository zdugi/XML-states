package gui.mainWindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import enums.TipStanja;
import gui.popUps.EditComp;
import gui.popUps.NewCompChoice;
import model.komponente.Komponenta;

public class StateTransitonWindow extends JFrame {
	
	JButton btnEdit;
	JButton btnDelete;
	JPanel tabelPanel;
	JPanel grafPanel;
	JTable states;
	JTable transitons;
	DefaultTableModel dmS;
	DefaultTableModel dmTr;
	
	public StateTransitonWindow()
	{
		this.setSize(1200, 800);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("State and Transitons");
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnAddState = new JButton("Add state");
		btnAddState.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddState();
				
			}
			
		});
		toolBar.add(btnAddState);
		
		JButton btnAddTransiton = new JButton("Add Transiton");
		btnAddTransiton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				AddTransiton();
				
			}
			
		});
		toolBar.add(btnAddTransiton);
		
		btnEdit = new JButton("Edit state");
		btnEdit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Edit();
				
			}
			
		});
		btnEdit.setEnabled(false);
		toolBar.add(btnEdit);
		
		btnDelete = new JButton("Delete state");
		btnDelete.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Delete();
				
			}
			
		});
		btnDelete.setEnabled(false);
		toolBar.add(btnDelete);
		
		tabelPanel = new JPanel();
		getContentPane().add(tabelPanel, BorderLayout.WEST);
		tabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tabelPanel.setLayout(new GridLayout(2, 0, 0, 0));
		JPanel statePanel = new JPanel();
		statePanel.setLayout(new BorderLayout());
		JLabel lblSt = new JLabel("States");
		statePanel.add(lblSt, BorderLayout.NORTH);
		String []headerState = {"ID", "Naziv", "Tip"};
		String [][] podaci = {{"nesto", "radi"}};
		dmS = new DefaultTableModel(podaci,headerState);
		states = new JTable(dmS){
		    @Override
		    public boolean isCellEditable(int row, int column) {                
		        return false;               
		    };
		};
		states.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//states.
		JScrollPane statesPane = new JScrollPane(states);
		statePanel.add(statesPane, BorderLayout.CENTER);
		tabelPanel.add(statePanel);
		ListSelectionModel lsm = states.getSelectionModel();
		lsm.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				SelectState();
	        }
	    });
		
		
		JPanel transitonPanel = new JPanel();
		transitonPanel.setLayout(new BorderLayout());
		JLabel lblTr = new JLabel("Transitons");
		transitonPanel.add(lblTr, BorderLayout.NORTH);
		String []headerTransiton = {"ID", "Naziv", "From", "To"};
		dmTr = new DefaultTableModel(podaci,headerTransiton);
		transitons = new JTable(dmTr){
		    @Override
		    public boolean isCellEditable(int row, int column) {                
		        return false;               
		    };
		};
		transitons.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane transitonPane = new JScrollPane(transitons);
		transitonPanel.add(transitonPane, BorderLayout.CENTER);
		tabelPanel.add(transitonPanel);
		ListSelectionModel lsTr = transitons.getSelectionModel();
		lsTr.addListSelectionListener(new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				SelectTransiton();
	        }
	    });
		
		grafPanel = new JPanel();
		getContentPane().add(grafPanel, BorderLayout.CENTER);
	}
	
	private void SelectState()
	{
        transitons.clearSelection();
        btnDelete.setEnabled(true);
        btnDelete.setText("Delete State");
        btnEdit.setEnabled(true);
        btnEdit.setText("Edit State");
	}
	
	private void SelectTransiton()
	{
		states.clearSelection();
		 btnDelete.setEnabled(true);
		 btnDelete.setText("Delete Transiton");
	     btnEdit.setEnabled(true);
	     btnEdit.setText("Edit Transiton");
	}
	
	private void AddState()
	{
		JComponent[] inputs = new JComponent[4];
		inputs[0] = new JLabel("Naziv");
		JTextField tf = new JTextField();
		inputs[1] = tf;
		inputs[2] = new JLabel("Tip stanja");
		JComboBox<String> cb = new JComboBox<String>();
		cb.setModel(new DefaultComboBoxModel(TipStanja.values()));
		inputs[3] = cb;
		int result = JOptionPane.showOptionDialog(null, inputs, "Osnovni atributi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
		if(result == 0 && tf.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Ne moze se dodati state bez naziva", "Error", JOptionPane.ERROR_MESSAGE);
			AddState();
			return;
		}
		else if(result == 1)
			return;
		String []podaciAkcije = {"Enabled", "Disabled"};
		JComponent[] inputs2 = new JComponent[10];
		inputs2[0] = new JLabel("INIT_STATE");
		JComboBox<String> cbA1 = new JComboBox<String>();
		cbA1.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[1] = cbA1;
		inputs2[2] = new JLabel("SAVED_STATE");
		JComboBox<String> cbA2 = new JComboBox<String>();
		cbA2.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[3] = cbA2;
		inputs2[4] = new JLabel("SUBMITED_STATE");
		JComboBox<String> cbA3 = new JComboBox<String>();
		cbA3.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[5] = cbA3;
		inputs2[6] = new JLabel("REJECTED_STATE");
		JComboBox<String> cbA4 = new JComboBox<String>();
		cbA4.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[7] = cbA4;
		inputs2[8] = new JLabel("ARCHIVED_STATE");
		JComboBox<String> cbA5 = new JComboBox<String>();
		cbA5.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[9] = cbA5;
		
		result = JOptionPane.showOptionDialog(null, inputs2, "Moguce akcije", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
		if(result == 0)
			return;
	}
	
	private void AddTransiton()
	{
		JComponent[] inputs = new JComponent[6];
		inputs[0] = new JLabel("Naziv");
		inputs[1] = new JTextField();
		inputs[2] = new JLabel("From State");
		inputs[3] = new JComboBox<String>();
		inputs[4] = new JLabel("To State");
		inputs[5] = new JComboBox<String>();
		int result = JOptionPane.showOptionDialog(null, inputs, "My custom dialog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
	}
	
	private void Delete()
	{
		if(states.getSelectedRow() != -1)
		{
			dmS.removeRow(states.getSelectedRow());
		}
		else if(transitons.getSelectedRow() != -1)
		{
			dmTr.removeRow(transitons.getSelectedRow());
		}
	}
	
	private void Edit()
	{
		if(states.getSelectedRow() != -1)
		{
			
		}
		else if(transitons.getSelectedRow() != -1)
		{
			
		}
	}

}
