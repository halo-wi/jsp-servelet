package com.KOSTA.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KOSTA.model.DeptDAO;
import com.KOSTA.model.DeptVO;
import com.KOSTA.model.EmpDAO;
import com.KOSTA.model.EmpVO;

/**
 * Servlet implementation class DeptListServelet
 */
@WebServlet("/emo/emplist")
public class EmpListServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDAO dao = new EmpDAO();
		
			List<EmpVO> elist = null;
			try {
				elist = dao.selectAll();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("empall", elist);
			//서블릿이 받은 요청을 jsp에 넘기기
			RequestDispatcher rd = request.getRequestDispatcher("emp_retrieve.jsp");
			rd.forward(request, response);
	}

}
