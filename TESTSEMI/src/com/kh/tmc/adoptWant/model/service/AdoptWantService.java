package com.kh.tmc.adoptWant.model.service;



import static com.kh.tmc.common.JDBCTemplate.close;
import static com.kh.tmc.common.JDBCTemplate.commit;
import static com.kh.tmc.common.JDBCTemplate.getConnection;
import static com.kh.tmc.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.tmc.adoptWant.model.dao.AdoptWantDao;
import com.kh.tmc.adoptWant.model.vo.AdoptWant;

public class AdoptWantService {
	private AdoptWantDao awDao = new AdoptWantDao();
	
	public int getListCount() {
		Connection con = getConnection();
		int listCount = awDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public ArrayList<AdoptWant> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<AdoptWant> list = awDao.selectList(con, currentPage, limit);
		
		close(con);
		
		return list;
		
	}
	
	public AdoptWant selectOne(int wibno) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		AdoptWant bo = awDao.selectOne(con,wibno); 
				
		close(con);
		
		return bo;
	}

	public int insertAdoptWant(AdoptWant aw) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		int result = awDao.insertAdoptWant(con, aw);
		
		if(result>0)commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateAdoptWant(AdoptWant aw) {
		Connection con = getConnection();
		System.out.println("dao이전");
		
		int result = awDao.updateAdoptWant(con,aw);
		System.out.println(result+"dao이후");
		
		if(result>0)commit(con);
		else rollback(con);
		
		return result;
	}

	public AdoptWant updateView(int wiBno) {
		Connection con = getConnection();
		
		AdoptWant aw = awDao.selectOne(con, wiBno);
		
		close(con);
		return aw;
	}
	
	
	
	
	
}
