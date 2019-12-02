package com.kh.tmc.adoptWant.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.tmc.adoptWant.model.vo.AdoptWant;
import static com.kh.tmc.common.JDBCTemplate.*;

public class AdoptWantDao {
	private Properties prop;
	
	public AdoptWantDao(){
		prop = new Properties();
		String filePath = 
				AdoptWantDao.class.getResource("/config/adoptWant-query.properties").getPath();
	
		try {
			prop.load(new FileReader(filePath));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}
	
	public ArrayList<AdoptWant> selectList(Connection con, int currentPage, int limit) {
		
		ArrayList<AdoptWant> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			// 1. 마지막 행의 번호
			// 2. 첫 행의 번호
			int startRow = (currentPage -1) * limit +1; //1
			
			int endRow = startRow + limit -1; // 10,20
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<AdoptWant>();
			
			while(rset.next()) {
				AdoptWant aw = new AdoptWant();
				
				aw.setWiBno(rset.getInt("WIBNO"));
				aw.setWiTitle(rset.getString("WITITLE"));
				aw.setWiContent(rset.getString("WICONTENT"));
				aw.setWiWriter(rset.getString("WIWRITER"));
				aw.setWiWriteDate(rset.getDate("WIWRITEDATE"));
				aw.setWiCount(rset.getInt("WICOUNT"));
				
//				System.out.println(aw);
				
				list.add(aw);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}
	
	public AdoptWant selectOne(Connection con, int wiBno) {
		AdoptWant aw = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,wiBno);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				aw = new AdoptWant();
				
				aw.setWiBno(rset.getInt("WIBNO"));
				aw.setWiTitle(rset.getString("WITITLE"));
				aw.setWiWriter(rset.getString("WIWRITER"));
				aw.setWiWriteDate(rset.getDate("WIWRITEDATE"));
				aw.setWiCount(rset.getInt("WICOUNT"));
				aw.setWiContent(rset.getString("WICONTENT"));
				aw.setWiFileName(rset.getString("WIFILENAME"));
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(rset);
			close(con);
		}
		
		return aw;
	}

	public int insertAdoptWant(Connection con, AdoptWant aw) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertAdoptWant");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, aw.getWiTitle());
			pstmt.setString(2, aw.getWiWriter());
			pstmt.setString(3, aw.getWiContent());
			pstmt.setString(4, aw.getWiFileName());
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateAdoptWant(Connection con, AdoptWant aw) {
		// TODO Auto-generated method stub
		int result= 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateAdoptWant");
		System.out.println("aw : "+aw);
		System.out.println(aw.getWiTitle());
		System.out.println(aw.getWiContent());
		System.out.println(aw.getWiBno());
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,aw.getWiTitle());
			pstmt.setString(2,aw.getWiContent());
			pstmt.setInt(3, aw.getWiBno());
			
			System.out.println(pstmt);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
}
