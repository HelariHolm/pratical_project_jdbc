package model;

import java.util.Date;

public class Inspection {

    private int inspection_id;
    private int inspector_id;
    private int inspection_type_id;
    private int reservation_id;
    private int vehicle_id;
    private double emissions;
    private double brakes;
    private String faults;
    private Date valid_until;

    public int getInspection_id() {
        return inspection_id;
    }

    public void setInspection_id(int inspection_id) {
        this.inspection_id = inspection_id;
    }

    public int getInspector_id() {
        return inspector_id;
    }

    public void setInspector_id(int inspector_id) {
        this.inspector_id = inspector_id;
    }

    public int getInspection_type_id() {
        return inspection_type_id;
    }

    public void setInspection_type_id(int inspection_type_id) {
        this.inspection_type_id = inspection_type_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public double getEmissions() {
        return emissions;
    }

    public void setEmissions(double emissions) {
        this.emissions = emissions;
    }

    public double getBrakes() {
        return brakes;
    }

    public void setBrakes(double brakes) {
        this.brakes = brakes;
    }

    public String getFaults() {
        return faults;
    }

    public void setFaults(String faults) {
        this.faults = faults;
    }

    public Date getValid_until() {
        return valid_until;
    }

    public void setValid_until(Date valid_until) {
        this.valid_until = valid_until;
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "inspection_id=" + inspection_id +
                ", inspector_id='" + inspector_id + '\'' +
                ", inspection_type_id='" + inspection_type_id + '\'' +
                ", reservation_id='" + reservation_id + '\'' +
                ", vehicle_id='" + vehicle_id + '\'' +
                ", emissions='" + emissions + '\'' +
                ", brakes='" + brakes + '\'' +
                ", faults=" + faults + '\'' +
                ", valid_until=" + valid_until +
                '}';
    }
}
