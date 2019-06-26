package com.hackathon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hackathon.calllog.CallRepository;
import com.hackathon.calllog.Callslog;



@Service
public class CallsService {
	@Autowired
	CallRepository repository;
	
	public void createEntry(List<Callslog> calllog){
		
		repository.save(calllog);
	}
	public Integer getRecentId() {
//		return 10;
		return repository.getRecentId();
	}
	public List getData(Integer t,String status,Integer d)
	{
	//	return repository.getData(t);
		if(status=="unanswered"&&d==0)
		{
			
			return repository.getData(t);
		}
		else {
			return repository.getDataaa(t,d);
		}
		
	}

}
