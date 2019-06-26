package com.hackathon.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hackathon.calllog.Callslog;


@Component
public class Crontab {

	 @Autowired
	    RestUtility util;
	    
	    @Scheduled(cron="*/5 * * * * *")
	    public void run() throws InterruptedException {
	        String recentID = util.getRecentId().toString();
	        if(recentID==null)
	        {
	        	List<Callslog> callLogs = util.getCallDTO();
		        util.addCallDTO(callLogs);
	        }
	        List<Callslog> callLogs = util.getRecentCalls(recentID);
	        util.addCallDTO(callLogs);
	        System.out.println("CRON SCRIPT");
	    }   
}
