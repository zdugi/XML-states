package view;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import tools.FieldTypes;

import javax.swing.*;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

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
            break;
            case CHECKBOX:
                field = new JCheckBox("");
            break;
            case DATE:
                UtilDateModel model = new UtilDateModel();
                Properties p = new Properties();
                p.put("text.today", "Today");
                p.put("text.month", "Month");
                p.put("text.year", "Year");
                JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
                field = new JDatePickerImpl(datePanel, new DateLabelFormatter());
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
