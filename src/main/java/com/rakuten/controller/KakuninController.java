package com.rakuten.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rakuten.dao.UserDao;
import com.rakuten.model.User;

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
		String userId  = (String) session.getAttribute("userID");
		String passWord  = (String) session.getAttribute("passWord");
		String sei  = (String) session.getAttribute("sei");
		String mei  = (String) session.getAttribute("mei");
		String seiKata  = (String) session.getAttribute("seiKata");
		String meiKata  = (String) session.getAttribute("meiKata");
        
		User user = new User(email, userId, passWord, sei, mei, seiKata, meiKata);
		UserDao userDAO = new UserDao();
		try {
			userDAO.insertUser(user);
		} catch (SQLException e) {
			 e.printStackTrace();
		}
         
 		request.getRequestDispatcher("kanryou.jsp").forward(request, response);
	}
}
