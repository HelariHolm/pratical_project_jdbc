package persistence;

import model.Inspection;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryInspection {

    private Connection connection;
    PreparedStatement pstmt;

    public RepositoryInspection() {
        connection = DBUtil.getDBConnection();
    }

    public List<Inspection> listAllInspectionsByInspector(String firstName) {
        List<Inspection> inspectionsList = new ArrayList<>();
        String sql = "SELECT * FROM inspection INNER JOIN inspector ON inspection.inspector_id = inspector.inspector_id WHERE firstname = ?";

        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            pstmt.setString(1, firstName);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                System.out.println();
                Inspection inspection = new Inspection();
                inspection.setInspection_id(resultSet.getInt("inspection_id"));
                inspection.setInspector_id(resultSet.getInt("inspector_id"));
                inspection.setInspection_type_id(resultSet.getInt("inspection_type_id"));
                inspection.setReservation_id(resultSet.getInt("reservation_id"));
                inspection.setVehicle_id(resultSet.getInt("vehicle_id"));
                inspection.setEmissions(resultSet.getDouble("emissions"));
                inspection.setBrakes(resultSet.getDouble("brakes"));
                inspection.setFaults(resultSet.getString("faults"));
                inspection.setValid_until(resultSet.getDate("valid_until"));
                inspectionsList.add(inspection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inspectionsList;
    }


}