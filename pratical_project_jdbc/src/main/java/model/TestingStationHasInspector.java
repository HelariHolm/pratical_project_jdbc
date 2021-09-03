package model;

public class TestingStationHasInspector {

    private int stationId;
    private int inspectorId;

    public int getStationId() {
        return stationId;
    }

    public void setStationId(int stationId) {
        this.stationId = stationId;
    }

    public int getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(int inspectorId) {
        this.inspectorId = inspectorId;
    }

    @Override
    public String toString() {
        return "TestingStationHasInspector{" +
                "station_id='" + stationId + '\'' +
                ", inspector_id=" + inspectorId +
                '}';
    }
}
