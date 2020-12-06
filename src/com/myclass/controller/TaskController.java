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
import com.myclass.repository.TaskRepository;

@WebServlet(name = "task", urlPatterns = { UrlConstants.URL_TASK })
public class TaskController extends HttpServlet {

	/**
	 * created on 4/12/2020 by Nguyen Hoang Hai
	 */
	private static final long serialVersionUID = 1L;
	private TaskRepository taskRepository;

	@Override
	public void init() throws ServletException {
		taskRepository = new TaskRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConstants.URL_TASK:
			List<Task> tasks = taskRepository.getAllTask();
			req.setAttribute("task", tasks);
			req.getRequestDispatcher("/WEB-INF/views/task/task.jsp").forward(req, resp);
		}
	}
}
