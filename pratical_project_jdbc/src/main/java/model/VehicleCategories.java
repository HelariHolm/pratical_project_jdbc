package model;

public class VehicleCategories {

    private int veh_category_id;
    private String veh_category;

    public int getVeh_category_id() {
        return veh_category_id;
    }

    public void setVeh_category_id(int veh_category_id) {
        this.veh_category_id = veh_category_id;
    }

    public String getVeh_category() {
        return veh_category;
    }

    public void setVeh_category(String veh_category) {
        this.veh_category = veh_category;
    }

    @Override
    public String toString() {
        return "Vehicle_categories{" +
                "veh_category_id=" + veh_category_id +
                ", veh_category='" + veh_category +
                '}';
    }
}
