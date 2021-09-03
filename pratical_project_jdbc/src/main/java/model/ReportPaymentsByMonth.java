package model;

public class ReportPaymentsByMonth {
    private double amountSum;
    private String month;
    private String year;

    public double getAmountSum() {
        return amountSum;
    }

    public void setAmountSum(double amountSum) {
        this.amountSum = amountSum;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
