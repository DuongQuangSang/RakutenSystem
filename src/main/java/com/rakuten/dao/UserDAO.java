package com.rakuten.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.rakuten.model.User;

import utilities.JDBC;

public class UserDAO {
	@SuppressWarnings("null")
	public void insertUser(User user) throws SQLException {
		JDBC jc = new JDBC();
		java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(utilDate.getTime());
        try {
            jc.getDbcom();
            jc.cud("insert into users_rakutensystem(email,user_id,password,sei,mei,sei_kata,mei_kata,create_date) values (?,?,?,?,?,?,?,?);");
            
            jc.closeDbcom();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
}