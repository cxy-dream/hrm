package com.first.hrm.bean;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Employee 数据传输类
 * @author Qxy
 * @email 1766181826@qq.com
 * @date 2019-10-16 15:38:33
 * @version 1.0
 */
public class EmployeeInfo implements java.io.Serializable{

	private int id;

	private String deptName;

	private String jobName;

	private String name;

	private String cardId;

	private String address;

	private String phone;

	private String email;

	private String sex;

	private String education;

	private String createDate;


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

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		if (sex==1){
			this.sex="男";
		}
		else if (sex==2){
			this.sex = "女";
		}
		else {
			this.sex=null;
		}
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String  getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}