package com.first.hrm.bean;

/**
 * Job 数据传输类
 * @author Qxy
 * @email 1766181826@qq.com
 * @date 2019-10-16 15:38:33
 * @version 1.0
 */
public class Job implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String remark;

	/** setter and getter method */
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}

}