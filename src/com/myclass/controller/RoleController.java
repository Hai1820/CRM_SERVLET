package com.myclass.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.myclass.constants.UrlConstants;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@WebServlet(name = "role", urlPatterns = { UrlConstants.URL_ROLE, UrlConstants.URL_ROLE_ADD, UrlConstants.URL_ROLE_EDIT,
		UrlConstants.URL_ROLE_DELETE })
public class RoleController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * created on 2/12/2020 by Nguyen Hoang Hai
	 */
	private RoleRepository roleRepository;

	@Override
	public void init() throws ServletException {
		roleRepository = new RoleRepository();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case UrlConstants.URL_ROLE:
			List<Role> roles = roleRepository.getAllRole();
			req.setAttribute("roles", roles);
			req.getRequestDispatcher("/WEB-INF/views/role/role-table.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_ROLE_ADD:
			req.getRequestDispatcher("/WEB-INF/views/role/role-add.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_ROLE_EDIT:
			int id = Integer.valueOf(req.getParameter("id"));
			Role role = roleRepository.getRoleById(id);
			req.setAttribute("role", role);
			req.getRequestDispatcher("/WEB-INF/views/role/role-edit.jsp").forward(req, resp);
			break;
		case UrlConstants.URL_ROLE_DELETE:
			int idDelelete = Integer.valueOf(req.getParameter("id"));
			roleRepository.deleteRoleById(idDelelete);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_ROLE);
			break;
		default:
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String name = req.getParameter("name");
		String description = req.getParameter("description");

		switch (path) {
		case UrlConstants.URL_ROLE_ADD:
			Role role = new Role();
			role.setDescription(description);
			role.setName(name);
			roleRepository.save(role);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_ROLE);
			break;
		case UrlConstants.URL_ROLE_EDIT:
			int idEdit = Integer.parseInt(req.getParameter("id"));
			Role roleToEdit = roleRepository.getRoleById(idEdit);
			roleToEdit.setId(idEdit);
			roleToEdit.setDescription(req.getParameter(description));
			roleToEdit.setName(req.getParameter(name));
			roleRepository.updateRoleById(idEdit, roleToEdit);
			resp.sendRedirect(req.getContextPath() + UrlConstants.URL_ROLE);
			break;
		default:
			break;
		}
	}
}
