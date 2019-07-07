package view;

import model.Field;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class FieldView extends JPanel {
    private JLabel label;
    private JComponent field;
    private Field fieldModel;

    public FieldView(Field fieldModel)
    {
        this.fieldModel = fieldModel;
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        label = new JLabel(fieldModel.getFieldName());
        switch (fieldModel.getFieldType())
        {
            case TEXTFIELD:
                field = new JTextField();
                JTextField tempT = (JTextField)field;
                tempT.getDocument().addDocumentListener(new DocumentListener() {
                    public void changedUpdate(DocumentEvent e) {
                        changeEmpty();
                    }
                    public void removeUpdate(DocumentEvent e) {
                        changeEmpty();
                    }
                    public void insertUpdate(DocumentEvent e) {
                        changeEmpty();
                    }

                    public void changeEmpty()
                    {
                        if(tempT.getText().equals("")) {
                            fieldModel.setEmpty(true);
                        }
                        else
                        {
                            fieldModel.setEmpty(false);
                        }
                    }
                });
            break;
            case CHECKBOX:
                field = new JCheckBox("");
                JCheckBox tempC = (JCheckBox)field;
                tempC.addItemListener(new ItemListener() {
                    public void itemStateChanged(ItemEvent e) {
                        fieldModel.setEmpty(tempC.isSelected());
                    }
                });
            break;
            case DATE:
                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                field = new JDatePickerImpl(datePanel, new DateLabelFormatter());
                JFormattedTextField tempF = ((JDatePickerImpl)field).getJFormattedTextField();
                tempF.getDocument().addDocumentListener(new DocumentListener() {
                public void changedUpdate(DocumentEvent e) {
                    changeEmpty();
                }
                public void removeUpdate(DocumentEvent e) {
                    changeEmpty();
                }
                public void insertUpdate(DocumentEvent e) {
                    changeEmpty();
                }

                public void changeEmpty()
                {
                    if(tempF.getText().equals("")) {
                        fieldModel.setEmpty(true);
                    }
                    else
                    {
                        fieldModel.setEmpty(false);
                    }
                }
            });
            break;
            default:
        }

        field.setPreferredSize(new Dimension(200, 21));
        add(label);
        add(field);
    }

    class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "dd-MMM-yyyy";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }
}
