package com.POJOclasses;

public class Spouse {
	
	String spouseName;
	String spouseEmail;
	Long[] spousePhNo;
	public Spouse(String spouseName, String spouseEmail, Long[] spousePhNo) {
		super();
		this.spouseName = spouseName;
		this.spouseEmail = spouseEmail;
		this.spousePhNo = spousePhNo;
	}
	public Spouse() {
		
	}
	
	public String getSpouseName() {
		return spouseName;
	}
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}
	public String getSpouseEmail() {
		return spouseEmail;
	}
	public void setSpouseEmail(String spouseEmail) {
		this.spouseEmail = spouseEmail;
	}
	public Long[] getSpousePhNo() {
		return spousePhNo;
	}
	public void setSpousePhNo(Long[] spousePhNo) {
		this.spousePhNo = spousePhNo;
	}
	
	

}
