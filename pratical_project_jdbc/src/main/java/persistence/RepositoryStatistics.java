package persistence;

import model.ReportAllInspectionsByMonths;
import model.ReportInspectionsByType;
import model.ReportPaymentsByMonth;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositoryStatistics {

    private Connection connection;
    PreparedStatement pstmt;
    ResultSet resultSet;

    public RepositoryStatistics() {
        connection = DBUtil.getDBConnection();
    }

    public List<ReportPaymentsByMonth> paymentsByMonth() {
        List<ReportPaymentsByMonth> list = new ArrayList<>();
        String query = "SELECT SUM(amount), MONTHNAME(payment_date), YEAR(payment_date) " +
                "FROM payment GROUP BY MONTH(payment_date)";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ReportPaymentsByMonth report = new ReportPaymentsByMonth();
                report.setMonth(resultSet.getString("MONTHNAME(payment_date)"));
                report.setYear(resultSet.getString("YEAR(payment_date)"));
                report.setAmountSum(resultSet.getDouble("SUM(amount)"));
                list.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<ReportAllInspectionsByMonths> inspectionsBySpecificInspector(String firstName) {
        List<ReportAllInspectionsByMonths> list = new ArrayList<>();
        String query = "SELECT COUNT(inspection.inspection_id) AS inspection_count, " +
                "MONTHNAME(inspection.inspection_date) AS inspection_month, " +
                "YEAR(inspection.inspection_date) AS inspection_year, " +
                "inspector.firstname AS firstname " +
                "FROM inspection " +
                "INNER JOIN inspector on inspector.inspector_id = inspection.inspector_id " +
                "WHERE inspector.firstname = ? " +
                "GROUP BY MONTH(inspection.inspection_date)";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            pstmt.setString(1, firstName);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ReportAllInspectionsByMonths report = new ReportAllInspectionsByMonths();
                report.setMonth(resultSet.getString("inspection_month"));
                report.setYear(resultSet.getString("inspection_year"));
                report.setInspectionCount(resultSet.getInt("inspection_count"));
                report.setFirstName(resultSet.getString("firstname"));
                list.add(report);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public List<ReportAllInspectionsByMonths> inspectionsByMonths(String month) {
        List<ReportAllInspectionsByMonths> list = new ArrayList<>();
        String query = "SELECT COUNT(inspection.inspection_id) AS inspection_count, " +
                "MONTHNAME(inspection.inspection_date) AS inspection_month, " +
                "YEAR(inspection.inspection_date) AS inspection_year, " +
                "inspector.firstname AS firstname " +
                "FROM inspection " +
                "INNER JOIN inspector on inspector.inspector_id = inspection.inspector_id " +
                "WHERE MONTHNAME(inspection.inspection_date) = ? " +
                "GROUP BY inspector.firstname AND MONTH(inspection.inspection_date)";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            pstmt.setString(1, month);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ReportAllInspectionsByMonths report = new ReportAllInspectionsByMonths();
                report.setMonth(resultSet.getString("inspection_month"));
                report.setYear(resultSet.getString("inspection_year"));
                report.setInspectionCount(resultSet.getInt("inspection_count"));
                report.setFirstName(resultSet.getString("firstname"));
                list.add(report);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public Integer countReservationsNotProcessed() {
        String query = "SELECT COUNT(processed_by) as total FROM reservation WHERE processed_by = NULL";
        int count = 0;
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count;
    }

    public List<ReportInspectionsByType> countInspectionsByType() {
        List<ReportInspectionsByType> list = new ArrayList<>();
        String query = "SELECT COUNT(inspection.inspection_id) as total,  " +
                "inspection_type.type_name AS inspection_type " +
                "FROM inspection " +
                "INNER JOIN inspection_type " +
                "ON inspection_type.inspection_type_id = inspection.inspection_type_id " +
                "GROUP BY inspection_type.type_name";
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ReportInspectionsByType report = new ReportInspectionsByType();
                report.setCount(resultSet.getInt("total"));
                report.setInspectionType(resultSet.getString("inspection_type"));
                list.add(report);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
