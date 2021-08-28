package persistence;

import model.Customer;
import model.CustomerExample;
import model.Inspector;
import util.DBUtil;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepositoryInspector {

    private Connection connection;
    PreparedStatement pstmt;

    public List<Inspector> listAllInspectors() {
        List<Inspector> inspectorList = new ArrayList<Inspector>();
        String sql = "SELECT * FROM inspector";
        try {
            PreparedStatement pstmt = DBUtil.getDBConnection().prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                Inspector inspector = new Inspector();
                inspector.setInspector_id(resultSet.getInt("inspector_id"));
                inspector.setFirstName(resultSet.getString("firstname"));
                inspector.setLastName(resultSet.getString("lastname"));
                inspector.setLicence_expiry(resultSet.getDate("licence_expiry"));
                inspector.setVeh_category_id(resultSet.getInt("veh_category_id"));
                inspectorList.add(inspector);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return inspectorList;
    }

    public Inspector findById(int inspector_id) {
        String query = "SELECT * FROM inspector WHERE inspector_id = ?";
        Inspector inspector = null;
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            pstmt.setInt(1, inspector_id);

            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                inspector = new Inspector();
                inspector.setInspector_id(resultSet.getInt("inspector_id"));
                inspector.setFirstName(resultSet.getString("firstname"));
                inspector.setLastName(resultSet.getString("lastname"));
                inspector.setLicence_expiry(resultSet.getDate("licence_expiry"));
                inspector.setVeh_category_id(resultSet.getInt("veh_category_id"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return inspector;
    }

    public void updateInspectorLicenceExpiry(String licence_expiry, int inspector_id) {
        String query = "UPDATE inspector SET licence_expiry = ? WHERE inspector_id = ?";
        Inspector inspector = null;
        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            pstmt.setString(1, licence_expiry);
            pstmt.setInt(2, inspector_id);
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Inspector's licence expiry date has been updated!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertNewFirstName(String firstName) {
        String query = "INSERT INTO inspector(firstName) VALUES(?)";

        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            pstmt.setString(1, firstName);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertNewLastName(String lastName) {
        String query = "INSERT INTO inspector(lastName) VALUES(?)";

        try {
            pstmt = DBUtil.getDBConnection().prepareStatement(query);
            pstmt.setString(1, lastName);
            pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void setInspectorsLicenceExpiry(String licenceExpiry) {
        String query = "INSERT INTO inspector(licence_expiry) VALUES(?)";
        try {
            if (licenceExpiry.trim().equals("")) {
                System.out.println("Date format not valid (needed yyyy-MM-DD):");
            } else {
                SimpleDateFormat sdfrmt = new SimpleDateFormat("yyyy-MM-dd");
                sdfrmt.setLenient(false);
                try {
                    Date date = sdfrmt.parse(licenceExpiry);
                    pstmt = DBUtil.getDBConnection().prepareStatement(query);
                    pstmt.setString(1, licenceExpiry);
                    pstmt.executeUpdate();
                    System.out.println("LicenceExpiry date successfully inserted!");
                } catch (ParseException e) {
                    System.out.println(licenceExpiry + " is Invalid Date format");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}


