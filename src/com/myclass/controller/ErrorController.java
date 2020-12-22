package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constants.UrlConstants;

@WebServlet(name = "error", urlPatterns = UrlConstants.URL_ERROR)
public class ErrorController extends HttpServlet {
	/**
	 * created on 12/12/2020 by Nguyen Hoang Hai
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConstants.URL_ERROR:
			req.getRequestDispatcher("/WEB-INF/views/error/404.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}
}
