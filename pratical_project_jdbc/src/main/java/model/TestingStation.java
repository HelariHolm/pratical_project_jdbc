package model;

public class TestingStation {

    private int stationId;
    private int vehCategoryId;
    private String address;
    private int companyId;

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getVehCategoryId() {
        return vehCategoryId;
    }

    public void setVehCategoryId(int vehCategoryId) {
        this.vehCategoryId = vehCategoryId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "TestingStation{" +
                "station_id=" + stationId +
                ", veh_category_id='" + vehCategoryId + '\'' +
                ", address='" + address + '\'' +
                ", company_id='" + companyId +
                '}';
    }
}
