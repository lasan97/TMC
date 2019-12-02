package com.kh.tmc.training.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.training.model.service.TrainingService;
import com.kh.tmc.training.model.vo.TrainingBoard;

/**
 * Servlet implementation class SelectOneTrainingServlet
 */
@WebServlet("/trSelectOne.tr")
public class SelectOneTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOneTrainingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		System.out.println("test");
		// DB로 부터 전달받고자 하는 객체가 여러개일 경우
		// 1. 새로운 통합형 VO를 만들기
		//	 - 한번 만들어 두면 이용하기 편리하다.
		//	 - 객체 자체의 메모리 사용률이 올라가서 서비스 자체가 느려질수도 있다.
		// 2. Map 객체를 활용하여 여러 클래스(객체)를 key와 value로 묶어서 관리하는 방법
		//	 - 여러 객체의 정보가 하나의 map에 들어가기 때문에 관리하기 편리하다.
		//	  "thumb" -> Thumbnail / "att" -> Attachment
		// 	 - 각 객체의 내용이 변경될 경우 이를 직접 확인하기는 어렵다.
		new TrainingService().countUper(bno);
		TrainingBoard tb = new TrainingService().selectThumbnailMap(bno);
		
		String page = "";
		if(tb != null && tb.getTrBno()==bno) {
			page = "views/Training/indexRsBoardDetail.jsp";
			request.setAttribute("TrainingBoard", tb);

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
