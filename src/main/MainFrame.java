package main;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {
    private MainFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("XML-states");
        setSize(800, 600);
        setLocationRelativeTo(null);

        JMenuBar menuBar;
        JMenu menu;
        JMenuItem load, close;

        menuBar = new JMenuBar();
        menu = new JMenu("File");
        load = new JMenuItem("Load");
        load.setMnemonic(KeyEvent.VK_L);
        close = new JMenuItem("Close");
        close.setMnemonic(KeyEvent.VK_C);

        menuBar.add(menu);
        menu.add(load);
        menu.addSeparator();
        menu.add(close);
        setJMenuBar(menuBar);

    }
    public static void main(String[] argv)
    {
        new MainFrame().setVisible(true);
    }
}
