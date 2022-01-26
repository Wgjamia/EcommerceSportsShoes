package ly.algjamia.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ly.algjamia.model.SessionHistory;

@Repository
public interface SessionHistoryRepo extends CrudRepository<SessionHistory,Long> {
	
	
	@Query(nativeQuery=true,value="select h.* session_history h where h.sessionid=:sessionid")
	public SessionHistory findSessionHistoryBySessionId(@Param("sessionid") String sessionId);
	
	@Query(nativeQuery=true,value="update session_history set end_of_date=:endofdate where sessionid=:sessionid")
	public void updatEndOfDateSessionHistory(@Param("endofdate") Date endofdate,@Param("sessionid") String sessionId);
	
	@Query(nativeQuery=true, value=" SELECT u.username,u.full_name,u.email,s.date_of_login,s.time_of_login "
			+ " ,s.tools_of_login,s.device_of_login,s.ip_of_login,s.end_of_date  FROM users u  "
			+ " left JOIN session_history s on u.id=s.user_id WHERE u.username like %:keyword% "
			+ "")
	public List<Object> findLikeByKeyword(@Param("keyword") String keyword);

	
}
