package com.kh.tmc.training.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.tmc.common.MyRenamePolicy;
import com.kh.tmc.training.model.service.TrainingService;
import com.kh.tmc.training.model.vo.TrainingBoard;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class UpdateTrainingServlet
 */
@WebServlet("/trUpdateSave.tr")
public class UpdateSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateSaveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainingService ts = new TrainingService();

		if (!ServletFileUpload.isMultipartContent(request)) {
			// 만약 multipart/form-data로 보내지 않았으면 에러 발생!!!!!!!!!
			request.setAttribute("msg", "multipart/form-data형식으로 전송해야 합니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}

		// 1. 전송할 파일의 크기를 설정
		int maxSize = 1024 * 1024 * 10;

		// 2. 저장할 경로 설정하기
		String root= request.getServletContext().getRealPath("/resourse");
		
		String savePath = root+"/trainingImg";

		MultipartRequest mrequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());

		// 변경된 파일명
		String saveFiles = new String();

		Enumeration<String> files = mrequest.getFileNames();

		while (files.hasMoreElements()) {
			// 각 파일의 정보를 가져와 DB에 저장
			String name = files.nextElement();
			System.out.println("name : " + name);
			saveFiles=(mrequest.getFilesystemName(name));
		}
		
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		// Thumbnail VO 객체 생성 -> DB에 전달
		TrainingBoard t = new TrainingBoard();
		
		t.setTrTitle(mrequest.getParameter("boardT"));
		t.setTrContent(mrequest.getParameter("content"));
		t.setTrWriter(mrequest.getParameter("userId"));
		if(saveFiles == null) {
			saveFiles=mrequest.getParameter("UpMainImg");
		}
		t.setTrImgName(saveFiles);
		
		String[] allName=mrequest.getParameter("imgNames").split(",");
		String[] saveName=mrequest.getParameter("deletImg").split(",");

		System.out.println(saveName.length);
		System.out.println(allName.length);
		
		
		for(int i=0;i<saveName.length;i++) {
			for(int j=0; j<allName.length; j++) {
			
				if(saveName[i].equals(allName[j])) {
					allName[j]="N";
					System.out.println(allName[j]);
					System.out.println("test");
				}
				
			}	
		}
		for (int i = 0; i < allName.length; i++) {
			if(allName[i]!="N") {
			File file = new File(savePath +"/"+ allName[i]);
			}
		}
		
		int result = ts.updateThumbnail(t,bno);

		if (result > 0) {
			response.sendRedirect("trSelectList.tr");
		} else {
			request.setAttribute("msg", "파일 전송 실패!");
			File file = new File(savePath +"/"+ saveFiles);
			if(!saveFiles.equals("i.png")) {
			System.out.println("파일 삭제 확인 : " + file.delete());
			}
			// 이전 파일 정보 삭제하기
						for (int i = 0; i < saveName.length; i++) {
							file = new File(savePath +"/"+saveName[i]);
							System.out.println("파일 삭제 확인 : " + file.delete());
						}
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
