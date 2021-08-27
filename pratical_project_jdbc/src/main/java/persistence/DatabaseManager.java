package persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import util.DBUtil;

public class DatabaseManager {

    private Connection connection;

    public DatabaseManager() {
        DBUtil.createDatabase();
        connection = DBUtil.getDBConnection();
    }

    /*private void createTableCustomerExample() {
        String sql = "CREATE TABLE IF NOT EXISTS customer (\n"
                + "	customer_id int NOT NULL AUTO_INCREMENT,\n"
                        + "	account_status int DEFAULT NULL,\n"
                        + "	email varchar(255) DEFAULT NULL,\n"
                        + "	first_name varchar(255) DEFAULT NULL,\n"
                        + "	last_name varchar(255) DEFAULT NULL,\n"
                        + "	middle_name varchar(255) DEFAULT NULL,\n"
                        + "	password varchar(255) DEFAULT NULL,\n"
                        + "	phone_number varchar(255) DEFAULT NULL,\n"
                        + "	profile_image varchar(255) DEFAULT NULL,\n"
                        + "	username varchar(255) DEFAULT NULL,\n"
                        + "	 PRIMARY KEY (customer_id)\n"
                + ");";
        
        try {
             Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/

    private void createTableCompany() {
        String sql = "CREATE TABLE IF NOT EXISTS company (\n"
                + "	company_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	company_name varchar(45) DEFAULT NULL,\n"
                + "	reg_code int DEFAULT NULL\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableVehicleCategories() {
        String sql = "CREATE TABLE IF NOT EXISTS veh_categories (\n"
                + "	veh_category_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	veh_category varchar(45) DEFAULT NULL\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableTestingStation() {
        String sql = "CREATE TABLE IF NOT EXISTS testing_station (\n"
                + "	station_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	veh_category_id int DEFAULT NULL,\n"
                + "	address varchar(45) DEFAULT NULL,\n"
                + " company_id int DEFAULT NULL,\n"
                + " Constraint FOREIGN KEY (veh_category_id) REFERENCES veh_categories(veh_category_id),\n"
                + " Constraint FOREIGN KEY (company_id) REFERENCES company(company_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableInspector() {
        String sql = "CREATE TABLE IF NOT EXISTS inspector (\n"
                + "	inspector_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	firstname varchar(30) DEFAULT NULL,\n"
                + "	lastname varchar(30) DEFAULT NULL,\n"
                + " licence_expiry DATE DEFAULT NULL,\n"
                + " veh_category_id int DEFAULT NULL,\n"
                + " Constraint FOREIGN KEY (veh_category_id) REFERENCES veh_categories(veh_category_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableTestingStationHasInspector() {
        String sql = "CREATE TABLE IF NOT EXISTS testingstation_has_inspector (\n"
                + "	station_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	inspector_id int DEFAULT NULL,\n"
                + " Constraint FOREIGN KEY (station_id) REFERENCES testing_station(station_id),\n"
                + " Constraint FOREIGN KEY (inspector_id) REFERENCES inspector(inspector_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableInspectionType() {
        String sql = "CREATE TABLE IF NOT EXISTS inspection_type (\n"
                + "	inspection_type_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	type_name varchar(45) DEFAULT NULL\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableCustomer() {
        String sql = "CREATE TABLE IF NOT EXISTS customer (\n"
                + "	customer_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	first_name varchar(45) DEFAULT NULL,\n"
                + " last_name varchar(45) DEFAULT NULL,\n"
                + " phone varchar(45) DEFAULT NULL\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableVehicle() {
        String sql = "CREATE TABLE IF NOT EXISTS vehicle (\n"
                + "	vehicle_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	licence_plate varchar(10) DEFAULT NULL,\n"
                + " manufacturer varchar(45) DEFAULT NULL,\n"
                + " model varchar(45) DEFAULT NULL,\n"
                + " fuel_type varchar(30) DEFAULT NULL,\n"
                + " customer_id int DEFAULT NULL,\n"
                + " veh_category_id int DEFAULT NULL,\n"
                + " Constraint FOREIGN KEY (customer_id) REFERENCES customer(customer_id),\n"
                + " Constraint FOREIGN KEY (veh_category_id) REFERENCES veh_categories(veh_category_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableUser() {
        String sql = "CREATE TABLE IF NOT EXISTS user (\n"
                + "	user_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	name varchar(45) DEFAULT NULL,\n"
                + " email varchar(45) DEFAULT NULL,\n"
                + " username varchar(30) DEFAULT NULL,\n"
                + " password varchar(30) DEFAULT NULL\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableReservation() {
        String sql = "CREATE TABLE IF NOT EXISTS reservation (\n"
                + "	reservation_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	reservation datetime DEFAULT NULL,\n"
                + " processed_by int DEFAULT NULL,\n"
                + " customer_id int DEFAULT NULL,\n"
                + " vehicle_id int DEFAULT NULL\n,"
                + " Constraint FOREIGN KEY (processed_by) REFERENCES user(user_id),\n"
                + " Constraint FOREIGN KEY (customer_id) REFERENCES customer(customer_id),\n"
                + " Constraint FOREIGN KEY (vehicle_id) REFERENCES vehicle(vehicle_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTableInspection() {
        String sql = "CREATE TABLE IF NOT EXISTS inspection (\n"
                + "	inspection_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	inspector_id int DEFAULT NULL,\n"
                + " inspection_type_id int DEFAULT NULL,\n"
                + " reservation_id int DEFAULT NULL,\n"
                + " vehicle_id int DEFAULT NULL\n,"
                + " emissions double DEFAULT NULL\n,"
                + " brakes double DEFAULT NULL\n,"
                + " faults varchar(100) DEFAULT NULL\n,"
                + " valid_until DATE DEFAULT NULL\n,"
                + " Constraint FOREIGN KEY (inspector_id) REFERENCES inspector(inspector_id),\n"
                + " Constraint FOREIGN KEY (inspection_type_id) REFERENCES inspection_type(inspection_type_id),\n"
                + " Constraint FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id),\n"
                + " Constraint FOREIGN KEY (vehicle_id) REFERENCES reservation(vehicle_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void createTablePayment() {
        String sql = "CREATE TABLE IF NOT EXISTS payment (\n"
                + "	payment_id int PRIMARY KEY NOT NULL AUTO_INCREMENT,\n"
                + "	amount double DEFAULT NULL,\n"
                + " payment_date DATE DEFAULT NULL\n,"
                + " reservation_id int DEFAULT NULL,\n"
                + " processed_by int DEFAULT NULL\n,"
                + " Constraint FOREIGN KEY (reservation_id) REFERENCES reservation(reservation_id),\n"
                + " Constraint FOREIGN KEY (processed_by) REFERENCES user(user_id)\n"
                + ");";

        try {
            Statement stmt = connection.createStatement();
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void initTables() {
        createTablePayment();
    }
}
