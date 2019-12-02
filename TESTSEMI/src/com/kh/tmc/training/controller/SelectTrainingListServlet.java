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
 * Servlet implementation class SelectTrainingListServlet
 */
@WebServlet("/trSelectList.tr")
public class SelectTrainingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectTrainingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<TrainingBoard> list = null;

		TrainingService ts = new TrainingService();
		
		
		// 페이징 처리에 필요한 변수들
		// 한번 에 표시할 페이지들 중 가장 앞의 페이지
		// 1,2,3,4,5, --> 1 // 6,7,8,9,10 --> 6
		int startPage;
		
		// 한번에 표시할 페이지들 중 가장 뒤의 페잊
		int endPage;
		
		// 전체 페이지의 가장 마지막 페이지
		int maxPage;
		
		// 사용자가 위치한 현재 페이지
		int currentPage;
		
		// 총 페이지 수(한 페이지 당 보여줄 게시글 수)
		int limit;
		
		// 처음 접속 시 페이지는 1페이지부터 시작한다.
		currentPage = 1;
		
		// 글 개수 및 페이지 수 9개 제한하기
		limit = 9;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 페이징 처리
		int listCount= ts.getListCount();
		
		// 총 250개
		// 25
		// 만약 전체 게시글 수가 13개 이면
		// 페이지 1, 2 나와야한다.
		// ** 짜투리 게시글도 하나의 페이지로 처리해야한다.
		
		// 13 --> 1.3 --> 2.2
		// 11 --> 1.1 --> 2
		// 19 --> 1.9 --> 2.8
		maxPage = (int)((double)listCount / limit + 0.9);
		
		// 시작 페이지와 마지막 페이지 계산
		// 1 ~ 10
		startPage = ((int)((double)currentPage /limit + 0.9)-1)*limit +1;
		
		// 마지막 페이지
		// 1~10 	:10
		// 11~20	:20
		endPage = startPage+limit -1;
		
		// 만약 마지막 페이지 보다 현재 게시글이 끝나느 페이지가 적다면
		if(endPage > maxPage) {
			endPage = maxPage;
		}
	
		
		list = ts.selectList(currentPage,limit);
	
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
