package com.kh.tmc.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.tmc.member.model.service.MemberService;
import com.kh.tmc.member.model.vo.Member;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signIn.mo")
public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignInServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");

//		Member m = new Member(userId, userPwd);
		Member m = new Member();
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		MemberService ms = new MemberService();
		
		m = ms.SignIn(m);
		
		if(m !=null) {
			
			HttpSession session = request.getSession();
			
			session.setAttribute("member", m);
			
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
