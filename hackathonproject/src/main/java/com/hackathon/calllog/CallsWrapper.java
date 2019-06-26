package com.hackathon.calllog;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown=true)
public class CallsWrapper {

	List<Callslog> data ;

	public CallsWrapper() {
		// TODO Auto-generated constructor stub
	}

	public List<Callslog> getData() {
		return data;
	}

	public void setData(List<Callslog> data) {
		this.data = data;
	}
}
