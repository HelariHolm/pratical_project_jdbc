package model;

import java.util.Date;

public class Inspection {

    private int inspectionId;
    private int inspectorId;
    private int inspectionTypeId;
    private int reservationId;
    private int vehicleId;
    private double emissions;
    private double brakes;
    private String faults;
    private Date validUntil;

    public int getInspectionId() {
        return inspectionId;
    }

    public void setInspectionId(int inspectionId) {
        this.inspectionId = inspectionId;
    }

    public int getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    public int getInspectionTypeId() {
        return inspectionTypeId;
    }

    public void setInspectionTypeId(int inspectionTypeId) {
        this.inspectionTypeId = inspectionTypeId;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
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

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    @Override
    public String toString() {
        return "Inspection{" +
                "inspection_id=" + inspectionId +
                ", inspector_id='" + inspectorId + '\'' +
                ", inspection_type_id='" + inspectionTypeId + '\'' +
                ", reservation_id='" + reservationId + '\'' +
                ", vehicle_id='" + vehicleId + '\'' +
                ", emissions='" + emissions + '\'' +
                ", brakes='" + brakes + '\'' +
                ", faults=" + faults + '\'' +
                ", valid_until=" + validUntil +
                '}';
    }
}
