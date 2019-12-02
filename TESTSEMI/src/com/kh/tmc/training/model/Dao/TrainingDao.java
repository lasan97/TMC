package com.kh.tmc.training.model.Dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import com.kh.tmc.training.model.vo.TrainingBoard;
import static com.kh.tmc.common.JDBCTemplate.*;

public class TrainingDao {
	
	private Properties prop = new Properties();
	
	public TrainingDao(){
		String filePath = TrainingDao.class
				.getResource("/config/training-query.properties")
				.getPath();

		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
}

	public int insetThumbnail(Connection con, TrainingBoard t) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String sql = prop.getProperty("insertTraining");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getTrTitle());
			pstmt.setString(2, t.getTrWriter());
			pstmt.setString(3, t.getTrContent());
			pstmt.setString(4, t.getTrImgName());
			
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<TrainingBoard> selectList(Connection con,int currentPage, int limit) {
		ArrayList<TrainingBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt= con.prepareStatement(sql);
			
			int startRow =(currentPage -1) * limit +1; // 1 11
			int endRow = startRow + limit -1; // 10 , 20
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);			
			System.out.println(endRow+"/"+startRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<TrainingBoard>();
			
			while(rset.next()) {
				TrainingBoard tr = new TrainingBoard();
				tr.setTrBoardNo(rset.getInt("TRNO"));
				tr.setTrBno(rset.getInt("TRBNO"));
				tr.setTrTitle(rset.getString("TRTITLE"));
				tr.setTrWriter(rset.getString("TRWRITER"));
				tr.setTrCount(rset.getInt("TRCOUNT"));
				tr.setTrDate(rset.getDate("TRWRITEDATE"));
			
				tr.setTrImgName(rset.getString("TRIMGNAME"));
				tr.setTrLike(rset.getInt("TRLIKE"));
				
				list.add(tr);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int getListCount(Connection con) {
		// 총 게시글 수
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
			System.out.println(listCount);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	public TrainingBoard selectThumbnailMap(Connection con, int bno) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		TrainingBoard t = null;
		
		String sql = prop.getProperty("selectOne");
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,bno);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				t = new TrainingBoard();
				
				t.setTrBno(bno);
				t.setTrTitle(rset.getString("TRTITLE"));
				t.setTrWriter(rset.getString("TRWRITER"));
				t.setTrCount(rset.getInt("TRCOUNT"));
				t.setTrDate(rset.getDate("TRWRITEDATE"));			
				t.setTrContent(rset.getString("TRCONTENT"));
				t.setTrImgName(rset.getString("TRIMGNAME"));
				t.setTrLike(rset.getInt("TRLIKE"));
				t.setTrLikers(rset.getString("TRLIKERS"));
				
			}
			

			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return t;
	}

	public int countUper(Connection con, int bno) {
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("countUper");
		int result =0;

		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result=pstmt.executeUpdate();
	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;

	}

	public int trDelete(Connection con, int bno) {
		PreparedStatement pstmt = null;
		int result =0;
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int updateThumbnail(Connection con, TrainingBoard t, int bno) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String sql = prop.getProperty("updateTraining");
		System.out.println(sql);
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, t.getTrTitle());
			pstmt.setString(2, t.getTrContent());
			pstmt.setString(3, t.getTrImgName());
			pstmt.setInt(4, bno);
			
			result = pstmt.executeUpdate();
			System.out.println("1");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int likeUper(Connection con, int bno, String likers, int check) {
		PreparedStatement pstmt = null;
		String sql = null;
		
		if(check==1) {
			sql = prop.getProperty("likeUper");
		}else {
			sql = prop.getProperty("likeDown");
		}
		int result =0;
	
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, likers);
			pstmt.setInt(2, bno);
			
			result=pstmt.executeUpdate();
	
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;

	}

	public ArrayList<TrainingBoard> searchSelectList(Connection con, int currentPage, int limit, String searchName,
			int sType) {
		
		ArrayList<TrainingBoard> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = "";
		if(sType==1) {
			sql = prop.getProperty("TSearchList");
		}else {
			sql = prop.getProperty("WSearchList");
		}
		try {
			pstmt= con.prepareStatement(sql);
			
			int startRow =(currentPage -1) * limit +1; // 1 11
			int endRow = startRow + limit -1; // 10 , 20
			pstmt.setString(1, "%"+searchName+"%");
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);			
			System.out.println(endRow+"/"+startRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<TrainingBoard>();
			
			while(rset.next()) {
				TrainingBoard tr = new TrainingBoard();
				tr.setTrBoardNo(rset.getInt("TRNO"));
				tr.setTrBno(rset.getInt("TRBNO"));
				tr.setTrTitle(rset.getString("TRTITLE"));
				tr.setTrWriter(rset.getString("TRWRITER"));
				tr.setTrCount(rset.getInt("TRCOUNT"));
				tr.setTrDate(rset.getDate("TRWRITEDATE"));
			
				tr.setTrImgName(rset.getString("TRIMGNAME"));
				tr.setTrLike(rset.getInt("TRLIKE"));
				
				list.add(tr);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
