package model;

import tools.FieldTypes;

public class Field {
    private FieldTypes fieldType;
    private String fieldName;
    private int fieldId;

    public Field(FieldTypes fieldType, String fieldName, int fieldId) {
        this.fieldType = fieldType;
        this.fieldName = fieldName;
        this.fieldId = fieldId;
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
}
