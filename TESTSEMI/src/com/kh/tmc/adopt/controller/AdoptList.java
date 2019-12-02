package com.kh.tmc.adopt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.tmc.adopt.model.service.AdoptService;
import com.kh.tmc.adopt.model.vo.Adopt;

/**
 * Servlet implementation class ListAdopt
 */
@WebServlet("/listAdopt.ado")
public class AdoptList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Adopt> list = new ArrayList<Adopt>();
		AdoptService as = new AdoptService();
		
		list = as.selectAdopt();
		
		if(!list.equals(null)) {
			String path = "/rstest1/views/adopt/adoptSub.jsp";
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
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
