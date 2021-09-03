package persistence;

import model.Inspection;
import model.ReportInspectionByInspector;
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
    ResultSet resultSet;

    public RepositoryInspection() {
        connection = DBUtil.getDBConnection();
    }

    public List<Inspection> listAllInspectionsByInspector(String firstName) {
        List<Inspection> inspectionsList = new ArrayList<>();
        String sql = "SELECT * FROM inspection INNER JOIN inspector ON inspection.inspector_id " +
                "= inspector.inspector_id WHERE firstname = ?";

        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(sql);
            pstmt.setString(1, firstName);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                System.out.println();
                Inspection inspection = new Inspection();
                inspection.setInspectionId(resultSet.getInt("inspection_id"));
                inspection.setInspectorId(resultSet.getInt("inspector_id"));
                inspection.setInspectionTypeId(resultSet.getInt("inspection_type_id"));
                inspection.setReservationId(resultSet.getInt("reservation_id"));
                inspection.setVehicleId(resultSet.getInt("vehicle_id"));
                inspection.setEmissions(resultSet.getDouble("emissions"));
                inspection.setBrakes(resultSet.getDouble("brakes"));
                inspection.setFaults(resultSet.getString("faults"));
                inspection.setValidUntil(resultSet.getDate("valid_until"));
                inspectionsList.add(inspection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inspectionsList;
    }

    public List<ReportInspectionByInspector> listInspectionsByInspector(String firstName) {
        List<ReportInspectionByInspector> list = new ArrayList<>();
        String query = "SELECT i.inspection_id, it.type_name, c.first_name, v.licence_plate, p.amount" +
                " FROM inspection i" +
                " INNER JOIN inspector x ON i.inspector_id = x.inspector_id" +
                " INNER JOIN inspection_type it ON i.inspection_type_id = it.inspection_type_id" +
                " INNER JOIN vehicle v ON i.vehicle_id = v.vehicle_id" +
                " INNER JOIN customer c ON v.customer_id = c.customer_id" +
                " INNER JOIN payment p ON i.reservation_id = p.reservation_id" +
                " WHERE x.firstname = ?;";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            pstmt.setString(1,firstName);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ReportInspectionByInspector report = new ReportInspectionByInspector();
                report.setInspectionId(resultSet.getInt("i.inspection_id"));
                report.setInspectionType(resultSet.getString("it.type_name"));
                report.setFirstName(resultSet.getString("c.first_name"));
                report.setLicencePlate(resultSet.getString("v.licence_plate"));
                report.setAmount(resultSet.getDouble("p.amount"));
                list.add(report);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}