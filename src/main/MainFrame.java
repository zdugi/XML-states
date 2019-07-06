package main;

import javax.swing.*;

public class MainFrame extends JFrame {
    public MainFrame() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("XML-states");
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    public static void main(String[] argv)
    {
        new MainFrame().setVisible(true);
    }
}
