package com.myclass.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constants.UrlConstants;

@WebServlet(urlPatterns = UrlConstants.URL_BLANK)
public class BlankController extends HttpServlet {

	/**
	 * created on 12/12/2020 By Nguyen Hoang Hai
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConstants.URL_BLANK:
			req.getRequestDispatcher("/WEB-INF/views/blank/blank.jsp").forward(req, resp);
			break;
		default:
			break;
		}
	}
}
