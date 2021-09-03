package model;

import java.util.Date;

public class Statistics {

    private int paymentId;
    private double amount;
    private Date paymentDate;
    private int reservationId;
    private int processedBy;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(int processedBy) {
        this.processedBy = processedBy;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "payment_id=" + paymentId +
                ", amount='" + amount + '\'' +
                ", payment_date='" + paymentDate + '\'' +
                ", reservation_id='" + reservationId + '\'' +
                ", processed_by='" + processedBy +
                '}';
    }
}
