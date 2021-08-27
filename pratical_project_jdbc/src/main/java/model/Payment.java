package model;

import java.util.Date;

public class Payment {

    private int payment_id;
    private double amount;
    private Date payment_date;
    private int reservation_id;
    private int processed_by;

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getProcessed_by() {
        return processed_by;
    }

    public void setProcessed_by(int processed_by) {
        this.processed_by = processed_by;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + payment_id +
                ", amount='" + amount + '\'' +
                ", payment_date='" + payment_date + '\'' +
                ", reservation_id='" + reservation_id + '\'' +
                ", processed_by='" + processed_by +
                '}';
    }
}
