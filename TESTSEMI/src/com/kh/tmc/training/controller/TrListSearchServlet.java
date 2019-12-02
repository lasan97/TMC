package com.kh.tmc.training.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.training.model.service.TrainingService;
import com.kh.tmc.training.model.vo.TrainingBoard;
import com.kh.tmc.training.model.vo.TrainingPaging;

/**
 * Servlet implementation class TrListSearchServlet
 */
@WebServlet("/trSearch.tr")
public class TrListSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrListSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchName = request.getParameter("rsTitleSearch");	
		int sType = Integer.parseInt(request.getParameter("serachType"));
	
			ArrayList<TrainingBoard> list = null;

			TrainingService ts = new TrainingService();
			
			int startPage;
			int endPage;
			int maxPage;
			int currentPage;
			int limit;
 			currentPage = 1;
			limit = 9;
			
			if(request.getParameter("currentPage") != null) {
				currentPage = Integer.parseInt(request.getParameter("currentPage"));
			}
			
			int listCount= ts.getListCount();

			maxPage = (int)((double)listCount / limit + 0.9);
			
			startPage = ((int)((double)currentPage /limit + 0.9)-1)*limit +1;
			
			endPage = startPage+limit -1;
			
			if(endPage > maxPage) {
				endPage = maxPage;
			}
		
			
			list = ts.searchSelectList(currentPage,limit,searchName,sType);
		
			String page = "";
			if(list != null) {
				page = "views/Training/indexRsBoardList.jsp";
				request.setAttribute("list", list);
				
				TrainingPaging tp = new TrainingPaging(currentPage, listCount, limit, maxPage, startPage, endPage);
				request.setAttribute("pi", tp);
				
			}else {
				page = "views/common/errorPage.jsp";
				request.setAttribute("msg", "사진 게시판 목록 조회 실패!!");
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
