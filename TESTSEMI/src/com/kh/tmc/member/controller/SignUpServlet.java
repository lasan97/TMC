package com.kh.tmc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.member.model.service.MemberService;
import com.kh.tmc.member.model.vo.Member;

/**
 * Servlet implementation class SingUp
 */
@WebServlet("/signup.mo")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
 
		String userId = request.getParameter("userId") + "@" + request.getParameter("userEmail");
		String userPwd = request.getParameter("userPwd1");
		String userName = request.getParameter("userName");
		String userPhone = request.getParameter("userPhone");
		String userAddress = request.getParameter("userAddress");   
		
		Member m = new Member(userId, userPwd, userName, userPhone, userAddress);		
		
		int result = new MemberService().signUp(m);
		
		
		if(result>0) {
			request.getRequestDispatcher("index.jsp").forward(request, response);;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
