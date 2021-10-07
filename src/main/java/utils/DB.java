package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DB {

    private final String driver="com.mysql.cj.jdbc.Driver";
    private final String url="jdbc:mysql://localhost:3306/blogproject";
    private  final String user="root";
    private final  String password="";
    public Connection conn = null;

    public DB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Success");
        }catch (Exception ex) {
            System.err.println("Connection Error : " + ex);
        }
    }


    public void close() {
        try {
            if ( conn != null ) {
                conn.close();
            }
        }catch (Exception ex) {
            System.err.println("Close Error : " + ex);
        }
    }


}
