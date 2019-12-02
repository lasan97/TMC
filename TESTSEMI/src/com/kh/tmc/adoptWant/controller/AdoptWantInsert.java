package com.kh.tmc.adoptWant.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.tmc.adoptWant.model.service.AdoptWantService;
import com.kh.tmc.adoptWant.model.vo.AdoptWant;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertAdoptWant
 */
@WebServlet("/iAdoptW.ado")
public class AdoptWantInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdoptWantInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파일 처리용 서블릿
				// MuliopartRequest
				
				// 1. 전송할 최대 크기 설정하기
				// 10MB
				// (1MB -> 1024KB / 1KB -> 1024Byte)
				int maxSize = 1024 * 1024 * 10;
				
				// 2. multipart/from-data 형식으로 전송되었는지 확인
				if(!ServletFileUpload.isMultipartContent(request)) {
					// 만약 올바른 multipart/form-data로 전송되지 않았을 경우
					// 에러페이지로 즉시 이동 시킨다.
					request.setAttribute("msg", "multipart/form-data를 통한 전송이 아닙니다.");
					request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
					
				}
				
				// 3. 웹 상의 루트(최상위 경로) 경로를 활용해서 저장할 폴더의 위치 저장
				String root = request.getServletContext().getRealPath("/");
				// D:\webWorkspace\TMC\TESTSEMI\Web\resourse\adoptWantUploadFiles
				String savePath = root + "resourse/adoptWantUploadFiles";
				System.out.println("root : " + root);
				
				// 4. 실제 담아온 파일 기타 정보들을 활용하여
				//	MultipartRequest 생성
				//  request --> MultipartRequest
				
				MultipartRequest mrequest = new MultipartRequest(
													request,	// 변경하기 위한 원본 객체
													savePath,	// 파일 저장 경로
													maxSize,	// 저장할 파일의 최대크기
													"UTF-8",
													new DefaultFileRenamePolicy()
													
						);
				// 5-1. 기본 전송값 처리
				String title = mrequest.getParameter("adoptWnat_subject");
				String content = mrequest.getParameter("adoptWnat_content");
				String writer = mrequest.getParameter("adoptWnat_writer");
				
				// 5-2. 전송된 파일 처리하기
				String fileName = mrequest.getFilesystemName("file");
				
				// 6. 전송된 파일 VO에 담기
				AdoptWant aw = new AdoptWant();
				
				aw.setWiTitle(title);
				aw.setWiContent(content);
				aw.setWiWriter(writer);
				aw.setWiFileName(fileName);
				
				System.out.println(aw);
				
				// 7 서비스 결과 처리
				int result = new AdoptWantService().insertAdoptWant(aw);
				
				if(result>0) {
					response.sendRedirect("listAdoptW.ado");
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
