package com.rakuten;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KakuninServlet
 */
@WebServlet("/kakunin")
public class KakuninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String email = request.getParameter("email");
//		String userID  = request.getParameter("userID");
//		String passWord  = request.getParameter("passWord");
//		String sei  = request.getParameter("sei");
//		String mei  = request.getParameter("mei");
//		String seiKata  = request.getParameter("seiKata");
//		String meiKata  = request.getParameter("meiKata");
		
		String email = (String) request.getAttribute("email");
		String userID  = (String) request.getAttribute("userID");
		String passWord  = (String) request.getAttribute("passWord");
		String sei  = (String) request.getAttribute("sei");
		String mei  = (String) request.getAttribute("mei");
		String seiKata  = (String) request.getAttribute("seiKata");
		String meiKata  = (String) request.getAttribute("meiKata");
		
//		RequestDispatcher dispatcher = null;
		Connection conn = null;
		
         try {
        	 try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
             conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
             PreparedStatement pst = conn.prepareStatement("insert into users_rakutensystem(email,user_id,password,name,name_kata) values (?,?,?,?,?);");
             pst.setString(1,email);
             pst.setString(2,userID);
             pst.setString(3,passWord);
             pst.setString(4,sei + mei);
             pst.setString(5,seiKata + meiKata);
             
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
	}
	
}
