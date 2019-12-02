package com.kh.tmc.adoptWant.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class AdoptWant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7402647257507879138L;
	
	private int wiBno;
	private String wiTitle;
	private String wiWriter;
	private Date wiWriteDate;
	private int wiCount;
	private String wiContent;
	private String wiFileName;
	
	public AdoptWant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getWiFileName() {
		return wiFileName;
	}

	public void setWiFileName(String wiFileName) {
		this.wiFileName = wiFileName;
	}


	public int getWiBno() {
		return wiBno;
	}
	
	public void setWiBno(int wiBno) {
		this.wiBno = wiBno;
	}

	public String getWiTitle() {
		return wiTitle;
	}

	public void setWiTitle(String wiTitle) {
		this.wiTitle = wiTitle;
	}

	public String getWiWriter() {
		return wiWriter;
	}

	public void setWiWriter(String wiWriter) {
		this.wiWriter = wiWriter;
	}

	public Date getWiWriteDate() {
		return wiWriteDate;
	}

	public void setWiWriteDate(Date wiWriteDate) {
		this.wiWriteDate = wiWriteDate;
	}

	public int getWiCount() {
		return wiCount;
	}

	public void setWiCount(int wiCount) {
		this.wiCount = wiCount;
	}

	public String getWiContent() {
		return wiContent;
	}

	public void setWiContent(String wiContent) {
		this.wiContent = wiContent;
	}

	public AdoptWant(int wiBno, String wiTitle, String wiWriter, Date wiWriteDate, int wiCount, String wiContent) {
		super();
		this.wiBno = wiBno;
		this.wiTitle = wiTitle;
		this.wiWriter = wiWriter;
		this.wiWriteDate = wiWriteDate;
		this.wiCount = wiCount;
		this.wiContent = wiContent;
	}
	

	public AdoptWant(int wiBno, String wiTitle, String wiWriter, Date wiWriteDate, int wiCount) {
		super();
		this.wiBno = wiBno;
		this.wiTitle = wiTitle;
		this.wiWriter = wiWriter;
		this.wiWriteDate = wiWriteDate;
		this.wiCount = wiCount;
	}
	
	

	public AdoptWant(int wiBno, String wiTitle, String wiWriter, Date wiWriteDate, int wiCount, String wiContent,
			String wiFileName) {
		super();
		this.wiBno = wiBno;
		this.wiTitle = wiTitle;
		this.wiWriter = wiWriter;
		this.wiWriteDate = wiWriteDate;
		this.wiCount = wiCount;
		this.wiContent = wiContent;
		this.wiFileName = wiFileName;
	}

	@Override
	public String toString() {
		return "AdoptWant [wiBno=" + wiBno + ", wiTitle=" + wiTitle + ", wiWriter=" + wiWriter + ", wiWriteDate="
				+ wiWriteDate + ", wiCount=" + wiCount + ", wiContent=" + wiContent + ", wiFileName=" + wiFileName
				+ "]";
	}


	
	
	
	
	
	
}
