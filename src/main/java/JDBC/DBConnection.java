package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static String url = "jdbc:mysql://localhost:3306/VBoxData";
    public static String uid = "root";
    public static String pwd = "root";
    public static Connection getConnection() {
        Connection connection=null;
        try {
            connection= DriverManager.getConnection(url,uid,pwd);
            System.out.println("Kết nối thành công");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
