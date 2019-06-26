package com.hackathon.calllog;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="caller_data")
public class Callslog {
	@Id
	@Column(name="id")
	private Integer id;
	
//	private String callType;
//	private Date callStartTime;
	
	@Column(name="call_start_time")
	private Date callStartTime;
	
	@Column(name="call_end_time")
	private Date callEndTime;
	
	@Column(name="call_status")
	private String callStatus;
	
	@Column(name="call_created_at")
	private Date createdAt;
	
	@Column(name="call_duration")
	private Time callDuration;

	public Callslog()
	{
		
	}
	

	public Time getCallDuration() {
		return callDuration;
	}


	public void setCallDuration(Time callDuration) {
		this.callDuration = callDuration;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCallStartTime() {
		return callStartTime;
	}

	public void setCallStartTime(Date callStartTime) {
		this.callStartTime = callStartTime;
	}

	public Date getCallEndTime() {
		return callEndTime;
	}

	public void setCallEndTime(Date callEndTime) {
		this.callEndTime = callEndTime;
	}

	public String getCallStatus() {
		return callStatus;
	}

	public void setCallStatus(String callStatus) {
		this.callStatus = callStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	

}
