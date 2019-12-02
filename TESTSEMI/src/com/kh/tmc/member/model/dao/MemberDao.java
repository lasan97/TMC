package com.kh.tmc.member.model.dao;

import static com.kh.tmc.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import com.kh.tmc.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();

	public MemberDao() {
		String filePath = MemberDao.class.getResource("/config/member-query.properties").getPath();
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public int signUp(Connection con, Member m) {

		int result = 0;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("singUp");

		try {

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getUserPhone());
			pstmt.setString(5, m.getUserAddress());

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			close(pstmt);

		}

		return result;
	}

	public Member signIn(Connection con, Member m) {

		ResultSet rset = null;
		PreparedStatement pstmt = null;
		String sql = prop.getProperty("singIn");
		Member mem = null;
		try {

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());

			rset = pstmt.executeQuery();

			if (rset.next()) {

				mem = new Member();
				mem.setUserId(rset.getString("USERID"));
				mem.setUserPwd(rset.getString("USERPWD"));
				mem.setUserName(rset.getString("USERNAME"));
				mem.setUserPhone(rset.getString("USERPHONE"));
				mem.setUserAddress(rset.getString("USERADDRESS"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rset);
		}

		return mem;
	}

}
