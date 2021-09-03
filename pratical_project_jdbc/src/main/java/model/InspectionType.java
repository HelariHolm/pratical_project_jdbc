package model;

public class InspectionType {

    private int inspectionTypeId;
    private String typeName;

    public int getInspectionTypeId() {
        return inspectionTypeId;
    }

    public void setInspectionTypeId(int inspectionTypeId) {
        this.inspectionTypeId = inspectionTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "InspectionType{" +
                "inspection_type_id=" + inspectionTypeId +
                ", type_name='" + typeName +
                '}';
    }
}
