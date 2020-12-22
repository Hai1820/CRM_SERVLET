package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.myclass.constants.SessionContants;
import com.myclass.constants.UrlConstants;
import com.myclass.dto.UserDto;
import com.myclass.service.AuthService;

@WebServlet(urlPatterns = { UrlConstants.URL_LOGIN, UrlConstants.URL_LOGOUT })
public class LoginController extends HttpServlet {

	/**
	 * created on 12/12/2020 by Hoang Nguyen
	 * 
	 */
	private AuthService authService = null;

	public LoginController() {
		authService = new AuthService();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();

		switch (action) {
		case UrlConstants.URL_LOGIN:
			req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_LOGOUT:
			HttpSession session = req.getSession();
			if (session.getAttribute(UrlConstants.URL_LOGIN) != null) {
				session.removeAttribute(UrlConstants.URL_LOGIN);
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_LOGIN);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");

		UserDto userDto = authService.checkLogin(email, pass);
		if (userDto == null) {
			req.setAttribute("message", "Email hoặc mật khẩu không đúng!");
			req.getRequestDispatcher("/WEB-INF/views/auth/login.jsp").forward(req, resp);
			return;
		}

		HttpSession session = req.getSession();
		session.setAttribute(SessionContants.USER_LOGIN, userDto);
		resp.sendRedirect(req.getContextPath() + UrlConstants.URL_HOME);

	}
}
