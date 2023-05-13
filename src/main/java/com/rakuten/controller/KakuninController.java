package com.rakuten.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class KakuninServlet
 */
@WebServlet("/kakunin")
public class KakuninController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("kakunin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("email");
		String userID  = (String) session.getAttribute("userID");
		String passWord  = (String) session.getAttribute("passWord");
		String sei  = (String) session.getAttribute("sei");
		String mei  = (String) session.getAttribute("mei");
		String seiKata  = (String) session.getAttribute("seiKata");
		String meiKata  = (String) session.getAttribute("meiKata");
        
//		User user = new User(email, userID, passWord, sei, mei, seiKata, meiKata);
//		UserDAO userDAO = new UserDAO();
//		try {
//			userDAO.insertUser(user);
//		} catch (SQLException e) {
//			 e.printStackTrace();
//		}
		
		Connection conn = null;
		java.util.Date utilDate = new java.util.Date();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(utilDate.getTime());
         try {
        	 try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
             conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement pst = conn.prepareStatement("insert into users_rakutensystem(email,user_id,password,sei,mei,sei_kata,mei_kata,create_date) values (?,?,?,?,?,?,?,?);");
             pst.setString(1,email);
             pst.setString(2,userID);
             pst.setString(3,passWord);
             pst.setString(4,sei);
             pst.setString(5,mei);
             pst.setString(6,seiKata);
             pst.setString(7,meiKata);
             pst.setTimestamp(8, timestamp);
             
             int rowCount = pst.executeUpdate();
//             dispatcher = request.getRequestDispatcher("touroku.jsp");
             if(rowCount > 0) {
            	 request.setAttribute("status", "success");
            	 
             } else {
            	 request.setAttribute("status", "failed");
             }
//             dispatcher.forward(request, response);
         } catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
         }
         
 		request.getRequestDispatcher("kanryou.jsp").forward(request, response);
//         response.sendRedirect("kanryou.jsp");
	}
}
