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
 * Servlet implementation class AdoptWantUpdateView
 */
@WebServlet("/uAdoptWViwe.ado")
public class AdoptWantUpdateView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptWantUpdateView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wiBno = Integer.parseInt(request.getParameter("wiBno"));
		
		AdoptWant aw = new AdoptWantService().updateView(wiBno);
		
		String page = "";
		
		if(aw != null) {
			page = "views/adoptWant/adoptWantUpdate.jsp";
			request.setAttribute("aw", aw);
		}else {
			page = "views/common/errorPage.jsp";
					request.setAttribute("msg", "게시글 글 수정 페이지 연결 실패 !");
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
