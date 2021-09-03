package model;

public class VehicleCategories {

    private int vehCategoryId;
    private String vehCategory;

    public int getVehCategoryId() {
        return vehCategoryId;
    }

    public void setVehCategoryId(int vehCategoryId) {
        this.vehCategoryId = vehCategoryId;
    }

    public String getVehCategory() {
        return vehCategory;
    }

    public void setVehCategory(String vehCategory) {
        this.vehCategory = vehCategory;
    }

    @Override
    public String toString() {
        return "Vehicle_categories{" +
                "veh_category_id=" + vehCategoryId +
                ", veh_category='" + vehCategory +
                '}';
    }
}
