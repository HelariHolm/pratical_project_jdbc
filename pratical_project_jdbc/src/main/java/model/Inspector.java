package model;

import java.util.Date;

public class Inspector {

    private int inspectorId;
    private String firstName;
    private String lastName;
    private Date licenceExpiry;
    private int vehCategoryId;

    public int getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLicenceExpiry() {
        return licenceExpiry;
    }

    public void setLicenceExpiry(Date licenceExpiry) {
        this.licenceExpiry = licenceExpiry;
    }

    public int getVehCategoryId() {
        return vehCategoryId;
    }

    public void setVehCategoryId(int vehCategoryId) {
        this.vehCategoryId = vehCategoryId;
    }

    @Override
    public String toString() {
        return "Inspector{" +
                "inspector_id=" + inspectorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", veh_category_id='" + vehCategoryId +
                '}';
    }
}
