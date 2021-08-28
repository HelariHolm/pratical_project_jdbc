package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Customer;
import model.CustomerExample;
import util.DBUtil;

public class RepositoryCustomer {

    private Connection connection;

    public RepositoryCustomer() {
        connection = DBUtil.getDBConnection();
    }

    public List<CustomerExample> listAllCustomers() {
        List<CustomerExample> customerExampleList = new ArrayList<CustomerExample>();
        String sql = "SELECT * FROM customer";
        try {
            PreparedStatement pstmt = DBUtil.getDBConnection().prepareStatement(sql);

            ResultSet resultSet = pstmt.executeQuery();

            while(resultSet.next()) {
                CustomerExample customerExample = new CustomerExample();
                customerExample.setAccountStatus(resultSet.getInt("account_status"));
                customerExample.setEmail(resultSet.getString("email"));
                customerExample.setFirstName(resultSet.getString("first_name"));
                customerExample.setLastName(resultSet.getString("last_name"));
                customerExample.setMiddleName(resultSet.getString("middle_name"));
                customerExample.setPassword(resultSet.getString("password"));
                customerExample.setPhoneNumber(resultSet.getString("phone_number"));
                customerExample.setProfileImage(resultSet.getString("profile_image"));
                customerExample.setUserName(resultSet.getString("username"));
                customerExample.setCustomerId(resultSet.getInt("customer_id"));
                customerExampleList.add(customerExample);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerExampleList;
    }

    public Customer findById(int customerId) {
        return null;
    }

    public long getTotalCustomerActives() {
        return 0;
    }

    public void updateCustomerPhoneNumber(int customerId, String phoneNumber) {

    }

    public List<Integer[]> getTotalCustomerActivesAndNotActives() {
        List<Integer[]> list = new ArrayList<>();

        return list;
    }
}
