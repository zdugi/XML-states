package main;

import tools.XMLReader;
import view.DocumentView;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;

public class GUIApplication extends JFrame {
    private DocumentView documentView;
    private String documentPath;

    public GUIApplication() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("XML-states");
        setSize(600, 400);
        setMinimumSize(new Dimension(450, 250));
        setLocationRelativeTo(null);

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem load, close;

        menuBar = new JMenuBar();
        menu = new JMenu("File");
        load = new JMenuItem("Load");
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser j = new JFileChooser();
                j.setAcceptAllFileFilterUsed(false);
                j.setDialogTitle("Select a .xml file");
                FileNameExtensionFilter restrict = new FileNameExtensionFilter("XML document file (*.xml)", "xml");
                j.addChoosableFileFilter(restrict);
                int retVal = j.showOpenDialog(null);
                if(retVal == JFileChooser.APPROVE_OPTION)
                {
                    documentPath = j.getSelectedFile().getAbsolutePath();
                    documentView = new DocumentView();
                    documentView.setDocument(XMLReader.readXML(documentPath));
                    setContentPane(documentView);
                    GUIApplication.this.invalidate();
                    GUIApplication.this.validate();
                    GUIApplication.this.repaint();
                }
            }
        });
        close = new JMenuItem("Close");
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Confirm", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else{
                    //Do nothing
                }
            }
        });

        //close.addActionListener();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "Are you sure? ", "Confirm", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }else{
                    //Do nothing
                }
            }
        });

        menuBar.add(menu);
        menu.add(load);
        menu.addSeparator();
        menu.add(close);
        setJMenuBar(menuBar);
    }
    public static void main(String[] argv) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GUIApplication().setVisible(true);
    }
}
