package com.KOSTA.model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import src.model.DeptDAO;
import src.model.DeptVO;

/**
 * Servlet implementation class DeptListServelet
 */
@WebServlet("/deptlist")
public class DeptListServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDAO dao = new DeptDAO();
		
		try {
			List<DeptVO> dlist = dao.selectAll();
			request.setAttribute("deptall", dlist);
			//서블릿이 받은 요청을 jsp에 넘기기
			RequestDispatcher rd = request.getRequestDispatcher("dept_retrieve.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
