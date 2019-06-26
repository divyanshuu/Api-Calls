package com.hackathon.controller;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.calllog.Callslog;
import com.hackathon.service.CallsService;

@RestController
public class CallsController {

	@Autowired
	CallsService service;
	
	@PostMapping("/calls")
	public void storeData(@RequestBody List<Callslog> calllog)
	{
		 service.createEntry(calllog);
	}
	
	@GetMapping("/maxid")
	public Integer getRecentId()
	{
		return service.getRecentId();
	}
	@GetMapping("/getdata/{time}/{status}/{duration}")
	public List getData(@PathVariable Integer time,@PathVariable String status,@PathVariable Integer duration)
	{
		return service.getData(time,status,duration);
	}
}
