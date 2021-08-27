package model;

public class InspectionType {

    private int inspection_type_id;
    private String type_name;

    public int getInspection_type_id() {
        return inspection_type_id;
    }

    public void setInspection_type_id(int inspection_type_id) {
        this.inspection_type_id = inspection_type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    @Override
    public String toString() {
        return "InspectionType{" +
                "inspection_type_id=" + inspection_type_id +
                ", type_name='" + type_name +
                '}';
    }
}
