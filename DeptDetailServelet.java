package com.KOSTA.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.model.DeptDAO;
import src.model.DeptVO;

/**
 * Servlet implementation class DeptDetailServelet
 */
@WebServlet("/deptDetail")
public class DeptDetailServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptDetailServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_deptid = request.getParameter("deptid");
		int i_deptid = Integer.parseInt(s_deptid);
		DeptDAO dao = new DeptDAO();
		DeptVO dept = dao.selectById(i_deptid);
		request.setAttribute("dept", dept);
		RequestDispatcher rd = request.getRequestDispatcher("deptDetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
