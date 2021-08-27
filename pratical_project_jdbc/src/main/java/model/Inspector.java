package model;

import java.util.Date;

public class Inspector {

    private int inspector_id;
    private String firstName;
    private String lastName;
    private Date licence_expiry;
    private int veh_category_id;

    public int getInspector_id() {
        return inspector_id;
    }

    public void setInspector_id(int inspector_id) {
        this.inspector_id = inspector_id;
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

    public Date getLicence_expiry() {
        return licence_expiry;
    }

    public void setLicence_expiry(Date licence_expiry) {
        this.licence_expiry = licence_expiry;
    }

    public int getVeh_category_id() {
        return veh_category_id;
    }

    public void setVeh_category_id(int veh_category_id) {
        this.veh_category_id = veh_category_id;
    }

    @Override
    public String toString() {
        return "Inspector{" +
                "inspector_id=" + inspector_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", veh_category_id='" + veh_category_id +
                '}';
    }
}
