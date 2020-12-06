package com.myclass.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constants.UrlConstants;
import com.myclass.entity.Job;
import com.myclass.repository.JobRepository;

@WebServlet(name = "job", urlPatterns = { UrlConstants.URL_JOB, UrlConstants.URL_JOB_ADD })
public class JobController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JobRepository jobRepository;

	@Override
	public void init() throws ServletException {
		jobRepository = new JobRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case UrlConstants.URL_JOB:
			List<Job> jobs = jobRepository.getAllJob();
			req.setAttribute("jobs", jobs);
			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_JOB_ADD:
			req.getRequestDispatcher("/WEB-INF/views/groupwork/groupwork-add.jsp").forward(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case UrlConstants.URL_JOB_ADD:
			Job job = new Job();
			String name = req.getParameter("name");

			try {
				Date startDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("startDate"));
				job.setStartDate(startDate);
			} catch (Exception e) {
				e.getMessage();
			}
			try {
				Date endDate = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(req.getParameter("endDate"));
				job.setEndDate(endDate);
			} catch (Exception e) {
				e.getMessage();
			}
			job.setName(name);
			int result = jobRepository.save(job);
			if(result==-1) {
				System.out.println("them khong thanh cong");
			}
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_JOB);
			break;
		}
	}
}
