package com.kh.tmc.training.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.training.model.service.TrainingService;

/**
 * Servlet implementation class DeleteTrainingServlet
 */
@WebServlet("/trDelete.tr")
public class DeleteTrainingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteTrainingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno =Integer.parseInt(request.getParameter("bno"));
		
		int result = new TrainingService().trDelete(bno);
		
		if(result > 0) {
			response.sendRedirect("views/Training/trSelectList.tr");
		}else {
			request.setAttribute("msg", "공지사항 삭제 실패!");
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
