package com.KOSTA.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalcServelet
 */
@WebServlet("/calculator")
public class CalcServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       int result = 0;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String su1 =request.getParameter("num1");
		String su2 =request.getParameter("num2");
		String op =request.getParameter("op");
		
		int num1 =Integer.parseInt(su1);
		int num2 =Integer.parseInt(su2);
		switch (op) {
		case "+": {
			result = num1+num2; break;
		}
		case "-": {
			result = num1+num2; break;
		}
		case "/": {
			result = num1+num2; break;
		}
		case "%": {
			result = num1+num2; break;
		}
		case "*": {
			result = num1+num2; break;
		}default:
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out =response.getWriter();
		out.print("<h1>result"+ result +"</h1>");
	}

}
