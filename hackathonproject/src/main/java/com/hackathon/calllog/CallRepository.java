package com.hackathon.calllog;

import java.util.List;

import org.aspectj.weaver.ast.Call;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//@Repository
//public interface CallRepository extends JpaRepository<Callslog, Integer> {
@Repository
public interface CallRepository extends PagingAndSortingRepository<Callslog,Integer>
{
	@Query("SELECT MAX(log.id) FROM Callslog log")
	Integer getRecentId();
	
	@Query("SELECT new com.hackathon.calllog.Display(FLOOR(TIMESTAMPDIFF(SECOND,log.callStartTime,NOW())/(?1*60))*(?1),COUNT(*)) FROM Callslog log WHERE log.callStatus='unanswered' GROUP BY FLOOR(TIMESTAMPDIFF(SECOND,log.callStartTime,NOW())/(?1*60))*?1")
	public List<Display> getData(Integer t);
	
	@Query("SELECT new com.hackathon.calllog.Display(FLOOR(TIMESTAMPDIFF(SECOND,log.callStartTime,NOW())/(?1*60))*?1,COUNT(*)) FROM Callslog log WHERE TIME_TO_SEC(log.callDuration)>=?2 GROUP BY FLOOR(TIMESTAMPDIFF(SECOND,log.callStartTime,NOW())/(?1*60))*?1")
	public List<Display> getDataaa(Integer t,Integer d);
}
