package com.kh.tmc.adopt.model.service;

import static com.kh.tmc.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.tmc.adopt.model.dao.AdoptDao;
import com.kh.tmc.adopt.model.vo.Adopt;

public class AdoptService {
	private Connection con = getConnection();
	AdoptDao adao = null;
	
	public ArrayList<Adopt> selectAdopt() {
		ArrayList<Adopt> list = null;
		list = adao.selectAdopt(con);
		
		return list;
	}



}
