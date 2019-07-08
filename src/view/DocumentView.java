package view;

import controller.Controller;
import model.Document;
import model.Field;
import model.Action;
import model.Transition;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentView extends JPanel {
    private Document document;



    public DocumentView(Document document) {
        this.document = document;
    }

    public void updateView() {
        this.removeAll();

        GridBagLayout gbl_doc;

        gbl_doc = new GridBagLayout();
        gbl_doc.columnWidths = new int[]{0, 0, 0};
        gbl_doc.rowHeights = new int[]{0, 0};
        gbl_doc.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        gbl_doc.rowWeights = new double[]{1.0, Double.MIN_VALUE};
        setLayout(gbl_doc);

        JPanel fieldSpace = new JPanel();
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.insets = new Insets(0, 0, 0, 5);
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 0;

        JScrollPane scrollArea = new JScrollPane();
        scrollArea.setBorder(BorderFactory.createEmptyBorder());
        scrollArea.setViewportView(fieldSpace);
        add(scrollArea, gbc_panel);

        GridBagLayout gbl_fld_panel = new GridBagLayout();
        gbl_fld_panel.columnWidths = new int[]{85, 0};
        gbl_fld_panel.rowHeights = new int[]{21, 0, 0, 0, 0};
        gbl_fld_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_fld_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        fieldSpace.setLayout(gbl_fld_panel);

        // Generate fields
        int row = 0;

        for (Field field : this.document.getFields()) {
            boolean mandatory = document.getCurrentState().getMandatory().contains(field);
            boolean deleted = document.getCurrentState().getDeleted().contains(field);
            boolean hidden = document.getCurrentState().getHidden().contains(field);

            // Show field only if it is mandatory or 'default'
            if (mandatory || (!mandatory && !deleted && !hidden)) {
                String displayName = field.getFieldName();

                if (mandatory)
                    displayName = "* " + displayName;

                field.setFieldDisplayName(displayName);
                FieldView txtField = new FieldView(field);
                GridBagConstraints gbc_txtField = new GridBagConstraints();
                gbc_txtField.fill = GridBagConstraints.HORIZONTAL;
                gbc_txtField.insets = new Insets(0, 0, 5, 0);
                gbc_txtField.anchor = GridBagConstraints.WEST;
                gbc_txtField.gridx = 0;
                gbc_txtField.gridy = row++;
                fieldSpace.add(txtField, gbc_txtField);
            }
            // else: deleted or hidden, do nothing
        }

        JPanel actionSpace = new JPanel();
        GridBagConstraints gbc_panel_1 = new GridBagConstraints();
        gbc_panel_1.fill = GridBagConstraints.BOTH;
        gbc_panel_1.gridx = 1;
        gbc_panel_1.gridy = 0;
        add(actionSpace, gbc_panel_1);

        GridBagLayout gbl_act_panel = new GridBagLayout();
        gbl_act_panel.columnWidths = new int[]{85, 0};
        gbl_act_panel.rowHeights = new int[]{40, 40, 40, 40, 40};
        gbl_act_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_act_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        actionSpace.setLayout(gbl_act_panel);

        // Generate actions - buttons
        Controller controller = new Controller(this.document, this);
        row = 0;

        for (Action action : document.getActions()) {
            Transition trans = document.getCurrentState().getTransition(action.getActionID());

            if (trans != null) {
                ActionView btnSave = new ActionView(action.getName());

                btnSave.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        controller.performTransition(trans);
                    }
                });

                GridBagConstraints gbc_btnSave = new GridBagConstraints();
                gbc_btnSave.fill = GridBagConstraints.BOTH;
                gbc_btnSave.insets = new Insets(0, 0, 5, 0);
                gbc_btnSave.anchor = GridBagConstraints.WEST;
                gbc_btnSave.gridx = 0;
                gbc_btnSave.gridy = row++;
                actionSpace.add(btnSave, gbc_btnSave);
            }
        }

        this.invalidate();
        this.validate();
        this.repaint();
    }

    public Document getDocument() { return document; }

    public void setDocument(Document document) {
        this.document = document;
        updateView();
    }
}
