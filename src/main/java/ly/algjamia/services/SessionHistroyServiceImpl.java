package ly.algjamia.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ly.algjamia.model.SessionHistory;
import ly.algjamia.repository.SessionHistoryRepo;

@Service
public class SessionHistroyServiceImpl implements SessionHistoryService {
	
	@Autowired
	private SessionHistoryRepo sessionHistoryRepo;

	@Override
	public void save(SessionHistory sessionHistory) {
		sessionHistoryRepo.save(sessionHistory);
		
	}

	@Override
	public void updatEndOfDateSessionHistory(Date endOfdate, String sessionId) {
		sessionHistoryRepo.updatEndOfDateSessionHistory(endOfdate, sessionId);
		
	}

	@Override
	public List<Object> findLikeByKeyword(String keyword) {
		return sessionHistoryRepo.findLikeByKeyword(keyword);
	}

	@Override
	public SessionHistory findSessionHistoryBySessionId(String sessionId) {
		return sessionHistoryRepo.findSessionHistoryBySessionId(sessionId);
	}

}
