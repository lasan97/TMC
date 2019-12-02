package com.kh.tmc.training.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.kh.tmc.training.model.Dao.TrainingDao;
import com.kh.tmc.training.model.vo.TrFile;
import com.kh.tmc.training.model.vo.TrainingBoard;
import static com.kh.tmc.common.JDBCTemplate.*;

public class TrainingService {
	
	private TrainingDao tDao = new TrainingDao();
	
	public int insertThumbnail(TrainingBoard t) {
		Connection con = getConnection();
		
		int result = 0;
		
		// 1. 썸네일 게시글 추가 쿼리 실행
		int result1 = tDao.insetThumbnail(con,t);
		
		if(result1>0) {
			commit(con);
			result =1;
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public ArrayList<TrainingBoard> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<TrainingBoard> list = tDao.selectList(con,currentPage,limit);
		
		close(con);
		
		return list;
	}

	public int getListCount() {
		Connection con = getConnection();
		int listCount = tDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public TrainingBoard selectThumbnailMap(int bno) {
		Connection con = getConnection();
		
		TrainingBoard tb = tDao.selectThumbnailMap(con,bno);
		
		
		close(con);
		
		return tb;
	}

	public void countUper(int bno) {
		Connection con = getConnection();
		int result = tDao.countUper(con,bno);
		if(result>0) {
			commit(con);
			result =1;
		}else {
			rollback(con);
		}
		close(con);
	}

	public int trDelete(int bno) {
		Connection con = getConnection();
		int result = 0;
		
		result = tDao.trDelete(con,bno);
		
		
		if(result>0) {
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
		
	}

	public int updateThumbnail(TrainingBoard t, int bno) {
		Connection con = getConnection();
		
		int result = 0;
		
		// 1. 썸네일 게시글 추가 쿼리 실행
		int result1 = tDao.updateThumbnail(con,t,bno);
		
		if(result1>0) {
			commit(con);
			result =1;
		}else {
			rollback(con);
		}
		close(con);
		
		return result;
	}

	public void LikeUper(int bno, String likers, int check) {
		Connection con = getConnection();
		int result = tDao.likeUper(con,bno,likers,check);
		if(result>0) {
			commit(con);
			
			System.out.println("성공");
		}else {
			rollback(con);
			System.out.println("실패");
		}
		close(con);
		
	}

	public ArrayList<TrainingBoard> searchSelectList(int currentPage, int limit, String searchName, int sType) {
		Connection con = getConnection();
		
		ArrayList<TrainingBoard> list = tDao.searchSelectList(con,currentPage,limit,searchName,sType);
		
		close(con);
		
		return list;
	}

}
