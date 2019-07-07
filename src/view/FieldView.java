package view;

import tools.FieldTypes;

import javax.swing.*;
import java.awt.*;

public class FieldView extends JPanel {
    private JLabel label;
    private JComponent field;
    private FieldTypes fieldType;

    public FieldView(String text, FieldTypes type)
    {
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        label = new JLabel(text);
        fieldType = type;
        switch (fieldType)
        {
            case TEXTFIELD:
                field = new JTextField();
                field.setPreferredSize(new Dimension(200, 25));
            break;
            case CHECKBOX:
                field = new JCheckBox("");
            break;
            case DATE:
                // field = new JCalelendar();
            break;
            default:
        }

        add(label);
        add(field);
    }
}
