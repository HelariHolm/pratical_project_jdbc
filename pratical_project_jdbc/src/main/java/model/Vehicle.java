package model;

public class Vehicle {

    private int vehicle_id;
    private String category;
    private String licence_plate;
    private String manufacturer;
    private String model;
    private String fuel_type;
    private int customer_id;

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLicence_plate() {
        return licence_plate;
    }

    public void setLicence_plate(String licence_plate) {
        this.licence_plate = licence_plate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFuel_type() {
        return fuel_type;
    }

    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", category='" + category + '\'' +
                ", licence_plate='" + licence_plate + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", fuel_type='" + fuel_type + '\'' +
                ", customer_id='" + customer_id +
                '}';
    }
}
