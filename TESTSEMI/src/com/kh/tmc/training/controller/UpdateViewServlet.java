package com.kh.tmc.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.training.model.service.TrainingService;
import com.kh.tmc.training.model.vo.TrainingBoard;

/**
 * Servlet implementation class UpdateTrainingServlet
 */
@WebServlet("/trUpdate.tr")
public class UpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));

		new TrainingService().countUper(bno);
		TrainingBoard tb = new TrainingService().selectThumbnailMap(bno);
		
		String page = "";
		if(tb != null && tb.getTrBno()==bno) {
			page = "views/Training/indexRsBoardUpdate.jsp";
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
