package com.kh.tmc.adoptWant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.adoptComment.model.service.AdoptCommentService;
import com.kh.tmc.adoptWant.model.service.AdoptWantService;
import com.kh.tmc.adoptWant.model.vo.AdoptWant;

/**
 * Servlet implementation class AdoptWantSelectOne
 */
@WebServlet("/soAdoptW.ado")
public class AdoptWantSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptWantSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int wiBno = Integer.parseInt(request.getParameter("wiBno"));
		
		AdoptWant aw = new AdoptWantService().selectOne(wiBno);
//		ArrayList<AdoptWant> commentlist = 
//				new AdoptCommentService().selectList(wiBno);
		
		String page = "";
		if(aw != null) {
			page = "views/adoptWant/adoptWantDetail.jsp";
			request.setAttribute("aw", aw);  //목록
			//request.setAttribute("clist", commentlist); // 댓글
			
		}else {
			page = "views/common/errorPage.jsp";
			request.setAttribute("msg", "게시글 상세보기 실패!");
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
