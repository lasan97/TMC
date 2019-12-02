package com.kh.tmc.training.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class TrainingBoard implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1379087113990145200L;
	private int trBoardNo;
	private int trBno;
	private String trTitle;
	private String trWriter;
	private int trCount;
	private Date trDate;
	private String trContent;
	private String trImgName = "DEFAULT";
	private int trLike;
	private String trLikers = "";
	public TrainingBoard() {
		super();
	}
	public TrainingBoard(int trBno, String trTitle, String trWriter, int trCount, Date trDate, String trContent,
			String trImgAddress, int trLike) {
		super();
		this.trBno = trBno;
		this.trTitle = trTitle;
		this.trWriter = trWriter;
		this.trCount = trCount;
		this.trDate = trDate;
		this.trContent = trContent;
		this.trImgName = trImgAddress;
		this.trLike = trLike;
	}
	
	public String getTrLikers() {
		return trLikers;
	}
	public void setTrLikers(String trLikers) {
		this.trLikers = trLikers;
	}
	public int getTrBoardNo() {
		return trBoardNo;
	}
	public void setTrBoardNo(int trBoardNo) {
		this.trBoardNo = trBoardNo;
	}
	public int getTrBno() {
		return trBno;
	}
	public void setTrBno(int trBno) {
		this.trBno = trBno;
	}
	public String getTrTitle() {
		return trTitle;
	}
	public void setTrTitle(String trTitle) {
		this.trTitle = trTitle;
	}
	public String getTrWriter() {
		return trWriter;
	}
	public void setTrWriter(String trWriter) {
		this.trWriter = trWriter;
	}
	public int getTrCount() {
		return trCount;
	}
	public void setTrCount(int trCount) {
		this.trCount = trCount;
	}
	
	public Date getTrDate() {
		return trDate;
	}
	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}
	public String getTrContent() {
		return trContent;
	}
	public void setTrContent(String trContent) {
		this.trContent = trContent;
	}
	public String getTrImgName() {
		return trImgName;
	}
	public void setTrImgName(String trImgAddress) {
		this.trImgName = trImgAddress;
	}
	public int getTrLike() {
		return trLike;
	}
	public void setTrLike(int trLike) {
		this.trLike = trLike;
	}
	@Override
	public String toString() {
		return "trainingBoard [trBno=" + trBno + ", trTitle=" + trTitle + ", trWriter=" + trWriter + ", trCount="
				+ trCount + ", trDate=" + trDate + ", trContent=" + trContent + ", trImgAddress=" + trImgName
				+ ", trLike=" + trLike + "]";
	}
	
	
	
	
	
}
