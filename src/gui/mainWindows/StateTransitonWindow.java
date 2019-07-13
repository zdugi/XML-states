package gui.mainWindows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

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
import enums.VrstaAkcije;
import gui.popUps.EditComp;
import gui.popUps.NewCompChoice;
import main.CreateXML;
import main.MainTest;
import model.Akcija;
import model.State;
import model.Tranzicija;
import model.komponente.Komponenta;

public class StateTransitonWindow extends JFrame {
	
	JButton btnEdit;
	JButton btnDelete;
	JButton btnPostaviInit;
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
		
		btnPostaviInit = new JButton("Postavi kao INIT");
		btnPostaviInit.setEnabled(false);
		btnPostaviInit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PostaviInit();
			}
		});
		toolBar.add(btnPostaviInit);
		
		JButton btnUpisiUFajl = new JButton("Upisi u fajl");
		btnUpisiUFajl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateXML.writeToXML();
			}
		});
		toolBar.add(btnUpisiUFajl);
		
		
		
		tabelPanel = new JPanel();
		//getContentPane().add(tabelPanel, BorderLayout.WEST);
		getContentPane().add(tabelPanel, BorderLayout.CENTER);
		tabelPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		tabelPanel.setLayout(new GridLayout(2, 0, 0, 0));
		JPanel statePanel = new JPanel();
		statePanel.setLayout(new BorderLayout());
		JLabel lblSt = new JLabel("States");
		statePanel.add(lblSt, BorderLayout.NORTH);
		String []headerState = {"ID", "Naziv", "Tip"};
		//String [][] podaci = {{"nesto", "radi"}};
		dmS = new DefaultTableModel(null,headerState);
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
		String []headerTransiton = {"Naziv", "From", "Fail", "Succes"};
		dmTr = new DefaultTableModel(null,headerTransiton);
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
		
		/*grafPanel = new JPanel();
		getContentPane().add(grafPanel, BorderLayout.CENTER);*/
	}
	
	private void PostaviInit()
	{
		State st = MainTest.data.getStanje().get(states.getSelectedRow());
		JComponent[] inputs2 = new JComponent[2];
		inputs2[0] = new JLabel("Dozvoljene Akcije");
		
		inputs2[1] = new JComboBox<String>(new DefaultComboBoxModel(TipStanja.values()));
		int result = JOptionPane.showOptionDialog(null, inputs2, "My custom dialog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
		if(result != 0)
			return;
		if(st.getTipStanja() == TipStanja.INITSTATE)
			return;
		int index = 0;
		for(State s : MainTest.data.getStanje())
		{
			if(s.getTipStanja() == TipStanja.INITSTATE)
			{
				int pom = ((JComboBox)inputs2[1]).getSelectedIndex();
				if(pom == 0)
				{
					JOptionPane.showMessageDialog(null, "Ne mozes posataviti INIT", "Error", JOptionPane.ERROR_MESSAGE);
					PostaviInit();
					return;
				}
				s.setTipStanja(TipStanja.values()[pom]);
				s.setStanjeId(s.getNazivStanja() + s.getTipStanja());
				System.out.println(s.getTipStanja());
				String []pod = {s.getStanjeId(), s.getNazivStanja(), s.getTipStanja().toString()};
				dmS.insertRow(index, pod);
				dmS.removeRow(index + 1);
				break;
			}
			index++;
		}
		
		
		st.setTipStanja(TipStanja.INITSTATE);
		st.setStanjeId(st.getNazivStanja() + st.getTipStanja());
		String []pod = {st.getStanjeId(), st.getNazivStanja(), st.getTipStanja().toString()};
		dmS.insertRow(states.getSelectedRow(), pod);
		dmS.removeRow(states.getSelectedRow());
	}
	
	private void SelectState()
	{
        transitons.clearSelection();
        btnDelete.setEnabled(true);
        btnDelete.setText("Delete State");
        btnEdit.setEnabled(true);
        btnEdit.setText("Edit State");
        btnPostaviInit.setEnabled(true);
	}
	
	private void SelectTransiton()
	{
		btnPostaviInit.setEnabled(false);
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
		else if(result != 0)
			return;
		for(State s : MainTest.data.getStanje())
		{
			if(s.getNazivStanja().equals(tf.getText()))
			{
				JOptionPane.showMessageDialog(null, "Naziv stanja vec postoji", "Error", JOptionPane.ERROR_MESSAGE);
				AddState();
				return;
			}
		}
		TipStanja ts = TipStanja.values()[cb.getSelectedIndex()]; 
		if(ts == TipStanja.INITSTATE)
		{
			for(State s : MainTest.data.getStanje())
			{
				if(s.getTipStanja() == TipStanja.INITSTATE)
				{
					JOptionPane.showMessageDialog(null, "Ne mozes dodati vise od jednog INITSTATE", "Error", JOptionPane.ERROR_MESSAGE);
					AddState();
					return;
				}
			}
		}
		//System.out.println(result);
		String []podaciAkcije = {"Enabled", "Disabled"};
		JComponent[] inputs2 = new JComponent[8];
		inputs2[0] = new JLabel("Save");
		JComboBox<String> cbA1 = new JComboBox<String>();
		cbA1.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[1] = cbA1;
		inputs2[2] = new JLabel("Submit");
		JComboBox<String> cbA2 = new JComboBox<String>();
		cbA2.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[3] = cbA2;
		inputs2[4] = new JLabel("Reject");
		JComboBox<String> cbA3 = new JComboBox<String>();
		cbA3.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[5] = cbA3;
		inputs2[6] = new JLabel("Archive");
		JComboBox<String> cbA4 = new JComboBox<String>();
		cbA4.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
		inputs2[7] = cbA4;
		
		
		result = JOptionPane.showOptionDialog(null, inputs2, "Moguce akcije", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
		if(result != 0)
			return;
		ArrayList<Akcija> akcije = new ArrayList<Akcija>();
		for(int i = 0, j = 0; i + j < 8; i ++, j++)
		{
			if(((JComboBox)inputs2[i + j + 1]).getSelectedIndex() == 0)
			{
				Akcija a = new Akcija(VrstaAkcije.values()[i]);
				akcije.add(a);
			}
		}
		String []podaciKomponente = {"Mandatory", "Delete", "Hide"};
		ArrayList<Komponenta> lista = MainTest.data.getDokument().getKomponente();
		int n = 2 * lista.size();
		//System.out.println(n);
		JComponent[] inputs3 = new JComponent[n];
		for(int i = 0, j = 0; i + j < n; i ++, j++)
		{
			inputs3[i + j] = new JLabel(lista.get(i).getNaziv());
			inputs3[i + j + 1] = new JComboBox<String>(new DefaultComboBoxModel<String>(podaciKomponente));
		}
		result = JOptionPane.showOptionDialog(null, inputs3, "Stanje Komponenti", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
		if(result != 0)
			return;
		String id =  tf.getText() + cb.getSelectedItem();
		String []pod = {id, tf.getText(), cb.getSelectedItem().toString()};
		dmS.addRow(pod);
		states.setRowSelectionInterval(states.getRowCount() - 1, states.getRowCount() - 1);
		SelectState();
		State st = new State(ts, tf.getText());
		st.setAkcije(akcije);
		for(int i = 0, j = 0; i + j < n; i ++, j++)
		{
			if(((JComboBox)inputs3[i + j + 1]).getSelectedIndex() == 0)
			{
				st.getMandatory_list().add(lista.get(i));
			}
			else if(((JComboBox)inputs3[i + j + 1]).getSelectedIndex() == 1)
			{
				st.getDelete_list().add(lista.get(i));
			}
			else
			{
				st.getHide_list().add(lista.get(i));
			}
		}
		MainTest.data.getStanje().add(st);
	}
	
	private void AddTransiton()
	{
		JComponent[] inputs = new JComponent[8];
		inputs[0] = new JLabel("Naziv");
		inputs[1] = new JTextField();
		inputs[2] = new JLabel("Fail State");
		int vel = MainTest.data.getStanje().size();
		String []podFail = new String[vel];
		for(int i = 0; i < vel; i++)
		{
			podFail[i] = MainTest.data.getStanje().get(i).getNazivStanja();
		}
		inputs[3] = new JComboBox<String>(new DefaultComboBoxModel<String>(podFail));
		inputs[4] = new JLabel("Succes State");
		String []podSucces = new String[vel];
		for(int i = 0; i < vel; i++)
		{
			podSucces[i] = MainTest.data.getStanje().get(i).getNazivStanja();
		}
		inputs[5] = new JComboBox<String>(new DefaultComboBoxModel<String>(podSucces));
		
		inputs[6] = new JLabel("From State");
		String []podFrom = new String[vel];
		for(int i = 0; i < vel; i++)
		{
			if(MainTest.data.getStanje().get(i).getAkcije().size() > MainTest.data.getStanje().get(i).getTranzicija().size())
				podFrom[i] = MainTest.data.getStanje().get(i).getNazivStanja();
		}
		inputs[7] = new JComboBox<String>(new DefaultComboBoxModel<String>(podFrom));
		
		
		
		int result = JOptionPane.showOptionDialog(null, inputs, "My custom dialog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
		if(result != 0)
			return;
		if(((JComboBox)inputs[3]).getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(null, "Morate imati stanja da bi dodali tranziciju", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(((JComboBox)inputs[7]).getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(null, "Ne postojece stanje", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if(((JTextField)inputs[1]).getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Ne moze se dodati tranzicija bez naziva", "Error", JOptionPane.ERROR_MESSAGE);
			AddTransiton();
			return;
		}
		
		for(Tranzicija tr : MainTest.data.getTranzicija())
		{
			if(tr.getNaziv().equals(((JTextField)inputs[1]).getText()))
			{
				JOptionPane.showMessageDialog(null, "Naziv tranzicije vec postoji", "Error", JOptionPane.ERROR_MESSAGE);
				AddTransiton();
				return;
			}
		}
		State fail = MainTest.data.getStanje().get(((JComboBox)inputs[3]).getSelectedIndex());
		State succes = MainTest.data.getStanje().get(((JComboBox)inputs[5]).getSelectedIndex());
		State from = new State();
		for(State s : MainTest.data.getStanje())
		{
			if(s.getNazivStanja().equals(((JComboBox)inputs[7]).getSelectedItem()))
			{
				from = s;
			}
		}
		
		
		Tranzicija tr = new Tranzicija(fail, succes, ((JTextField)inputs[1]).getText());
		
		JComponent[] inputs2 = new JComponent[2];
		inputs2[0] = new JLabel("Dozvoljene Akcije");
		int velA = MainTest.data.getStanje().get(((JComboBox)inputs[7]).getSelectedIndex()).getAkcije().size();
		String []podAkcije = new String[velA];
		for(int i = 0; i < velA; i++)
		{
			Akcija a = MainTest.data.getStanje().get(((JComboBox)inputs[7]).getSelectedIndex()).getAkcije().get(i);
			if(!MainTest.data.getStanje().get(((JComboBox)inputs[7]).getSelectedIndex()).getTranzicija().containsKey(a))
				podAkcije[i] = a.getVrsta().toString();
		}
		inputs2[1] = new JComboBox<String>(new DefaultComboBoxModel<String>(podAkcije));
		result = JOptionPane.showOptionDialog(null, inputs2, "My custom dialog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
		if(result != 0)
			return;
		if(((JComboBox)inputs2[1]).getSelectedIndex() == -1)
		{
			JOptionPane.showMessageDialog(null, "Ne postojeca akcija", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		for(Akcija a : from.getAkcije())
		{
			
			if(a.getVrsta().toString().equals(((JComboBox)inputs2[1]).getSelectedItem()))
			{
				from.getTranzicija().put(a, tr);
				
			}
		}
		
		MainTest.data.getTranzicija().add(tr);
		
		String []pod = {tr.getNaziv(), from.getNazivStanja(),fail.getNazivStanja(), succes.getNazivStanja()};
		dmTr.addRow(pod);
		transitons.setRowSelectionInterval(transitons.getRowCount() - 1, transitons.getRowCount() - 1);
		SelectTransiton();
		
	}
	
	private void Delete()
	{
		if(states.getSelectedRow() != -1)
		{
			ArrayList<Tranzicija> listTr = new ArrayList<Tranzicija>();
			for (Map.Entry<Akcija, Tranzicija> mapEntry : MainTest.data.getStanje().get(states.getSelectedRow()).getTranzicija().entrySet()) {
				listTr.add(mapEntry.getValue());
			}
			
			
			
			//ArrayList<Tranzicija> listTr = MainTest.data.getStanje().get(states.getSelectedRow()).getTranzicija().values()
			
			MainTest.data.getStanje().remove(states.getSelectedRow());
			dmS.removeRow(states.getSelectedRow());

			for(Tranzicija tranBris : listTr)
			{
				int i = 0;
				for(Tranzicija el : MainTest.data.getTranzicija())
				{
					
					if(el.getNaziv().equals(tranBris.getNaziv()))
					{
						MainTest.data.getTranzicija().remove(el);
						dmTr.removeRow(i);
						break;
					}
					i++;
				}
			}
			
			
		}
		else if(transitons.getSelectedRow() != -1)
		{
			for(State s : MainTest.data.getStanje())
			{
				if(s.getTranzicija().containsValue(MainTest.data.getTranzicija().get(transitons.getSelectedRow())))
				{
					for(Map.Entry<Akcija, Tranzicija> mapEntry : s.getTranzicija().entrySet())
					{
						if(mapEntry.getValue().getNaziv().equals(MainTest.data.getTranzicija().get(transitons.getSelectedRow()).getNaziv()))
						s.getTranzicija().remove(mapEntry.getKey());
						break;
					}
				}
			}
			MainTest.data.getTranzicija().remove(transitons.getSelectedRow());
			dmTr.removeRow(transitons.getSelectedRow());
		}
	}
	
	private void Edit()
	{
		if(states.getSelectedRow() != -1)
		{
			JComponent[] inputs = new JComponent[4];
			inputs[0] = new JLabel("Naziv");
			JTextField tf = new JTextField();
			inputs[1] = tf;
			int result = JOptionPane.showOptionDialog(null, inputs, "Osnovni atributi", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
			if(result == 0 && tf.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Ne moze se dodati state bez naziva", "Error", JOptionPane.ERROR_MESSAGE);
				AddState();
				return;
			}
			else if(result != 0)
				return;
			for(State s : MainTest.data.getStanje())
			{
				if(s.getNazivStanja().equals(tf.getText()))
				{
					JOptionPane.showMessageDialog(null, "Naziv stanja vec postoji", "Error", JOptionPane.ERROR_MESSAGE);
					AddState();
					return;
				}
			}
			ArrayList<Akcija> akcije = MainTest.data.getStanje().get(states.getSelectedRow()).getAkcije();
			if(MainTest.data.getStanje().get(states.getSelectedRow()).getTranzicija().size() == 0)
			{
			String []podaciAkcije = {"Enabled", "Disabled"};
			JComponent[] inputs2 = new JComponent[8];
			inputs2[0] = new JLabel("Save");
			JComboBox<String> cbA1 = new JComboBox<String>();
			cbA1.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
			inputs2[1] = cbA1;
			inputs2[2] = new JLabel("Submit");
			JComboBox<String> cbA2 = new JComboBox<String>();
			cbA2.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
			inputs2[3] = cbA2;
			inputs2[4] = new JLabel("Reject");
			JComboBox<String> cbA3 = new JComboBox<String>();
			cbA3.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
			inputs2[5] = cbA3;
			inputs2[6] = new JLabel("Archive");
			JComboBox<String> cbA4 = new JComboBox<String>();
			cbA4.setModel(new DefaultComboBoxModel<String>(podaciAkcije));
			inputs2[7] = cbA4;
			
			
			result = JOptionPane.showOptionDialog(null, inputs2, "Moguce akcije", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
			if(result != 0)
				return;
			
			for(int i = 0, j = 0; i + j < 8; i ++, j++)
			{
				if(((JComboBox)inputs2[i + j + 1]).getSelectedIndex() == 0)
				{
					Akcija a = new Akcija(VrstaAkcije.values()[i]);
					akcije.add(a);
				}
			}
			}
			String []podaciKomponente = {"Mandatory", "Delete", "Hide"};
			ArrayList<Komponenta> lista = MainTest.data.getDokument().getKomponente();
			int n = 2 * lista.size();
			//System.out.println(n);
			JComponent[] inputs3 = new JComponent[n];
			for(int i = 0, j = 0; i + j < n; i ++, j++)
			{
				inputs3[i + j] = new JLabel(lista.get(i).getNaziv());
				inputs3[i + j + 1] = new JComboBox<String>(new DefaultComboBoxModel<String>(podaciKomponente));
			}
			result = JOptionPane.showOptionDialog(null, inputs3, "Stanje Komponenti", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
			if(result != 0)
				return;
			
			State st = MainTest.data.getStanje().get(states.getSelectedRow());
			st.setAkcije(akcije);
			for(int i = 0, j = 0; i + j < n; i ++, j++)
			{
				if(((JComboBox)inputs3[i + j + 1]).getSelectedIndex() == 0)
				{
					st.getMandatory_list().add(lista.get(i));
				}
				else if(((JComboBox)inputs3[i + j + 1]).getSelectedIndex() == 1)
				{
					st.getDelete_list().add(lista.get(i));
				}
				else
				{
					st.getHide_list().add(lista.get(i));
				}
			}
			
			st.setNazivStanja(tf.getText());
			st.setStanjeId(st.getNazivStanja() + st.getTipStanja());
			String []pod = {st.getStanjeId(), st.getNazivStanja(), st.getTipStanja().toString()};
			dmS.insertRow(states.getSelectedRow(), pod);
			dmS.removeRow(states.getSelectedRow());
		}
		else if(transitons.getSelectedRow() != -1)
		{
			JComponent[] inputs = new JComponent[8];
			inputs[0] = new JLabel("Naziv");
			inputs[1] = new JTextField();
			inputs[2] = new JLabel("Fail State");
			int vel = MainTest.data.getStanje().size();
			String []podFail = new String[vel];
			for(int i = 0; i < vel; i++)
			{
				podFail[i] = MainTest.data.getStanje().get(i).getNazivStanja();
			}
			inputs[3] = new JComboBox<String>(new DefaultComboBoxModel<String>(podFail));
			inputs[4] = new JLabel("Succes State");
			String []podSucces = new String[vel];
			for(int i = 0; i < vel; i++)
			{
				podSucces[i] = MainTest.data.getStanje().get(i).getNazivStanja();
			}
			inputs[5] = new JComboBox<String>(new DefaultComboBoxModel<String>(podSucces));
			
			inputs[6] = new JLabel("From State");
			String []podFrom = new String[vel];
			for(int i = 0; i < vel; i++)
			{
				if(MainTest.data.getStanje().get(i).getAkcije().size() > MainTest.data.getStanje().get(i).getTranzicija().size())
					podFrom[i] = MainTest.data.getStanje().get(i).getNazivStanja();
			}
			inputs[7] = new JComboBox<String>(new DefaultComboBoxModel<String>(podFrom));
			
			
			
			int result = JOptionPane.showOptionDialog(null, inputs, "My custom dialog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
			if(result != 0)
				return;
			if(((JComboBox)inputs[3]).getSelectedIndex() == -1)
			{
				JOptionPane.showMessageDialog(null, "Morate imati stanja da bi dodali tranziciju", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(((JComboBox)inputs[7]).getSelectedIndex() == -1)
			{
				JOptionPane.showMessageDialog(null, "Ne postojece stanje", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			if(((JTextField)inputs[1]).getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Ne moze se dodati tranzicija bez naziva", "Error", JOptionPane.ERROR_MESSAGE);
				AddTransiton();
				return;
			}
			
			for(Tranzicija tr : MainTest.data.getTranzicija())
			{
				if(tr.getNaziv().equals(((JTextField)inputs[1]).getText()))
				{
					JOptionPane.showMessageDialog(null, "Naziv tranzicije vec postoji", "Error", JOptionPane.ERROR_MESSAGE);
					AddTransiton();
					return;
				}
			}
			State fail = MainTest.data.getStanje().get(((JComboBox)inputs[3]).getSelectedIndex());
			State succes = MainTest.data.getStanje().get(((JComboBox)inputs[5]).getSelectedIndex());
			State from = new State();
			for(State s : MainTest.data.getStanje())
			{
				if(s.getNazivStanja().equals(((JComboBox)inputs[7]).getSelectedItem()))
				{
					from = s;
				}
			}
			
			
			//Tranzicija tr = new Tranzicija(fail, succes, ((JTextField)inputs[1]).getText());
			Tranzicija tr = MainTest.data.getTranzicija().get(transitons.getSelectedRow());
			
			
			JComponent[] inputs2 = new JComponent[2];
			inputs2[0] = new JLabel("Dozvoljene Akcije");
			int velA = MainTest.data.getStanje().get(((JComboBox)inputs[7]).getSelectedIndex()).getAkcije().size();
			String []podAkcije = new String[velA];
			for(int i = 0; i < velA; i++)
			{
				Akcija a = MainTest.data.getStanje().get(((JComboBox)inputs[7]).getSelectedIndex()).getAkcije().get(i);
				if(!MainTest.data.getStanje().get(((JComboBox)inputs[7]).getSelectedIndex()).getTranzicija().containsKey(a))
					podAkcije[i] = a.getVrsta().toString();
			}
			inputs2[1] = new JComboBox<String>(new DefaultComboBoxModel<String>(podAkcije));
			result = JOptionPane.showOptionDialog(null, inputs2, "My custom dialog", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null, null,null);
			if(result != 0)
				return;
			if(((JComboBox)inputs2[1]).getSelectedIndex() == -1)
			{
				JOptionPane.showMessageDialog(null, "Ne postojeca akcija", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			for(State s : MainTest.data.getStanje())
			{
				if(s.getTranzicija().containsValue(tr))
				{
					for(Map.Entry<Akcija, Tranzicija> mapEntry : s.getTranzicija().entrySet())
					{
						if(mapEntry.getValue().getNaziv().equals(tr.getNaziv()))
						s.getTranzicija().remove(mapEntry.getKey());
						break;
					}
				}
			}
			for(Akcija a : from.getAkcije())
			{
				
				if(a.getVrsta().toString().equals(((JComboBox)inputs2[1]).getSelectedItem()))
				{
					from.getTranzicija().put(a, tr);
					
				}
			}
			
			
			
		}
	}

}
