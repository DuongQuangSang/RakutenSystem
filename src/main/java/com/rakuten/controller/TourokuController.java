package com.rakuten.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rakuten.dao.UserDao;
import com.rakuten.model.User;

/**
 * Servlet implementation class TourokuServlet
 */
@WebServlet("/touroku")
public class TourokuController extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("touroku.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean hasError = false;
//		boolean idUserEmail = false;

		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String emailkakunin = request.getParameter("emailkakunin");
		String userId = request.getParameter("userId");
		String passWord = request.getParameter("passWord");
		String sei = request.getParameter("sei");
		String mei = request.getParameter("mei");
		String seiKata = request.getParameter("seiKata");
		String meiKata = request.getParameter("meiKata");
//		String selectedRadio = request.getParameter("check");

		User user = new User(email, userId, passWord, sei, mei, seiKata, meiKata);
		UserDao userDAO = new UserDao();

		try {
			if (userDAO.isExist(user)) {
				request.setAttribute("email", email);
				request.setAttribute("isemailisexist", userDAO.isExist(user));
				request.setAttribute("emailerror", "show");
				request.setAttribute("emailnull", "保存している。");
				hasError = true;
			}
			if (!userDAO.isEmail(user)) {
				request.setAttribute("email", email);
				request.setAttribute("isemailisexist", !userDAO.isEmail(user));
				request.setAttribute("emailerror", "show");
				request.setAttribute("emailnull", "入力されたメールアドレスの形式はご登録いただけません。");
				hasError = true;
			}
			if (email.equals(null)) {
				request.setAttribute("email", email);
				request.setAttribute("isemailisexist", email.equals(null));
				request.setAttribute("emailerror", "show");
				request.setAttribute("emailnull", "メールアドレスを入力して下さい。");
				hasError = true;
			} else {
				if (!email.equals(emailkakunin) || emailkakunin.equals(null)) {
					request.setAttribute("emailkakunin", emailkakunin);
					request.setAttribute("isemailsame", !email.equals(emailkakunin));
					request.setAttribute("emailkakuninerror", "show");
					request.setAttribute("emailequal", "メールアドレス（確認入力）とメールアドレスが一致しません。");
					hasError = true;
				}
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (hasError) {
			request.getRequestDispatcher("touroku.jsp").forward(request, response);
		} else {
			request.setAttribute("email", email);
			request.setAttribute("userID", userId);
			request.setAttribute("passWord", passWord);
			request.setAttribute("sei", sei);
			request.setAttribute("mei", mei);
			request.setAttribute("seiKata", seiKata);
			request.setAttribute("meiKata", meiKata);
			request.getRequestDispatcher("kakunin.jsp").forward(request, response);
		}
	}
}
