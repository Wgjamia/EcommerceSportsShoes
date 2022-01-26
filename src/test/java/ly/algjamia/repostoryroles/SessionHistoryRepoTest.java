package ly.algjamia.repostoryroles;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Time;
import java.util.Date;



import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.annotation.Rollback;

import ly.algjamia.model.SessionHistory;

import ly.algjamia.repository.SessionHistoryRepo;
import ly.algjamia.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class SessionHistoryRepoTest {
	@Autowired
	SessionHistoryRepo sessionHistoryRepo;
	@Autowired
	UserRepository userRepository;
	
 
	@Test
	
	public void insertSessionHistory(SessionHistory sessionHistory) {
		
		MockHttpServletRequest request = new MockHttpServletRequest();
		sessionHistory.setDateOfLogin(new Date());
		sessionHistory.setTimeOfLogin(new Time(0));
		sessionHistory.setDeviceOfLogin(request.getLocalName());
		sessionHistory.setIPOfLogin(request.getLocalAddr());
		sessionHistory.setToolsOfLogin(request.getHeader("User-Agent"));
		String UserName = request.getUserPrincipal().getName();
		assertThat(UserName).isNotEmpty();
		sessionHistory.setUsers(userRepository.findByUsername(UserName));
		sessionHistoryRepo.save(sessionHistory);
		assertThat(sessionHistory).isEqualTo(1);
		
		
		
		
	}

}
