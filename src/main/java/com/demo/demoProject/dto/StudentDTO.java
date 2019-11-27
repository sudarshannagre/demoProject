package com.demo.demoProject.dto;


public class StudentDTO {
	
	private int id;
	
	private String name;
	
	private String address;
	
	private String mobileNo;
	
	private String className;
	
	private String branchName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo
				+ ", className=" + className + ", branchName=" + branchName + "]";
	}

}
