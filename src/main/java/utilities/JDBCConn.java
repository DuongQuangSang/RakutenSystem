package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConn {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rset = null;

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";

    // Kết nối tới cơ sở dữ liệu
    public Connection getDbcom() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, user, password);
        }
        return conn;
    }

    // Tạo Prepared Statement từ một câu lệnh SQL
    public PreparedStatement createPreparedStatement(String sql) throws SQLException {
        pstmt = conn.prepareStatement(sql);
        return pstmt;
    }

    // Thực thi truy vấn và trả về ResultSet
    public ResultSet executeQuery(PreparedStatement pstmt) throws SQLException {
        rset = pstmt.executeQuery();
        return rset;
    }

    // Thực thi truy vấn INSERT, UPDATE, DELETE
    public void executeUpdate(PreparedStatement pstmt) throws SQLException {
        pstmt.executeUpdate();
    }

    // Đóng Prepared Statement
    public void closePreparedStatement() throws SQLException {
        if (pstmt != null) {
            pstmt.close();
        }
    }

    // Đóng kết nối tới cơ sở dữ liệu
    public void closeDbcom() throws SQLException {
        if (rset != null) {
            rset.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }
}
