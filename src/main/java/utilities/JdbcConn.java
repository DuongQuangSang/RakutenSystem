package utilities;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConn {
	Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";
	public Connection getDbcom() throws ClassNotFoundException {
        if (conn == null) {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(url, user, password);
                stmt = (Statement) conn.createStatement();
            } catch (SQLException ex) {
            }
        }
        return conn;
    }
}
