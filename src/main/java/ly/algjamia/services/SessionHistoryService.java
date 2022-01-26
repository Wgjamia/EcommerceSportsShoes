package ly.algjamia.services;

import java.util.Date;
import java.util.List;

import ly.algjamia.model.SessionHistory;

public interface SessionHistoryService {

	public void save(SessionHistory sessionHistory);
	
	public SessionHistory findSessionHistoryBySessionId(String sessionId);
	
	public void updatEndOfDateSessionHistory(Date endOfdate,String sessionId);
	
	public List<Object> findLikeByKeyword(String keyword);
}
