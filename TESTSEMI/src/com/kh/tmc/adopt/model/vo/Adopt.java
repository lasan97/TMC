package com.kh.tmc.adopt.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Adopt implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -205189695505130138L;
	
	private int iBno;
	private String iTitle;
	private String iWriter;
	private Date iWriteDate;
	private int iCount;
	private String iContent;
	private String shelterName;
	
	public Adopt() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getShelterName() {
		return shelterName;
	}
	public void setShelterName(String shelterName) {
		this.shelterName = shelterName;
	}
	public int getiBno() {
		return iBno;
	}
	public void setiBno(int iBno) {
		this.iBno = iBno;
	}
	public String getiTitle() {
		return iTitle;
	}
	public void setiTitle(String iTitle) {
		this.iTitle = iTitle;
	}
	public String getiWriter() {
		return iWriter;
	}
	public void setiWriter(String iWriter) {
		this.iWriter = iWriter;
	}
	public Date getiWriteDate() {
		return iWriteDate;
	}
	public void setiWriteDate(Date iWriteDate) {
		this.iWriteDate = iWriteDate;
	}
	public int getiCount() {
		return iCount;
	}
	public void setiCount(int iCount) {
		this.iCount = iCount;
	}
	public String getiContent() {
		return iContent;
	}
	public void setiContent(String iContent) {
		this.iContent = iContent;
	}
	
	public Adopt(int iBno, String iTitle, String iWriter, Date iWriteDate, int iCount) {
		super();
		this.iBno = iBno;
		this.iTitle = iTitle;
		this.iWriter = iWriter;
		this.iWriteDate = iWriteDate;
		this.iCount = iCount;
	}
	
	public Adopt(int iBno, String iTitle, String iWriter, Date iWriteDate, int iCount, String iContent, String shelterName) {
		super();
		this.iBno = iBno;
		this.iTitle = iTitle;
		this.iWriter = iWriter;
		this.iWriteDate = iWriteDate;
		this.iCount = iCount;
		this.iContent = iContent;
		this.shelterName = shelterName;
	}
	@Override
	public String toString() {
		return "Ipyang [iBno=" + iBno + ", iTitle=" + iTitle + ", iWriter=" + iWriter + ", iWriteDate=" + iWriteDate
				+ ", iCount=" + iCount + ", iContent=" + iContent + ", shelterName=" + shelterName + "]";
	}
	
	
}
