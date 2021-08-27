package model;

public class TestingStation {

    private int station_id;
    private int veh_category_id;
    private String address;
    private int company_id;

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getVeh_category_id() {
        return veh_category_id;
    }

    public void setVeh_category_id(int veh_category_id) {
        this.veh_category_id = veh_category_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    @Override
    public String toString() {
        return "TestingStation{" +
                "station_id=" + station_id +
                ", veh_category_id='" + veh_category_id + '\'' +
                ", address='" + address + '\'' +
                ", company_id='" + company_id +
                '}';
    }
}
