package com.rakuten.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rakuten.model.User;

import utilities.JDBCConn;

public class UserDao {
	public void insertUser(User user) throws SQLException {

		JDBCConn conn = new JDBCConn();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp timestamp = new java.sql.Timestamp(utilDate.getTime());
		try {
			conn.getDbcom();
			String sql = ("insert into users_rakutensystem(email,user_id,password,sei,mei,sei_kata,mei_kata,create_date) values (?,?,?,?,?,?,?,?);");
			PreparedStatement pstmt = conn.createPreparedStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getUserId());
			pstmt.setString(3, user.getPassWord());
			pstmt.setString(4, user.getSei());
			pstmt.setString(5, user.getMei());
			pstmt.setString(6, user.getSeiKata());
			pstmt.setString(7, user.getMeiKata());
			pstmt.setTimestamp(8, timestamp);

			conn.executeUpdate(pstmt);

			conn.closePreparedStatement();
			conn.closeDbcom();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public boolean isExist(User user) throws SQLException {
		JDBCConn conn = new JDBCConn();
		try {
			conn.getDbcom();
			String sql = ("select * from users_RakutenSystem where email = ?;");
			PreparedStatement pstmt = conn.createPreparedStatement(sql);
			pstmt.setString(1, user.getEmail());

			ResultSet resultSet = conn.executeQuery(pstmt);
			while (resultSet.next()) {
				return true;
			}
			conn.closePreparedStatement();
			conn.closeDbcom();
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}

	public boolean isEmail(User user) {
		String emailRegex = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

}