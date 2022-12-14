package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.sql.*;


public class DbConnectionTest {

    @Test
    public void testDbConnection() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id,group_name from group_list");
            Groups groups = new Groups();
            while (rs.next()) {
                groups.add(new GroupData().withId(rs.getInt("group_id")).withName(rs.getString("group_name")));
                rs.close();
                st.close();
                conn.close();
                System.out.println(groups);
            }

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
    @Test
    public void testDbConnectionUsers() {
        Connection conn = null;
        try {

            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook?user=root&password=");

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select group_id,group_name from group_list");
            //Users users = new Users();
             System.out.println(rs);

//            while (rs.next()) {
//                users.add(new UserData().withId(rs.getInt("id")));
                rs.close();
                st.close();
                conn.close();
//                System.out.println(users);
//            }
        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }


}
