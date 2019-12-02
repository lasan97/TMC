package com.kh.tmc.training.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.json.simple.JSONObject;

import com.kh.tmc.common.MyRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/rstest1.do")
public class ContentImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		if(!ServletFileUpload.isMultipartContent(request)) {
			// 만약 multipart/form-data로 보내지 않았으면 에러 발생!!!!!!!!!
			request.setAttribute("msg", "multipart/form-data형식으로 전송해야 합니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

		// 1. 전송할 파일의 크기를 설정
		int maxSize = 1024 * 1024 * 10;
		
		// 2. 저장할 경로 설정하기
		String root
		= request.getServletContext().getRealPath("/resourse");
		
		String savePath = root+"/trainingImg";
		
		MultipartRequest mrequest
		= new MultipartRequest(request, savePath,maxSize,"UTF-8",new MyRenamePolicy());
	
		// 다중 파일 업로드 시에 처리하는 방법
		// 다중 파일 업로드 시 컬렉션 객체를 활용하여 파일을 별도로 관리한다.
		JSONObject result = new JSONObject();
		
		// 변경된 파일명
		ArrayList<String> saveFiles = new ArrayList<String>();
		
		// 원본 파일 명
		ArrayList<String> originFiles = new ArrayList<String>();
		
		   Enumeration<String> files =
				   mrequest.getFileNames();
		   
		   while(files.hasMoreElements()) {
			   String name = files.nextElement();
			   System.out.println("name : "+name);
			   System.out.println(mrequest.getFilesystemName(name));
			   result.put("imgName", mrequest.getFilesystemName(name));
			   
		   }
		   
		   
			response.setContentType("application/json");
			response.getWriter().print(result.toJSONString());
	
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
