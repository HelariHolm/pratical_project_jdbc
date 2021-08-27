package model;

public class TestingStationHasInspector {

    private int station_id;
    private int inspector_id;

    public int getStation_id() {
        return station_id;
    }

    public void setStation_id(int station_id) {
        this.station_id = station_id;
    }

    public int getInspector_id() {
        return inspector_id;
    }

    public void setInspector_id(int inspector_id) {
        this.inspector_id = inspector_id;
    }

    @Override
    public String toString() {
        return "TestingStationHasInspector{" +
                "station_id='" + station_id + '\'' +
                ", inspector_id=" + inspector_id +
                '}';
    }
}
