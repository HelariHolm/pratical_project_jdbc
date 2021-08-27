package model;

import java.util.Calendar;

public class Reservation {

    private int reservation_id;
    private Calendar reservation;
    private int processed_by;
    private int customer_id;
    private int vehicle_id;

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Calendar getReservation() {
        return reservation;
    }

    public void setReservation(Calendar reservation) {
        this.reservation = reservation;
    }

    public int getProcessed_by() {
        return processed_by;
    }

    public void setProcessed_by(int processed_by) {
        this.processed_by = processed_by;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservation_id=" + reservation_id +
                ", reservation='" + reservation + '\'' +
                ", processed_by='" + processed_by + '\'' +
                ", customer_id='" + customer_id + '\'' +
                ", vehicle_id='" + vehicle_id +
                '}';
    }
}
