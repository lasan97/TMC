package com.kh.tmc.adoptWant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.adoptWant.model.service.AdoptWantService;
import com.kh.tmc.adoptWant.model.vo.AdoptWant;
import com.kh.tmc.adoptWant.model.vo.PageInfo;

/**
 * Servlet implementation class ListAdoptWant
 */
@WebServlet("/listAdoptW.ado")
public class AdoptWantList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptWantList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 게시판 페이징 처리
				// 페이징 처리
				// 대용량의 데이터를 한 번에 처리하지 않고
				// 특정 개수만큼 끊어서 표현하는 기술
				
				ArrayList<AdoptWant> list = new ArrayList<>();
				AdoptWantService aws = new AdoptWantService();
				
				// 페이징 처리에 필요한 변수들
				// 한번에 표시할 페이지들 중 가장 앞의 페이지
				// 1,2,3,4,5 -> 1 // 6,7,8,9,10 -->6
				int startPage;
				
				// 한번에 표시할 페이지들 중 가장 뒤의 페이지
				int endPage;
				
				// 전체 페이지의 가장 마지막 페이지
				int maxPage;
				
				// 사용자가 위치한 현제 페이지
				int currentPage;
				
				// 총 페이지 수(한 페에지 당
				int limit;
				
				// 처음 접속 시 페이지는 1 페이지부터 시작한다
				currentPage = 1;
				
				// 글 갯수 및 페이지 수 10개 제한하기
				limit = 10;
				
				if(request.getParameter("currentPage") != null) {
					currentPage = Integer.parseInt(request.getParameter("currentPage"));
				}
				
				// 페이징 처리
				int listCount = aws.getListCount();
				
				System.out.println("총 페이지 수 : " + listCount);
				
				// 250개
				// 25
				// 만약 전체 게시글 수가 13개이면
				// 페이지 1,2 나와야한다
				// ** 짜투리 게시물로 하나의 페이지로 처리해야한다
				
				// 13 --> 1.3 --> 2.2
				// 11 --> 1.1 --> 2
				// 19 --> 1.9 --> 2.8 --> 2
				
				maxPage = (int)((double)listCount/limit +  0.9);	
				
				// 시작 페이지와 마지막 페에지 계산
				// 1~10 : 7, 7/10 -->0.7 --> 1.6 --> 1
				startPage = ((int)((double)currentPage / limit+0.9) -1)* limit + 1;
				
				// 마지막 페이지
				// 1~10 : 10
				// 11~20 : 20
				endPage = startPage + limit -1;
				
				// 만약 마지막 페이지보다 현재 게시글이 끝나는 페이지가 적다면
				if(endPage>maxPage) {
					endPage = maxPage;
				}
				
				list = aws.selectList(currentPage,limit);
				
				String page= "";;
				if(list != null) {
					page = "views/adoptWant/adoptWant.jsp";
					request.setAttribute("list", list);
					
					PageInfo pi = new PageInfo(currentPage, listCount, limit,maxPage,startPage,endPage);
					request.setAttribute("pi", pi);
				}else {
					page = "views/common/errorPage.jsp";
					request.setAttribute("msg", "게시글 목록 조회 실패!");
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
