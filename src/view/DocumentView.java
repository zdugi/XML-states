package view;

import tools.FieldTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocumentView extends JPanel {

    public DocumentView() {
        GridBagLayout gbl_doc = new GridBagLayout();
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

        FieldView txtField = new FieldView("Name: ", FieldTypes.TEXTFIELD);
        GridBagConstraints gbc_txtField = new GridBagConstraints();
        gbc_txtField.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtField.insets = new Insets(0, 0, 5, 0);
        gbc_txtField.anchor = GridBagConstraints.WEST;
        gbc_txtField.gridx = 0;
        gbc_txtField.gridy = 0;
        fieldSpace.add(txtField, gbc_txtField);

        FieldView txtField1 = new FieldView("Name: ", FieldTypes.TEXTFIELD);
        GridBagConstraints gbc_txtField1 = new GridBagConstraints();
        gbc_txtField1.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtField1.insets = new Insets(0, 0, 5, 0);
        gbc_txtField1.anchor = GridBagConstraints.WEST;
        gbc_txtField1.gridx = 0;
        gbc_txtField1.gridy = 1;
        fieldSpace.add(txtField1, gbc_txtField1);

        FieldView dateField = new FieldView("Name: ", FieldTypes.DATE);
        GridBagConstraints gbc_txtField2 = new GridBagConstraints();
        gbc_txtField2.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtField2.insets = new Insets(0, 0, 5, 0);
        gbc_txtField2.anchor = GridBagConstraints.WEST;
        gbc_txtField2.gridx = 0;
        gbc_txtField2.gridy = 2;
        fieldSpace.add(dateField, gbc_txtField2);

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

        ActionView btnSave = new ActionView("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        GridBagConstraints gbc_btnSave = new GridBagConstraints();
        gbc_btnSave.fill = GridBagConstraints.BOTH;
        gbc_btnSave.insets = new Insets(0, 0, 5, 0);
        gbc_btnSave.anchor = GridBagConstraints.WEST;
        gbc_btnSave.gridx = 0;
        gbc_btnSave.gridy = 0;
        actionSpace.add(btnSave, gbc_btnSave);

        ActionView btnSubmit = new ActionView("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
        gbc_btnSubmit.fill = GridBagConstraints.BOTH;
        gbc_btnSubmit.insets = new Insets(0, 0, 5, 0);
        gbc_btnSubmit.gridx = 0;
        gbc_btnSubmit.gridy = 1;
        actionSpace.add(btnSubmit, gbc_btnSubmit);

        ActionView btnReject = new ActionView("Reject");
        btnReject.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        GridBagConstraints gbc_btnReject = new GridBagConstraints();
        gbc_btnReject.fill = GridBagConstraints.BOTH;
        gbc_btnReject.insets = new Insets(0, 0, 5, 0);
        gbc_btnReject.gridx = 0;
        gbc_btnReject.gridy = 2;
        actionSpace.add(btnReject, gbc_btnReject);

        ActionView btnArchive = new ActionView("Archive");
        btnArchive.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        GridBagConstraints gbc_btnArchive = new GridBagConstraints();
        gbc_btnArchive.fill = GridBagConstraints.BOTH;
        gbc_btnArchive.gridx = 0;
        gbc_btnArchive.gridy = 3;
        actionSpace.add(btnArchive, gbc_btnArchive);
    }
}
