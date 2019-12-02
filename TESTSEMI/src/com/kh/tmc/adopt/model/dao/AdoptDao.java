package com.kh.tmc.adopt.model.dao;

import java.io.FileInputStream;
import java.io.IOError;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.tmc.common.JDBCTemplate.*;

import com.kh.tmc.adopt.model.vo.Adopt;

public class AdoptDao {
	
	Properties prop = new Properties();
	public AdoptDao() {
		try {
			prop.load(new FileInputStream("/config/adopt-query.properties"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Adopt> selectAdopt(Connection con) {
		ArrayList<Adopt> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String sql = prop.getProperty("selectAdopt");
		try {
			list = new ArrayList<Adopt>();
			pstmt = con.prepareStatement(sql);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				list.add(new Adopt(rset.getInt("iBno"),
									rset.getString("iTitle"),
									rset.getString("iWriter"),
									rset.getDate("iWriteDate"),
									rset.getInt("iCount")
									));	
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
		}
		return list;
	}

}
