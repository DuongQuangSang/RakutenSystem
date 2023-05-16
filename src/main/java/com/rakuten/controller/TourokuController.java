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
		String selectedRadio = request.getParameter("check");

		User user = new User(email, userId, passWord, sei, mei, seiKata, meiKata);
		UserDao userDAO = new UserDao();

		// Email
		try {
			if (userDAO.isExist(user)) {
				request.setAttribute("isemailisexist", userDAO.isExist(user));
				request.setAttribute("isemailisexistshow", "show");
				request.setAttribute("isemailisexistmess", "保存している。");
				hasError = true;
			}
			if (email.isEmpty()) {
				request.setAttribute("isemilempty", email.isEmpty());
				request.setAttribute("isemilemptyshow", "show");
				request.setAttribute("isemilemptymess", "メールアドレスを入力して下さい。");
				hasError = true;
			} else if (!userDAO.isEmail(user)) {
				request.setAttribute("isemail", !userDAO.isEmail(user));
				request.setAttribute("isemailshow", "show");
				request.setAttribute("isemailmess", "入力されたメールアドレスの形式はご登録いただけません。");
				hasError = true;
			} else {
				if (!email.equals(emailkakunin) || emailkakunin.isEmpty()) {
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

		// UserId
		if (selectedRadio != null) {
			if (selectedRadio.equals("on")) {
				userId = email.toString();
//				request.setAttribute("useridset", selectedRadio.equals("on"));
//				request.setAttribute("useridsetmess", "email");
			}
			if (selectedRadio.equals("off")) {
				if (userId.isEmpty()) {
					request.setAttribute("useridisempty", userId.isEmpty());
					request.setAttribute("useridisemptyshow", "show");
					request.setAttribute("useridisemptymess", "ユーザIDを入力して下さい。");
					hasError = true;
				} else {
					if (!userDAO.isUserId(user)) {
						request.setAttribute("useridnotuser", !userDAO.isUserId(user));
						request.setAttribute("useridnotusershow", "show");
						request.setAttribute("useridnotusermess", "入力されたユーザIDの形式はご登録いただけません。");
						hasError = true;
					}
				}
			}

			// PassWord
			if (passWord.isEmpty()) {
				request.setAttribute("passwordempty", passWord.isEmpty());
				request.setAttribute("passwordemptyshow", "show");
				request.setAttribute("passwordemptymess", "パスワードを入力して下さい。");
				hasError = true;
			} else {
				if (!userDAO.isPassWord(user)) {
					request.setAttribute("notpassword", !userDAO.isPassWord(user));
					request.setAttribute("notpasswordshow", "show");
					request.setAttribute("notpasswordmess", "入力されたパスワードの形式はご登録いただけません。");
					hasError = true;
				}
			}

			// Sei
			if (sei.isEmpty()) {
				request.setAttribute("seiempty", sei.isEmpty());
				request.setAttribute("seiemptyshow", "show");
				request.setAttribute("seiemptymess", "（姓）を入力して下さい。");
				hasError = true;
			}

			// Mei
			if (mei.isEmpty()) {
				request.setAttribute("meiempty", mei.isEmpty());
				request.setAttribute("meiemptyshow", "show");
				request.setAttribute("meiemptymess", "（名）を入力して下さい。");
				hasError = true;
			}

			//SeiKata
			if (seiKata.isEmpty()) {
				request.setAttribute("seikataempty", seiKata.isEmpty());
				request.setAttribute("seikataemptyshow", "show");
				request.setAttribute("seikataemptymess", "（姓）を入力して下さい。");
				hasError = true;
			} else {
				if (!userDAO.isSeiKata(user)) {
					request.setAttribute("notseikata", !userDAO.isSeiKata(user));
					request.setAttribute("notseikatashow", "show");
					request.setAttribute("notseikatamess", "全角カタカナのみ入力して下さい。");
					hasError = true;
				}
			}

			//MeiKata
			if (meiKata.isEmpty()) {
				request.setAttribute("meikataempty", meiKata.isEmpty());
				request.setAttribute("meikataemptyshow", "show");
				request.setAttribute("meikataemptymess", "（名）を入力して下さい。");
				hasError = true;
			} else {
				if (!userDAO.isMeiKata(user)) {
					request.setAttribute("notmeikata", !userDAO.isMeiKata(user));
					request.setAttribute("notmeikatashow", "show");
					request.setAttribute("notmeikatamess", "全角カタカナのみ入力して下さい。");
					hasError = true;
				}
			}

			// Not Error
			if (hasError) {
				request.setAttribute("email", email);
				request.setAttribute("emailkakunin", emailkakunin);
//				request.setAttribute("userId", userId);
				request.setAttribute("passWord", passWord);
				request.setAttribute("sei", sei);
				request.setAttribute("mei", mei);
				request.setAttribute("seiKata", seiKata);
				request.setAttribute("meiKata", meiKata);
				request.setAttribute("selectedRadio", selectedRadio);
				if(selectedRadio.equals("on")) {
					request.setAttribute("userId", "");
				}

				request.getRequestDispatcher("touroku.jsp").forward(request, response);
			} else {
				request.setAttribute("email", email);
				request.setAttribute("userId", userId);
				request.setAttribute("passWord", passWord);
				request.setAttribute("sei", sei);
				request.setAttribute("mei", mei);
				request.setAttribute("seiKata", seiKata);
				request.setAttribute("meiKata", meiKata);
				request.getRequestDispatcher("kakunin.jsp").forward(request, response);
			}
		}
	}
}
