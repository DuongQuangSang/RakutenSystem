package com.rakuten;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TourokuServlet
 */
@WebServlet("/touroku")
public class TourokuServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String emailkakunin = request.getParameter("emailkakunin");
		String userID  = request.getParameter("userID");
		String passWord  = request.getParameter("passWord");
		String sei  = request.getParameter("sei");
		String mei  = request.getParameter("mei");
		String seiKata  = request.getParameter("seiKata");
		String meiKata  = request.getParameter("meiKata");
		
//		RequestDispatcher dispatcher = null;
		if(email.equals(emailkakunin)) {
			request.setAttribute("email", email);
			request.setAttribute("userID", userID);
			request.setAttribute("passWord", passWord);
			request.setAttribute("sei", sei);
			request.setAttribute("mei", mei);
			request.setAttribute("seiKata", seiKata);
			request.setAttribute("meiKata", meiKata);
			
			request.getRequestDispatcher("kakunin").forward(request, response);
		} else {
			request.getRequestDispatcher("touroku.jsp").forward(request, response);
//			dispatcher = request.getRequestDispatcher("");
		}
//		
	}
}
