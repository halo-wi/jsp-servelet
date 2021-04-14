package com.KOSTA.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.KOSTA.model.DeptDAO;
import com.KOSTA.model.DeptVO;

/**
 * Servlet implementation class DeptInsertServelet
 */
@WebServlet("/dept/deptInsert")
public class DeptInsertServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptInsertServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("deptInsert.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아ㅣㅂ력목적
				request.setCharacterEncoding("utf-8");
				int deptid = convertInt( request.getParameter("department_id"));
				String dname = request.getParameter("department_name");
				int mid = convertInt(request.getParameter("manager_id"));
				int loid = convertInt(request.getParameter("location_id"));
				
				DeptVO dept = new DeptVO(deptid,dname,mid,loid);
				DeptDAO dao = new DeptDAO();
				int result = dao.insertDept(dept);
				
				request.setAttribute("message",result);
				RequestDispatcher rd = request.getRequestDispatcher("resultinfo.jsp");
				rd.forward(request, response);
	}
	
	private int convertInt(String p) {
		if(p==null) return 0;
		return Integer.parseInt(p);
	}

}
