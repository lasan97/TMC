package com.kh.tmc.adoptWant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.adoptWant.model.service.AdoptWantService;
import com.kh.tmc.adoptWant.model.vo.AdoptWant;

/**
 * Servlet implementation class UpdateAdoptWant
 */
@WebServlet("/uAdoptW.ado")
public class AdoptWantUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptWantUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String wiTitle = request.getParameter("wiTitle");
		String wiContent = request.getParameter("wiContent");
		int wiBno = Integer.parseInt(request.getParameter("wiBno"));
		
		AdoptWant aw = new AdoptWant();
		aw.setWiBno(wiBno);
		aw.setWiContent(wiContent);
		aw.setWiTitle(wiTitle);
		
		System.out.println("uAdoptW.ado : " + aw);

		int result = new AdoptWantService().updateAdoptWant(aw);
		
		System.out.println(result);
		
		if(result > 0) {
			response.sendRedirect("soAdoptW.ado?wiBno=" + wiBno);
		}else {
			request.setAttribute("msg", "공지사항 수정 실패");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
