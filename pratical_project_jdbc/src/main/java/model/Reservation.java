package model;

import java.util.Calendar;

public class Reservation {

    private int reservationId;
    private Calendar reservation;
    private int processedBy;
    private int customerId;
    private int vehicleId;

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Calendar getReservation() {
        return reservation;
    }

    public void setReservation(Calendar reservation) {
        this.reservation = reservation;
    }

    public int getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(int processedBy) {
        this.processedBy = processedBy;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservationId +
                ", reservation='" + reservation + '\'' +
                ", processed_by='" + processedBy + '\'' +
                ", customer_id='" + customerId + '\'' +
                ", vehicle_id='" + vehicleId +
                '}';
    }
}
