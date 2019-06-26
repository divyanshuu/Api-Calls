package com.hackathon.calllog;

import java.util.Date;

public class Display {
	
	int Interval;
	Long count;
	public int getInterval() {
		return Interval;
	}
	public void setInterval(int interval) {
		Interval = interval;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	public Display(int interval, Long count) {
		super();
		Interval = interval;
		this.count = count;
	}
	public Display() {
		// TODO Auto-generated constructor stub
	}
	

}
