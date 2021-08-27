package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

//    public void updateStockProduct(int customerId, int newStatus) {
//        connection.getTransaction().begin();
//        int result = connection.createQuery("UPDATE Customer p SET p.accountStatus = :newValue WHERE p.id = :id")
//                .setParameter("newValue", newStatus)
//                .setParameter("id", customerId)
//                .executeUpdate();
//        connection.getTransaction().commit();
//        if (result > 0) {
//            System.out.println("\nCustomer status updated with success.");
//        }
//    }
//
//    public Customer findCustomerById(int id) {
//        return connection.find(Customer.class, id);
//    }
//
//    //READ
//    //https://www.baeldung.com/hibernate-aggregate-functions
//    public long getTotalCustomerActives() {
//        return (long) connection.createQuery("SELECT count(c) from Customer c WHERE c.accountStatus = 1")
//                .getSingleResult();
//    }
//
//    public List<Object[]> getTotalCustomerActivesAndNotActives() {
//        String sql = "SELECT c.accountStatus, count(c) from Customer c GROUP BY c.accountStatus";
//        return connection.createQuery(sql).getResultList();
//    }
//
//    public void updatePhoneNumberByCustomerId(int customerId, String phoneNumber) {
//        connection.getTransaction().begin();
//        int result = connection.createQuery("UPDATE Customer c SET c.phoneNumber = :newValue WHERE c.id = :id")
//                .setParameter("newValue", phoneNumber)
//                .setParameter("id", customerId)
//                .executeUpdate();
//        connection.getTransaction().commit();
//        if (result > 0) {
//            System.out.println("\n Customer phone number successfully updated!");
//        }
//
//    }
}
