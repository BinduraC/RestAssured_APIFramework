package com.POJOclasses;

public class Doctor {
	
	String doctorName;
	int doctorID;
	String doctorEmail;
	Long[] doctorPhNo;
	Spouse doctorSpouseDetails;
	
	
	public Doctor(String doctorName, int doctorID, String doctorEmail, Long[] doctorPhNo, Spouse doctorSpouseDetails) {
		super();
		this.doctorName = doctorName;
		this.doctorID = doctorID;
		this.doctorEmail = doctorEmail;
		this.doctorPhNo = doctorPhNo;
		this.doctorSpouseDetails = doctorSpouseDetails;
	}

	public Doctor() {
		
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public String getDoctorEmail() {
		return doctorEmail;
	}

	public void setDoctorEmail(String doctorEmail) {
		this.doctorEmail = doctorEmail;
	}

	public Long[] getDoctorPhNo() {
		return doctorPhNo;
	}

	public void setDoctorPhNo(Long[] doctorPhNo) {
		this.doctorPhNo = doctorPhNo;
	}

	public Spouse getDoctorSpouseDetails() {
		return doctorSpouseDetails;
	}

	public void setDoctorSpouseDetails(Spouse doctorSpouseDetails) {
		this.doctorSpouseDetails = doctorSpouseDetails;
	}

	
	 

}
