package com.kh.tmc.member.model.service;

import static com.kh.tmc.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.tmc.member.model.dao.MemberDao;
import com.kh.tmc.member.model.vo.Member;

public class MemberService {

	public int signUp(Member m) {

		Connection con = getConnection();
		int result = new MemberDao().signUp(con, m);

		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);

		return result;
	}

	public Member SignIn(Member m) {

		Connection con = getConnection();

		m = new MemberDao().signIn(con, m);

		close(con);

		return m;
	}

}
