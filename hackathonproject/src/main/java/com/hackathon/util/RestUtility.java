   package com.hackathon.util;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.hackathon.calllog.CallsWrapper;
import com.hackathon.calllog.Callslog;

@Component
public class RestUtility {
	
	public List<Callslog> getCallDTO() {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.makaan.com/kira/data/v3/entity/call-log?filters=id=gt=70009";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<CallsWrapper> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, CallsWrapper.class, 1);
        CallsWrapper calls = responseEntity.getBody();
        
       // CallsWrapper calls = restTemplate.getForObject(url, CallsWrapper.class);
       // System.out.println("----------------");
        return calls.getData();
	}
	public List<Callslog> getRecentCalls(String ids)
	{
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
        String url = "https://www.makaan.com/kira/data/v3/entity/call-log?filters=id=gt="+ids;
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<CallsWrapper> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, CallsWrapper.class, 1);
        CallsWrapper calls = responseEntity.getBody();
        
       // CallsWrapper calls = restTemplate.getForObject(url, CallsWrapper.class);
       // System.out.println("----------------");
        return calls.getData();
	}
	
	
	public void addCallDTO(List<Callslog> callsDTOs) {
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/calls";
        HttpEntity<List<Callslog>> requestEntity = new HttpEntity<List<Callslog>>(callsDTOs,headers);
        URI uri =restTemplate.postForLocation(url, requestEntity);
       
	}
	
	public Integer getRecentId()
	{
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
		RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/maxid";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Integer> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Integer.class, 1);
        Integer calls = responseEntity.getBody();
        return calls;
	}


/*	public static void main(String args[]){
		
		RestUtility util=new RestUtility();
		List<Callslog> resultList = util.getCallDTO();
		System.out.println(resultList.get(0).getCallStatus());
		util.addCallDTO(resultList);
//		String in=util.getRecentId().toString();
//		util.getCallDTO(in);
		System.out.println("-----------------------------------");
	}   */
}
