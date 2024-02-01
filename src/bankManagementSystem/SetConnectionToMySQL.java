package bankManagementSystem;

import java.sql.*;

public class SetConnectionToMySQL {
    Connection c;
    Statement s;
    public SetConnectionToMySQL() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "123456");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
