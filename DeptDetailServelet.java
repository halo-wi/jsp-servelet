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
 * Servlet implementation class DeptDetailServelet
 */
@WebServlet("/dept/deptDetail")
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
		//상세보기: 조회목적
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
		//수정목적
		request.setCharacterEncoding("utf-8");
		int deptid = convertInt( request.getParameter("department_id"));
		String dname = request.getParameter("department_name");
		int mid = convertInt(request.getParameter("manager_id"));
		int loid = convertInt(request.getParameter("location_id"));
		
		DeptVO dept = new DeptVO(deptid,dname,mid,loid);
		DeptDAO dao = new DeptDAO();
		int result = dao.updateDept(dept);
		
		request.setAttribute("message",result);
		RequestDispatcher rd = request.getRequestDispatcher("resultinfo.jsp");
		rd.forward(request, response);
	
	}
	
	private int convertInt(String p) {
		if(p==null) return 0;
		return Integer.parseInt(p);
	}
	

}
