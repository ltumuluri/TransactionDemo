package com.java.assignment.bean;


public class Response {
	
	private Integer id;
	private String month;
	private Integer points;
	public Response() {
		super();
	}
	public Response(Integer id, String month, Integer points) {
		super();
		this.id = id;
		this.month = month;
		this.points = points;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public Integer getPoints() {
		return points;
	}
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	
	

}
