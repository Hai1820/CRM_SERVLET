package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constants.UrlConstants;
import com.myclass.entity.Task;
import com.myclass.repository.HomeRepository;

@WebServlet(name = "/home", urlPatterns = { UrlConstants.URL_HOME })
public class HomeController extends HttpServlet {

	/**
	 * created on 8/12/2020
	 */
	private HomeRepository homeRepository;

	@Override
	public void init() throws ServletException {
		homeRepository = new HomeRepository();
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConstants.URL_HOME:
//			tính số task theo trạng thái 
			List<Task> counts = homeRepository.getCount();
			req.setAttribute("counts", counts);
//			tổng có task 
			Task allTasks = homeRepository.getAllCount();
			req.setAttribute("allTasks", allTasks);
			req.getRequestDispatcher("/WEB-INF/views/home/index.jsp").forward(req, resp);
		}
	}
}
