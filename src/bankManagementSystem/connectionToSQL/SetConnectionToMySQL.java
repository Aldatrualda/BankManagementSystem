package bankManagementSystem.connectionToSQL;

import java.sql.*;

public class SetConnectionToMySQL {
    Connection c;
    public Statement s;

    public SetConnectionToMySQL() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "123456");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println("Mistake is " + e);
        }
    }
}
