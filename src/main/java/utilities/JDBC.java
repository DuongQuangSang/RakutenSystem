package utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {
	Connection conn = null;
    Statement stmt = null;
    ResultSet rset = null;

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
    String password = "postgres";
    
    // データベースに接続する
    public Connection getDbcom() throws ClassNotFoundException {
        if (conn == null) {
            Class.forName("org.postgresql.Driver");
            try {
                conn = DriverManager.getConnection(url, user, password);
                stmt = conn.createStatement();
            } catch (SQLException ex) {
            }
        }
        return conn;

    }
    
    // 検索、一覧に使う
    public ResultSet tt(String sql) throws SQLException {
        ResultSet resultSet;
        Statement query = null;
        try {
            query = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        resultSet = query.executeQuery(sql);

        return resultSet;
    }

    // 新規、変更、削除に使う
    public void cud(String sql) throws SQLException {

        stmt.executeUpdate(sql);

        System.out.println(sql);

    }
    
    // データベースに接続ことを切る
    public void closeDbcom() throws SQLException {
        if (rset != null) {
            rset.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

}
