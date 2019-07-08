package model;

import tools.FieldTypes;

public class Field {
    private FieldTypes fieldType;
    private String fieldName;
    private int fieldId;
    private boolean empty;
    private String fieldDisplayName;

    public Field(FieldTypes fieldType, String fieldName, int fieldId) {
        this.fieldType = fieldType;
        this.fieldName = fieldName;
        this.fieldId = fieldId;
        this.empty = true;
        this.fieldDisplayName = fieldName;
    }

    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public FieldTypes getFieldType() {
        return fieldType;
    }

    public void setFieldType(FieldTypes fieldType) {
        this.fieldType = fieldType;
    }

    public boolean isEmpty() { return empty; }

    public void setEmpty(boolean empty) { this.empty = empty; }

    public String getFieldDisplayName() { return fieldDisplayName; }

    public void setFieldDisplayName(String fieldDisplayName) { this.fieldDisplayName = fieldDisplayName; }
}
